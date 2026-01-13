package com.ruoyi.project.system.serviceorder.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * serviceorder对象 ds_serviceorder
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsServiceorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 中心ID */
    @Excel(name = "中心ID")
    private Long centerid;

    /** 顾客电话 */
    @Excel(name = "顾客电话")
    private Long customerphone;

    /** 顾客姓名 */
    @Excel(name = "顾客姓名")
    private String customername;

    /** 车辆编号 */
    @Excel(name = "车辆编号")
    private Long vehicleid;

    /** 订单日期 */
    @Excel(name = "订单日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date serviceorderdate;

    /** 故障原因 */
    @Excel(name = "故障原因")
    private String faultreason;

    /** 故障部位 */
    @Excel(name = "故障部位")
    private String faultlocation;

    /** 故障类型 */
    @Excel(name = "故障类型")
    private String faulttype;

    /** 订单ID */
    private Long serviceorderid;

    public void setCenterid(Long centerid) 
    {
        this.centerid = centerid;
    }

    public Long getCenterid() 
    {
        return centerid;
    }
    public void setCustomerphone(Long customerphone) 
    {
        this.customerphone = customerphone;
    }

    public Long getCustomerphone() 
    {
        return customerphone;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }

    public String getCustomername() 
    {
        return customername;
    }
    public void setVehicleid(Long vehicleid) 
    {
        this.vehicleid = vehicleid;
    }

    public Long getVehicleid() 
    {
        return vehicleid;
    }
    public void setServiceorderdate(Date serviceorderdate) 
    {
        this.serviceorderdate = serviceorderdate;
    }

    public Date getServiceorderdate() 
    {
        return serviceorderdate;
    }
    public void setFaultreason(String faultreason) 
    {
        this.faultreason = faultreason;
    }

    public String getFaultreason() 
    {
        return faultreason;
    }
    public void setFaultlocation(String faultlocation) 
    {
        this.faultlocation = faultlocation;
    }

    public String getFaultlocation() 
    {
        return faultlocation;
    }
    public void setFaulttype(String faulttype) 
    {
        this.faulttype = faulttype;
    }

    public String getFaulttype() 
    {
        return faulttype;
    }
    public void setServiceorderid(Long serviceorderid) 
    {
        this.serviceorderid = serviceorderid;
    }

    public Long getServiceorderid() 
    {
        return serviceorderid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("centerid", getCenterid())
            .append("customerphone", getCustomerphone())
            .append("customername", getCustomername())
            .append("vehicleid", getVehicleid())
            .append("serviceorderdate", getServiceorderdate())
            .append("faultreason", getFaultreason())
            .append("faultlocation", getFaultlocation())
            .append("faulttype", getFaulttype())
            .append("serviceorderid", getServiceorderid())
            .toString();
    }
}
