package com.ruoyi.project.tool.swagger.firstInterface.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("用户实体")
public class OrderDomain {

    /** 工厂编号 */
    @ApiModelProperty("工厂编号")
    private String factoryid;

    /** 物料编号 */
    @ApiModelProperty("物料编号")
    private String materialid;

    /** 供应商编号 */
    @ApiModelProperty("供应商编号")
    private String supplierid;

    /** 结算状态 */
    @ApiModelProperty("结算状态")
    private String settlementstatus;

    /** 下发状态 */
    @ApiModelProperty("下发状态")
    private String orderdeliverystate;

    /** 交货时间 */
    @ApiModelProperty("交货时间")
    private Date deliverydate;


    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Date dateofordermake;

    /** 剩余数量 */
    @ApiModelProperty("剩余数量")
    private String leftuseamount;

    /** 已用数量 */
    @ApiModelProperty("已用数量")
    private String hasusedamount;

    /** 计划数量 */
    @ApiModelProperty("计划数量")
    private String planuseamount;

    /** 订单类型 */
    @ApiModelProperty("订单类型")
    private String ordertype;

    /** 订单编号 */
    @ApiModelProperty("订单编号")
    private String orderid;

    public OrderDomain() {
    }

    public OrderDomain(String factoryid, String materialid, String supplierid, String settlementstatus, String orderdeliverystate, Date deliverydate, Date dateofordermake, String leftuseamount, String hasusedamount, String planuseamount, String ordertype, String orderid) {
        this.factoryid = factoryid;
        this.materialid = materialid;
        this.supplierid = supplierid;
        this.settlementstatus = settlementstatus;
        this.orderdeliverystate = orderdeliverystate;
        this.deliverydate = deliverydate;
        this.dateofordermake = dateofordermake;
        this.leftuseamount = leftuseamount;
        this.hasusedamount = hasusedamount;
        this.planuseamount = planuseamount;
        this.ordertype = ordertype;
        this.orderid = orderid;
    }

    public String getFactoryid() {
        return factoryid;
    }

    public void setFactoryid(String factoryid) {
        this.factoryid = factoryid;
    }

    public String getMaterialid() {
        return materialid;
    }

    public void setMaterialid(String materialid) {
        this.materialid = materialid;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getSettlementstatus() {
        return settlementstatus;
    }

    public void setSettlementstatus(String settlementstatus) {
        this.settlementstatus = settlementstatus;
    }

    public String getOrderdeliverystate() {
        return orderdeliverystate;
    }

    public void setOrderdeliverystate(String orderdeliverystate) {
        this.orderdeliverystate = orderdeliverystate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Date getDateofordermake() {
        return dateofordermake;
    }

    public void setDateofordermake(Date dateofordermake) {
        this.dateofordermake = dateofordermake;
    }

    public String getLeftuseamount() {
        return leftuseamount;
    }

    public void setLeftuseamount(String leftuseamount) {
        this.leftuseamount = leftuseamount;
    }

    public String getHasusedamount() {
        return hasusedamount;
    }

    public void setHasusedamount(String hasusedamount) {
        this.hasusedamount = hasusedamount;
    }

    public String getPlanuseamount() {
        return planuseamount;
    }

    public void setPlanuseamount(String planuseamount) {
        this.planuseamount = planuseamount;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }
}
