package com.ruoyi.project.system.orderInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 订单信息对象 order_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class OrderTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private String factoryid;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialid;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierid;

    /** 结算状态 */
    @Excel(name = "结算状态", readConverterExp = "1=√，2=×", prompt = "输入1表示√状态，输入2表示×状态")
    private String settlementstatus;

    /** 下发状态 */
    @Excel(name = "下发状态")
    private String orderdeliverystate;

    /** 交货时间 */
    @Excel(name = "交货时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date deliverydate;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date dateofordermake;

    /** 剩余数量 */
    @Excel(name = "剩余数量")
    private String leftuseamount;

    /** 已用数量 */
    @Excel(name = "已用数量")
    private String hasusedamount;

    /** 计划数量 */
    @Excel(name = "计划数量")
    private String planuseamount;

    /** 订单类型 */
    @Excel(name = "订单类型", readConverterExp = "1=PO单", prompt = "1=PO单" )
    private String ordertype;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderid;

    /** 序号 */
    private Long id;



    private Double materialAmount;

    private Double supplierAmount;

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
    public void setSupplierid(String supplierid) 
    {
        this.supplierid = supplierid;
    }

    public String getSupplierid() 
    {
        return supplierid;
    }
    public void setSettlementstatus(String settlementstatus) 
    {
        this.settlementstatus = settlementstatus;
    }

    public String getSettlementstatus() 
    {
        return settlementstatus;
    }
    public void setOrderdeliverystate(String orderdeliverystate) 
    {
        this.orderdeliverystate = orderdeliverystate;
    }

    public String getOrderdeliverystate() 
    {
        return orderdeliverystate;
    }
    public void setDeliverydate(Date deliverydate) 
    {
        this.deliverydate = deliverydate;
    }

    public Date getDeliverydate() 
    {
        return deliverydate;
    }
    public void setDateofordermake(Date dateofordermake) 
    {
        this.dateofordermake = dateofordermake;
    }

    public Date getDateofordermake() 
    {
        return dateofordermake;
    }
    public void setLeftuseamount(String leftuseamount) 
    {
        this.leftuseamount = leftuseamount;
    }

    public String getLeftuseamount() 
    {
        return leftuseamount;
    }
    public void setHasusedamount(String hasusedamount) 
    {
        this.hasusedamount = hasusedamount;
    }

    public String getHasusedamount() 
    {
        return hasusedamount;
    }
    public void setPlanuseamount(String planuseamount) 
    {
        this.planuseamount = planuseamount;
    }

    public String getPlanuseamount() 
    {
        return planuseamount;
    }
    public void setOrdertype(String ordertype) 
    {
        this.ordertype = ordertype;
    }

    public String getOrdertype() 
    {
        return ordertype;
    }
    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
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
            .append("supplierid", getSupplierid())
            .append("settlementstatus", getSettlementstatus())
            .append("orderdeliverystate", getOrderdeliverystate())
            .append("deliverydate", getDeliverydate())
            .append("dateofordermake", getDateofordermake())
            .append("leftuseamount", getLeftuseamount())
            .append("hasusedamount", getHasusedamount())
            .append("planuseamount", getPlanuseamount())
            .append("ordertype", getOrdertype())
            .append("orderid", getOrderid())
            .append("id", getId())
            .append("materialAmount", getMaterialAmount())
            .append("supplierAmount", getSupplierAmount())
            .toString();
    }

    public Double getMaterialAmount() {
        return materialAmount;
    }

    public void setMaterialAmount(Double materialAmount) {
        this.materialAmount = materialAmount;
    }

    public Double getSupplierAmount() {
        return supplierAmount;
    }

    public void setSupplierAmount(Double supplierAmount) {
        this.supplierAmount = supplierAmount;
    }
}
