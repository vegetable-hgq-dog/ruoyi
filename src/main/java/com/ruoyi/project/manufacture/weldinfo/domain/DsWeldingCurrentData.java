package com.ruoyi.project.manufacture.weldinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * weld_info对象 ds_welding_current_data
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public class DsWeldingCurrentData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 当前时间 */
    @Excel(name = "当前时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datatime;

    /** 焊接质量 */
    @Excel(name = "焊接质量")
    private String weldingQuality;

    /** 焊接能量 */
    @Excel(name = "焊接能量")
    private Double currentEnergy;

    /** 焊接功率 */
    @Excel(name = "焊接功率")
    private Double currentPower;

    /** 实时电阻 */
    @Excel(name = "实时电阻")
    private Double currentResistance;

    /** 实时电压 */
    @Excel(name = "实时电压")
    private Double currentVoltage;

    /** 实时电流 */
    @Excel(name = "实时电流")
    private Double currentElec;

    /** 焊接点 */
    @Excel(name = "焊接点")
    private String weldingSpotId;

    /** 焊枪类型 */
    @Excel(name = "焊枪类型")
    private String gunType;

    /** 机器人 */
    @Excel(name = "机器人")
    private String robotId;

    /** ID */
    private Long autoId;

    public void setDatatime(Date datatime) 
    {
        this.datatime = datatime;
    }

    public Date getDatatime() 
    {
        return datatime;
    }
    public void setWeldingQuality(String weldingQuality) 
    {
        this.weldingQuality = weldingQuality;
    }

    public String getWeldingQuality() 
    {
        return weldingQuality;
    }
    public void setCurrentEnergy(Double currentEnergy) 
    {
        this.currentEnergy = currentEnergy;
    }

    public Double getCurrentEnergy() 
    {
        return currentEnergy;
    }
    public void setCurrentPower(Double currentPower) 
    {
        this.currentPower = currentPower;
    }

    public Double getCurrentPower() 
    {
        return currentPower;
    }
    public void setCurrentResistance(Double currentResistance) 
    {
        this.currentResistance = currentResistance;
    }

    public Double getCurrentResistance() 
    {
        return currentResistance;
    }
    public void setCurrentVoltage(Double currentVoltage) 
    {
        this.currentVoltage = currentVoltage;
    }

    public Double getCurrentVoltage() 
    {
        return currentVoltage;
    }
    public void setCurrentElec(Double currentElec) 
    {
        this.currentElec = currentElec;
    }

    public Double getCurrentElec() 
    {
        return currentElec;
    }
    public void setWeldingSpotId(String weldingSpotId) 
    {
        this.weldingSpotId = weldingSpotId;
    }

    public String getWeldingSpotId() 
    {
        return weldingSpotId;
    }
    public void setGunType(String gunType) 
    {
        this.gunType = gunType;
    }

    public String getGunType() 
    {
        return gunType;
    }
    public void setRobotId(String robotId) 
    {
        this.robotId = robotId;
    }

    public String getRobotId() 
    {
        return robotId;
    }
    public void setAutoId(Long autoId) 
    {
        this.autoId = autoId;
    }

    public Long getAutoId() 
    {
        return autoId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("datatime", getDatatime())
            .append("weldingQuality", getWeldingQuality())
            .append("currentEnergy", getCurrentEnergy())
            .append("currentPower", getCurrentPower())
            .append("currentResistance", getCurrentResistance())
            .append("currentVoltage", getCurrentVoltage())
            .append("currentElec", getCurrentElec())
            .append("weldingSpotId", getWeldingSpotId())
            .append("gunType", getGunType())
            .append("robotId", getRobotId())
            .append("autoId", getAutoId())
            .toString();
    }
}
