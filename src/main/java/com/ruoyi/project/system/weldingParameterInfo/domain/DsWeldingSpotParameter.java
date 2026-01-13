package com.ruoyi.project.system.weldingParameterInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 焊点参数对象 ds_welding_spot_parameter
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class DsWeldingSpotParameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long dsweldingid;

    /** 焊点ID */
    @Excel(name = "焊点ID")
    private String weldingspotid;

    /** 设备ID */
    @Excel(name = "设备ID")
    private Long deviceid;

    /** 程序号 */
    @Excel(name = "程序号")
    private Long programname;

    /** 电流设定 */
    @Excel(name = "电流设定")
    private Double controlcurrent;

    /** 电极压力 */
    @Excel(name = "电极压力")
    private Double controlpressure;

    /** 焊接时间 */
    @Excel(name = "焊接时间")
    private Double controltime;

    public void setDsweldingid(Long dsweldingid) 
    {
        this.dsweldingid = dsweldingid;
    }

    public Long getDsweldingid() 
    {
        return dsweldingid;
    }
    public void setWeldingspotid(String weldingspotid) 
    {
        this.weldingspotid = weldingspotid;
    }

    public String getWeldingspotid() 
    {
        return weldingspotid;
    }
    public void setDeviceid(Long deviceid) 
    {
        this.deviceid = deviceid;
    }

    public Long getDeviceid() 
    {
        return deviceid;
    }
    public void setProgramname(Long programname) 
    {
        this.programname = programname;
    }

    public Long getProgramname() 
    {
        return programname;
    }
    public void setControlcurrent(Double controlcurrent) 
    {
        this.controlcurrent = controlcurrent;
    }

    public Double getControlcurrent() 
    {
        return controlcurrent;
    }
    public void setControlpressure(Double controlpressure) 
    {
        this.controlpressure = controlpressure;
    }

    public Double getControlpressure() 
    {
        return controlpressure;
    }
    public void setControltime(Double controltime) 
    {
        this.controltime = controltime;
    }

    public Double getControltime() 
    {
        return controltime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dsweldingid", getDsweldingid())
            .append("weldingspotid", getWeldingspotid())
            .append("deviceid", getDeviceid())
            .append("programname", getProgramname())
            .append("controlcurrent", getControlcurrent())
            .append("controlpressure", getControlpressure())
            .append("controltime", getControltime())
            .toString();
    }
}
