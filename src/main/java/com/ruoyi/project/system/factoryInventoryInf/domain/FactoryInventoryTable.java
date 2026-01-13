package com.ruoyi.project.system.factoryInventoryInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工厂库存对象 factory_inventory_table
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public class FactoryInventoryTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private String factoryid;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialid;

    /** 预警状态 */
    @Excel(name = "预警状态")
    private String alertstatus;

    /** 入库地点描述 */
    @Excel(name = "入库地点描述")
    private String storagelocationdec;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private String inventoryamount;

    /** 库存编号 */
    @Excel(name = "库存编号")
    private String inventoryid;

    /** 序号 */
    private Long id;

    public void setFactoryid(String factoryid) 
    {
        this.factoryid = factoryid;
    }

    public String getFactoryid() 
    {
        return factoryid;
    }
    public void setMaterialid(String materialid) 
    {
        this.materialid = materialid;
    }

    public String getMaterialid() 
    {
        return materialid;
    }
    public void setAlertstatus(String alertstatus) 
    {
        this.alertstatus = alertstatus;
    }

    public String getAlertstatus() 
    {
        return alertstatus;
    }
    public void setStoragelocationdec(String storagelocationdec) 
    {
        this.storagelocationdec = storagelocationdec;
    }

    public String getStoragelocationdec() 
    {
        return storagelocationdec;
    }
    public void setInventoryamount(String inventoryamount) 
    {
        this.inventoryamount = inventoryamount;
    }

    public String getInventoryamount() 
    {
        return inventoryamount;
    }
    public void setInventoryid(String inventoryid) 
    {
        this.inventoryid = inventoryid;
    }

    public String getInventoryid() 
    {
        return inventoryid;
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
            .append("factoryid", getFactoryid())
            .append("materialid", getMaterialid())
            .append("alertstatus", getAlertstatus())
            .append("storagelocationdec", getStoragelocationdec())
            .append("inventoryamount", getInventoryamount())
            .append("inventoryid", getInventoryid())
            .append("id", getId())
            .toString();
    }
}
