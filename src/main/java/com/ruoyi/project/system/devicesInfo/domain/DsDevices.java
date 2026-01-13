package com.ruoyi.project.system.devicesInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设备信息对象 ds_devices
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class DsDevices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private Long deviceid;

    /** 工位ID */
    @Excel(name = "工位ID")
    private Long stationid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devicename;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String devicetype;

    /** 设备介绍 */
    @Excel(name = "设备介绍")
    private String deviceintroduction;

    /** 设备IP */
    @Excel(name = "设备IP")
    private String deviceip;

    public void setDeviceid(Long deviceid) 
    {
        this.deviceid = deviceid;
    }

    public Long getDeviceid() 
    {
        return deviceid;
    }
    public void setStationid(Long stationid) 
    {
        this.stationid = stationid;
    }

    public Long getStationid() 
    {
        return stationid;
    }
    public void setDevicename(String devicename) 
    {
        this.devicename = devicename;
    }

    public String getDevicename() 
    {
        return devicename;
    }
    public void setDevicetype(String devicetype) 
    {
        this.devicetype = devicetype;
    }

    public String getDevicetype() 
    {
        return devicetype;
    }
    public void setDeviceintroduction(String deviceintroduction) 
    {
        this.deviceintroduction = deviceintroduction;
    }

    public String getDeviceintroduction() 
    {
        return deviceintroduction;
    }
    public void setDeviceip(String deviceip) 
    {
        this.deviceip = deviceip;
    }

    public String getDeviceip() 
    {
        return deviceip;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deviceid", getDeviceid())
            .append("stationid", getStationid())
            .append("devicename", getDevicename())
            .append("devicetype", getDevicetype())
            .append("deviceintroduction", getDeviceintroduction())
            .append("deviceip", getDeviceip())
            .toString();
    }
}
