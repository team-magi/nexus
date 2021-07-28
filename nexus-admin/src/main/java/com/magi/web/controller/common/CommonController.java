package com.magi.web.controller.common;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.magi.common.config.NexusConfig;
import com.magi.common.config.ServerConfig;
import com.magi.common.constant.Constants;
import com.magi.common.core.domain.AjaxResult;
import com.magi.common.core.domain.FileInfo;
import com.magi.common.utils.StringUtils;
import com.magi.common.utils.file.FileUploadUtils;
import com.magi.common.utils.file.FileUtils;

/**
 * 通用请求处理
 *
 * @author nexus
 */
@Controller
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;


    /**
     * 通用上传请求（单个）
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = NexusConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求（多个）
     */
    @PostMapping("/common/uploads")
    @ResponseBody
    public AjaxResult uploadFiles(List<MultipartFile> files) throws Exception {
        try {
            // 上传文件路径
            String filePath = NexusConfig.getUploadPath();
            List<FileInfo> fileInfos = new LinkedList<FileInfo>();
            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                fileInfos.add(new FileInfo(fileName, url));
            }
            return AjaxResult.success(fileInfos);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }


    //-------------------------已屏蔽下载接口----------------------------------------------
    /**
     * 若依CMS通用下载实现方法存在任意文件下载漏洞

     * 1.从此链接下载文件获取宝塔面板入口地址
     * http://127.0.0.1:7099/common/download/resource?resource=/profile/../../../../www/server/panel/data/admin_path.pl
     * 2.从此链接下载文件获取宝塔登录成功日志中的用户名
     * http://127.0.0.1:7099/common/download/resource?resource=/profile/../../../../www/server/panel/data/default.db
     * 3.从此链接下载文件获取宝塔面板登录的密码
     * http://127.0.0.1:7099/common/download/resource?resource=/profile/../../../../www/server/panel/default.pl
     *
     * 正式环境如果安装了宝塔软件,通过默认端口8888,  地址http://XXX.X.X.X:8888 加上第1步获取到的地址, 使用第2和3步获取的账号密码能登录宝塔,进行服务器的操作
     *
     */


    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
//    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = NexusConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 本地资源通用下载
     */
//    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = NexusConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

}
