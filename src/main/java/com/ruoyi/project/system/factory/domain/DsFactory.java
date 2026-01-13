package com.ruoyi.project.system.factory.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工厂信息对象 ds_factory
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsFactory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private Long factoryid;

    /** 工厂名字 */
    @Excel(name = "工厂名字")
    private String factoryname;

    public void setFactoryid(Long factoryid) 
    {
        this.factoryid = factoryid;
    }

    public Long getFactoryid() 
    {
        return factoryid;
    }
    public void setFactoryname(String factoryname) 
    {
        this.factoryname = factoryname;
    }

    public String getFactoryname() 
    {
        return factoryname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("factoryid", getFactoryid())
            .append("factoryname", getFactoryname())
            .toString();
    }
}
