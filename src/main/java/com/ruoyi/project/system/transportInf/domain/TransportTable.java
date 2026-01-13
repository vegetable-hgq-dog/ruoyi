package com.ruoyi.project.system.transportInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 运输信息对象 transport_table
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public class TransportTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 取货计划编号 */
    @Excel(name = "取货计划编号")
    private String pickupplanid;

    /** 司机名称 */
    @Excel(name = "司机名称")
    private String drivername;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String orderid;

    /** 预警状态 */
    @Excel(name = "预警状态")
    private String alertstatus;

    /** 运输状态 */
    @Excel(name = "运输状态")
    private String shippingstatus;

    /** 交付时间 */
    @Excel(name = "交付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateofdelivery;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dateofmake;

    /** 车辆车牌号 */
    @Excel(name = "车辆车牌号")
    private String licenseplate;

    /** 运输类型 */
    @Excel(name = "运输类型")
    private String transporttype;

    /** 承运商名称 */
    @Excel(name = "承运商名称")
    private String carriername;

    /** 运输计划编号 */
    @Excel(name = "运输计划编号")
    private String transportplanid;

    /** 序号 */
    private Long id;

    public void setPickupplanid(String pickupplanid) 
    {
        this.pickupplanid = pickupplanid;
    }

    public String getPickupplanid() 
    {
        return pickupplanid;
    }
    public void setDrivername(String drivername) 
    {
        this.drivername = drivername;
    }

    public String getDrivername() 
    {
        return drivername;
    }
    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
    }
    public void setAlertstatus(String alertstatus) 
    {
        this.alertstatus = alertstatus;
    }

    public String getAlertstatus() 
    {
        return alertstatus;
    }
    public void setShippingstatus(String shippingstatus) 
    {
        this.shippingstatus = shippingstatus;
    }

    public String getShippingstatus() 
    {
        return shippingstatus;
    }
    public void setDateofdelivery(Date dateofdelivery) 
    {
        this.dateofdelivery = dateofdelivery;
    }

    public Date getDateofdelivery() 
    {
        return dateofdelivery;
    }
    public void setDateofmake(Date dateofmake) 
    {
        this.dateofmake = dateofmake;
    }

    public Date getDateofmake() 
    {
        return dateofmake;
    }
    public void setLicenseplate(String licenseplate) 
    {
        this.licenseplate = licenseplate;
    }

    public String getLicenseplate() 
    {
        return licenseplate;
    }
    public void setTransporttype(String transporttype) 
    {
        this.transporttype = transporttype;
    }

    public String getTransporttype() 
    {
        return transporttype;
    }
    public void setCarriername(String carriername) 
    {
        this.carriername = carriername;
    }

    public String getCarriername() 
    {
        return carriername;
    }
    public void setTransportplanid(String transportplanid) 
    {
        this.transportplanid = transportplanid;
    }

    public String getTransportplanid() 
    {
        return transportplanid;
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
            .append("pickupplanid", getPickupplanid())
            .append("drivername", getDrivername())
            .append("orderid", getOrderid())
            .append("alertstatus", getAlertstatus())
            .append("shippingstatus", getShippingstatus())
            .append("dateofdelivery", getDateofdelivery())
            .append("dateofmake", getDateofmake())
            .append("licenseplate", getLicenseplate())
            .append("transporttype", getTransporttype())
            .append("carriername", getCarriername())
            .append("transportplanid", getTransportplanid())
            .append("id", getId())
            .toString();
    }
}
