package com.ruoyi.project.system.sales.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * sales对象 ds_sales
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 销售价格 */
    @Excel(name = "销售价格")
    private Long salesprice;

    /** 购买顾客ID */
    @Excel(name = "购买顾客ID")
    private Long customerid;

    /** 销售日期 */
    @Excel(name = "销售日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vehiclesaledate;

    /** 车辆出厂编号 */
    @Excel(name = "车辆出厂编号")
    private Long vehicleid;

    /** 销售ID */
    private Long salesid;

    public void setSalesprice(Long salesprice) 
    {
        this.salesprice = salesprice;
    }

    public Long getSalesprice() 
    {
        return salesprice;
    }
    public void setCustomerid(Long customerid) 
    {
        this.customerid = customerid;
    }

    public Long getCustomerid() 
    {
        return customerid;
    }
    public void setVehiclesaledate(Date vehiclesaledate) 
    {
        this.vehiclesaledate = vehiclesaledate;
    }

    public Date getVehiclesaledate() 
    {
        return vehiclesaledate;
    }
    public void setVehicleid(Long vehicleid) 
    {
        this.vehicleid = vehicleid;
    }

    public Long getVehicleid() 
    {
        return vehicleid;
    }
    public void setSalesid(Long salesid) 
    {
        this.salesid = salesid;
    }

    public Long getSalesid() 
    {
        return salesid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("salesprice", getSalesprice())
            .append("customerid", getCustomerid())
            .append("vehiclesaledate", getVehiclesaledate())
            .append("vehicleid", getVehicleid())
            .append("salesid", getSalesid())
            .toString();
    }
}
