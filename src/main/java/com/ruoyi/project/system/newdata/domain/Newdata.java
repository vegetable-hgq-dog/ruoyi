package com.ruoyi.project.system.newdata.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 最新数据对象 newdata
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
public class Newdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 数据类型 */
    @Excel(name = "数据类型")
    private String datatype;

    /** 数据内容 */
    @Excel(name = "数据内容")
    private String datacontent;

    /** 更新时间 */
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uptime;

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
    public void setDatacontent(String datacontent) 
    {
        this.datacontent = datacontent;
    }

    public String getDatacontent() 
    {
        return datacontent;
    }
    public void setUptime(Date uptime) 
    {
        this.uptime = uptime;
    }

    public Date getUptime() 
    {
        return uptime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("datatype", getDatatype())
            .append("datacontent", getDatacontent())
            .append("uptime", getUptime())
            .toString();
    }
}
