package com.ruoyi.project.system.partpurchase.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * partpurchase对象 ds_partpurchase
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsPartpurchase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 采购时间 */
    @Excel(name = "采购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date purchasedate;

    /** 采购数量 */
    @Excel(name = "采购数量")
    private Integer purchasenumer;

    /** 备件规格 */
    @Excel(name = "备件规格")
    private String purchasesize;

    /** 备件型号 */
    @Excel(name = "备件型号")
    private String purchasetype;

    /** 备件名称 */
    @Excel(name = "备件名称")
    private String purchasename;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long serviceorderid;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplierid;

    /** 中心ID */
    @Excel(name = "中心ID")
    private Long centerid;

    /** 采购ID */
    private Integer purchaseid;

    public void setPurchasedate(Date purchasedate) 
    {
        this.purchasedate = purchasedate;
    }

    public Date getPurchasedate() 
    {
        return purchasedate;
    }
    public void setPurchasenumer(Integer purchasenumer) 
    {
        this.purchasenumer = purchasenumer;
    }

    public Integer getPurchasenumer() 
    {
        return purchasenumer;
    }
    public void setPurchasesize(String purchasesize) 
    {
        this.purchasesize = purchasesize;
    }

    public String getPurchasesize() 
    {
        return purchasesize;
    }
    public void setPurchasetype(String purchasetype) 
    {
        this.purchasetype = purchasetype;
    }

    public String getPurchasetype() 
    {
        return purchasetype;
    }
    public void setPurchasename(String purchasename) 
    {
        this.purchasename = purchasename;
    }

    public String getPurchasename() 
    {
        return purchasename;
    }
    public void setServiceorderid(Long serviceorderid) 
    {
        this.serviceorderid = serviceorderid;
    }

    public Long getServiceorderid() 
    {
        return serviceorderid;
    }
    public void setSupplierid(Long supplierid) 
    {
        this.supplierid = supplierid;
    }

    public Long getSupplierid() 
    {
        return supplierid;
    }
    public void setCenterid(Long centerid) 
    {
        this.centerid = centerid;
    }

    public Long getCenterid() 
    {
        return centerid;
    }
    public void setPurchaseid(Integer purchaseid) 
    {
        this.purchaseid = purchaseid;
    }

    public Integer getPurchaseid() 
    {
        return purchaseid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("purchasedate", getPurchasedate())
            .append("purchasenumer", getPurchasenumer())
            .append("purchasesize", getPurchasesize())
            .append("purchasetype", getPurchasetype())
            .append("purchasename", getPurchasename())
            .append("serviceorderid", getServiceorderid())
            .append("supplierid", getSupplierid())
            .append("centerid", getCenterid())
            .append("purchaseid", getPurchaseid())
            .toString();
    }
}
