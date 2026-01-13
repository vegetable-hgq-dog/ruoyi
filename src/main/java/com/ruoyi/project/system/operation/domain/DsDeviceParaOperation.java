package com.ruoyi.project.system.operation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 实时状态对象 ds_device_para_operation
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public class DsDeviceParaOperation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private Long deviceid;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String devicename;

    /** 参数编号 */
    @Excel(name = "参数编号")
    private Long parameterid;

    /** 参数名称 */
    @Excel(name = "参数名称")
    private String parametername;

    /** 参数当前值 */
    @Excel(name = "参数当前值")
    private Long parametevalue;

    /** 设备状况 */
    @Excel(name = "设备状况")
    private String deviceoperstatus;

    /** 健康状态 */
    @Excel(name = "健康状态")
    private String devicehealthcond;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceid(Long deviceid) 
    {
        this.deviceid = deviceid;
    }

    public Long getDeviceid() 
    {
        return deviceid;
    }
    public void setDevicename(String devicename) 
    {
        this.devicename = devicename;
    }

    public String getDevicename() 
    {
        return devicename;
    }
    public void setParameterid(Long parameterid) 
    {
        this.parameterid = parameterid;
    }

    public Long getParameterid() 
    {
        return parameterid;
    }
    public void setParametername(String parametername) 
    {
        this.parametername = parametername;
    }

    public String getParametername() 
    {
        return parametername;
    }
    public void setParametevalue(Long parametevalue) 
    {
        this.parametevalue = parametevalue;
    }

    public Long getParametevalue() 
    {
        return parametevalue;
    }
    public void setDeviceoperstatus(String deviceoperstatus) 
    {
        this.deviceoperstatus = deviceoperstatus;
    }

    public String getDeviceoperstatus() 
    {
        return deviceoperstatus;
    }
    public void setDevicehealthcond(String devicehealthcond) 
    {
        this.devicehealthcond = devicehealthcond;
    }

    public String getDevicehealthcond() 
    {
        return devicehealthcond;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceid", getDeviceid())
            .append("devicename", getDevicename())
            .append("parameterid", getParameterid())
            .append("parametername", getParametername())
            .append("parametevalue", getParametevalue())
            .append("deviceoperstatus", getDeviceoperstatus())
            .append("devicehealthcond", getDevicehealthcond())
            .toString();
    }
}
