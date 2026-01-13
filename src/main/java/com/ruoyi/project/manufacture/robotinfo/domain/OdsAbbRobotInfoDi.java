package com.ruoyi.project.manufacture.robotinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * robot_info对象 ods_abb_robot_info_di
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public class OdsAbbRobotInfoDi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 抽取时间 */
    private Date etltime;

    /** 消耗时间 */
    private String elapsedProductionTime;

    /** 主模式 */
    private String isMaster;

    /** 版本号 */
    private String versionId;

    /** 版本 */
    private String versionName;

    /** 模式 */
    private String operatingMode;

    /** 负载信息 */
    private String payload;

    /** 负载名 */
    private String loadName;

    /** 负载 */
    @Excel(name = "负载")
    private Long toolLoad;

    /** 焊枪 */
    @Excel(name = "焊枪")
    private String curToolName;

    /** 状态 */
    @Excel(name = "状态")
    private String state;

    /** 机器人ID */
    private String systemId;

    /** 机器人 */
    @Excel(name = "机器人")
    private String systemName;

    /** 采集时间 */
    @Excel(name = "采集时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date writtenTime;

    /** 控制器名 */
    @Excel(name = "控制器名")
    private String controllerName;

    /** 控制器ID */
    private String controllerId;

    /** ID */
    private Long autoid;

    public void setEtltime(Date etltime) 
    {
        this.etltime = etltime;
    }

    public Date getEtltime() 
    {
        return etltime;
    }
    public void setElapsedProductionTime(String elapsedProductionTime) 
    {
        this.elapsedProductionTime = elapsedProductionTime;
    }

    public String getElapsedProductionTime() 
    {
        return elapsedProductionTime;
    }
    public void setIsMaster(String isMaster) 
    {
        this.isMaster = isMaster;
    }

    public String getIsMaster() 
    {
        return isMaster;
    }
    public void setVersionId(String versionId) 
    {
        this.versionId = versionId;
    }

    public String getVersionId() 
    {
        return versionId;
    }
    public void setVersionName(String versionName) 
    {
        this.versionName = versionName;
    }

    public String getVersionName() 
    {
        return versionName;
    }
    public void setOperatingMode(String operatingMode) 
    {
        this.operatingMode = operatingMode;
    }

    public String getOperatingMode() 
    {
        return operatingMode;
    }
    public void setPayload(String payload) 
    {
        this.payload = payload;
    }

    public String getPayload() 
    {
        return payload;
    }
    public void setLoadName(String loadName) 
    {
        this.loadName = loadName;
    }

    public String getLoadName() 
    {
        return loadName;
    }
    public void setToolLoad(Long toolLoad) 
    {
        this.toolLoad = toolLoad;
    }

    public Long getToolLoad() 
    {
        return toolLoad;
    }
    public void setCurToolName(String curToolName) 
    {
        this.curToolName = curToolName;
    }

    public String getCurToolName() 
    {
        return curToolName;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setSystemId(String systemId) 
    {
        this.systemId = systemId;
    }

    public String getSystemId() 
    {
        return systemId;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setWrittenTime(Date writtenTime) 
    {
        this.writtenTime = writtenTime;
    }

    public Date getWrittenTime() 
    {
        return writtenTime;
    }
    public void setControllerName(String controllerName) 
    {
        this.controllerName = controllerName;
    }

    public String getControllerName() 
    {
        return controllerName;
    }
    public void setControllerId(String controllerId) 
    {
        this.controllerId = controllerId;
    }

    public String getControllerId() 
    {
        return controllerId;
    }
    public void setAutoid(Long autoid) 
    {
        this.autoid = autoid;
    }

    public Long getAutoid() 
    {
        return autoid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("etltime", getEtltime())
            .append("elapsedProductionTime", getElapsedProductionTime())
            .append("isMaster", getIsMaster())
            .append("versionId", getVersionId())
            .append("versionName", getVersionName())
            .append("operatingMode", getOperatingMode())
            .append("payload", getPayload())
            .append("loadName", getLoadName())
            .append("toolLoad", getToolLoad())
            .append("curToolName", getCurToolName())
            .append("state", getState())
            .append("systemId", getSystemId())
            .append("systemName", getSystemName())
            .append("writtenTime", getWrittenTime())
            .append("controllerName", getControllerName())
            .append("controllerId", getControllerId())
            .append("autoid", getAutoid())
            .toString();
    }
}
