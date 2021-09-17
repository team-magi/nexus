package com.magi.web.controller.nft;

import com.magi.common.annotation.Log;
import com.magi.common.core.controller.BaseController;
import com.magi.common.core.domain.AjaxResult;
import com.magi.common.core.page.TableDataInfo;
import com.magi.common.enums.BusinessType;
import com.magi.common.utils.poi.ExcelUtil;

import com.magi.nft.domain.NftList;
import com.magi.nft.service.INftListService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * nft藏品列Controller
 *
 * @author nexus
 * @date 2021-09-09
 */
@Controller
@RequestMapping("/nft/list")
public class NftListController extends BaseController {
    private final String prefix = "nft/list";

    @Autowired
    private INftListService nftListService;

    @RequiresPermissions("nft:list:view")
    @GetMapping()
    public String list() {
        return prefix + "/list";
    }

    /**
     * 查询nft藏品列列表
     */
    @RequiresPermissions("nft:list:list")
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(NftList nftList) {
        startPage();
        List<NftList> list = nftListService.selectNftListList(nftList);
        return getDataTable(list);
    }

    /**
     * 导出nft藏品列列表
     */
    @RequiresPermissions("nft:list:export")
    @Log(title = "nft藏品列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NftList nftList) {
        List<NftList> list = nftListService.selectNftListList(nftList);
        ExcelUtil<NftList> util = new ExcelUtil<NftList>(NftList.class);
        return util.exportExcel(list, "nft藏品列数据");
    }

    /**
     * 新增nft藏品列
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存nft藏品列
     */
    @RequiresPermissions("nft:list:add")
    @Log(title = "nft藏品列", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NftList nftList) {
        return toAjax(nftListService.insertNftList(nftList));
    }

    /**
     * 修改nft藏品列
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        NftList nftList = nftListService.selectNftListById(id);
        mmap.put("nftList", nftList);
        return prefix + "/edit";
    }

    /**
     * 修改保存nft藏品列
     */
    @RequiresPermissions("nft:list:edit")
    @Log(title = "nft藏品列", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NftList nftList) {
        return toAjax(nftListService.updateNftList(nftList));
    }

    /**
     * 删除nft藏品列
     */
    @RequiresPermissions("nft:list:remove")
    @Log(title = "nft藏品列", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(nftListService.deleteNftListByIds(ids));
    }

}
