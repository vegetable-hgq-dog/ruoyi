package com.ruoyi.project.system.factoryInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工厂信息对象 factory_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class FactoryTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配送工位 */
    @Excel(name = "配送工位")
    private String deliverystation;

    /** 工程地址 */
    @Excel(name = "工程地址")
    private String projectaddress;

    /** 工厂名称 */
    @Excel(name = "工厂名称")
    private String factoryname;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private String factoryid;

    /** 序号 */
    private Long id;

    public void setDeliverystation(String deliverystation) 
    {
        this.deliverystation = deliverystation;
    }

    public String getDeliverystation() 
    {
        return deliverystation;
    }
    public void setProjectaddress(String projectaddress) 
    {
        this.projectaddress = projectaddress;
    }

    public String getProjectaddress() 
    {
        return projectaddress;
    }
    public void setFactoryname(String factoryname) 
    {
        this.factoryname = factoryname;
    }

    public String getFactoryname() 
    {
        return factoryname;
    }
    public void setFactoryid(String factoryid) 
    {
        this.factoryid = factoryid;
    }

    public String getFactoryid() 
    {
        return factoryid;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deliverystation", getDeliverystation())
            .append("projectaddress", getProjectaddress())
            .append("factoryname", getFactoryname())
            .append("factoryid", getFactoryid())
            .append("id", getId())
            .toString();
    }
}
