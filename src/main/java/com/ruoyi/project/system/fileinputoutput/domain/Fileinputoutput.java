package com.ruoyi.project.system.fileinputoutput.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文件导入导出测试对象 fileinputoutput
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public class Fileinputoutput extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 路径 */
    @Excel(name = "路径")
    private String filepath;

    /** 文件名 */
    @Excel(name = "文件名")
    private String filename;

    /** 序号 */
    private Long fileid;

    public void setFilepath(String filepath) 
    {
        this.filepath = filepath;
    }

    public String getFilepath() 
    {
        return filepath;
    }
    public void setFilename(String filename) 
    {
        this.filename = filename;
    }

    public String getFilename() 
    {
        return filename;
    }
    public void setFileid(Long fileid) 
    {
        this.fileid = fileid;
    }

    public Long getFileid() 
    {
        return fileid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("filepath", getFilepath())
            .append("filename", getFilename())
            .append("fileid", getFileid())
            .toString();
    }
}
