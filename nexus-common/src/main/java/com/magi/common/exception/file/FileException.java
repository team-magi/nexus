package com.magi.common.exception.file;

import com.magi.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author nexus
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
