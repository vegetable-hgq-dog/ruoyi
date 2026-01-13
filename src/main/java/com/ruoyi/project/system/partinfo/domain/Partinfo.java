package com.ruoyi.project.system.partinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 零部件信息对象 partinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Partinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 零部件ID */
    private Long partid;

    /** 零部件名称 */
    @Excel(name = "零部件名称")
    private String partname;

    /** 零部件类型 */
    @Excel(name = "零部件类型")
    private String parttype;

    public void setPartid(Long partid) 
    {
        this.partid = partid;
    }

    public Long getPartid() 
    {
        return partid;
    }
    public void setPartname(String partname) 
    {
        this.partname = partname;
    }

    public String getPartname() 
    {
        return partname;
    }
    public void setParttype(String parttype) 
    {
        this.parttype = parttype;
    }

    public String getParttype() 
    {
        return parttype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("partid", getPartid())
            .append("partname", getPartname())
            .append("parttype", getParttype())
            .toString();
    }
}
