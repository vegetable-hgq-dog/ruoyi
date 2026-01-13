package com.ruoyi.project.system.salevehicle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * salevehicle对象 ds_salevehicle
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsSalevehicle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 定价 */
    @Excel(name = "定价")
    private Long vehicleprice;

    /** 出厂日期 */
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vehiclebirthdate;

    /** 生产地 */
    @Excel(name = "生产地")
    private String vehiclebirthplace;

    /** 车辆类型 */
    @Excel(name = "车辆类型")
    private String vehicletype;

    /** 车辆名称 */
    @Excel(name = "车辆名称")
    private String vehiclename;

    /** 车辆制造ID */
    @Excel(name = "车辆制造ID")
    private Long vechiclemanuid;

    /** 出厂编号 */
    private Long vehicleid;

    public void setVehicleprice(Long vehicleprice) 
    {
        this.vehicleprice = vehicleprice;
    }

    public Long getVehicleprice() 
    {
        return vehicleprice;
    }
    public void setVehiclebirthdate(Date vehiclebirthdate) 
    {
        this.vehiclebirthdate = vehiclebirthdate;
    }

    public Date getVehiclebirthdate() 
    {
        return vehiclebirthdate;
    }
    public void setVehiclebirthplace(String vehiclebirthplace) 
    {
        this.vehiclebirthplace = vehiclebirthplace;
    }

    public String getVehiclebirthplace() 
    {
        return vehiclebirthplace;
    }
    public void setVehicletype(String vehicletype) 
    {
        this.vehicletype = vehicletype;
    }

    public String getVehicletype() 
    {
        return vehicletype;
    }
    public void setVehiclename(String vehiclename) 
    {
        this.vehiclename = vehiclename;
    }

    public String getVehiclename() 
    {
        return vehiclename;
    }
    public void setVechiclemanuid(Long vechiclemanuid) 
    {
        this.vechiclemanuid = vechiclemanuid;
    }

    public Long getVechiclemanuid() 
    {
        return vechiclemanuid;
    }
    public void setVehicleid(Long vehicleid) 
    {
        this.vehicleid = vehicleid;
    }

    public Long getVehicleid() 
    {
        return vehicleid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vehicleprice", getVehicleprice())
            .append("vehiclebirthdate", getVehiclebirthdate())
            .append("vehiclebirthplace", getVehiclebirthplace())
            .append("vehicletype", getVehicletype())
            .append("vehiclename", getVehiclename())
            .append("vechiclemanuid", getVechiclemanuid())
            .append("vehicleid", getVehicleid())
            .toString();
    }
}
