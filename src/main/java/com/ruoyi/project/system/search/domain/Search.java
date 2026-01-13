package com.ruoyi.project.system.search.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 搜索数据对象 search
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
public class Search extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String datatype;

    /** 数据内容 */
    @Excel(name = "数据内容")
    private String datacontext;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updata;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDatatype(String datatype) 
    {
        this.datatype = datatype;
    }

    public String getDatatype() 
    {
        return datatype;
    }
    public void setDatacontext(String datacontext) 
    {
        this.datacontext = datacontext;
    }

    public String getDatacontext() 
    {
        return datacontext;
    }
    public void setUpdata(Date updata) 
    {
        this.updata = updata;
    }

    public Date getUpdata() 
    {
        return updata;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("datatype", getDatatype())
            .append("datacontext", getDatacontext())
            .append("updata", getUpdata())
            .toString();
    }
}
