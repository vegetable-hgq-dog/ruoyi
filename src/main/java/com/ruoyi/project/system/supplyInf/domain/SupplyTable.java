package com.ruoyi.project.system.supplyInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 供应信息对象 supply_table
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public class SupplyTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderid;

    /** 收货状态 */
    @Excel(name = "收货状态")
    private String receiptstatus;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialid;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String suppliername;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierid;

    /** 序号 */
    private Long id;

    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
    }
    public void setReceiptstatus(String receiptstatus) 
    {
        this.receiptstatus = receiptstatus;
    }

    public String getReceiptstatus() 
    {
        return receiptstatus;
    }
    public void setMaterialid(String materialid) 
    {
        this.materialid = materialid;
    }

    public String getMaterialid() 
    {
        return materialid;
    }
    public void setSuppliername(String suppliername) 
    {
        this.suppliername = suppliername;
    }

    public String getSuppliername() 
    {
        return suppliername;
    }
    public void setSupplierid(String supplierid) 
    {
        this.supplierid = supplierid;
    }

    public String getSupplierid() 
    {
        return supplierid;
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
            .append("orderid", getOrderid())
            .append("receiptstatus", getReceiptstatus())
            .append("materialid", getMaterialid())
            .append("suppliername", getSuppliername())
            .append("supplierid", getSupplierid())
            .append("id", getId())
            .toString();
    }
}
