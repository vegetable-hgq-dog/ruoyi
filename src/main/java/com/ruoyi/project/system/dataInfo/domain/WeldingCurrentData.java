package com.ruoyi.project.system.dataInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 焊接实时数据对象 welding_current_data
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class WeldingCurrentData extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 焊点ID */
    @Excel(name = "焊点ID")
    private String weldingspotid;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date datatime;

    /** 实时电流 */
    @Excel(name = "实时电流")
    private String current;

    /** 实时电压 */
    @Excel(name = "实时电压")
    private String voltage;

    /** 实时电阻 */
    @Excel(name = "实时电阻")
    private String resistance;

    /** 焊接电流 */
    @Excel(name = "焊接电流")
    private Double currentvalue;

    /** 焊接能量 */
    @Excel(name = "焊接能量")
    private Double energyvalue;

    /** 焊接功率 */
    @Excel(name = "焊接功率")
    private Double powervalue;

    /** 焊接质量 */
    @Excel(name = "焊接质量")
    private String weldingquality;

    private Long weldingQualityNum;


    private Long dateTotalNum;

    private String YMD;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWeldingspotid(String weldingspotid) 
    {
        this.weldingspotid = weldingspotid;
    }

    public String getWeldingspotid() 
    {
        return weldingspotid;
    }
    public void setDatatime(Date datatime) 
    {
        this.datatime = datatime;
    }

    public Date getDatatime() 
    {
        return datatime;
    }
    public void setCurrent(String current) 
    {
        this.current = current;
    }

    public String getCurrent() 
    {
        return current;
    }
    public void setVoltage(String voltage) 
    {
        this.voltage = voltage;
    }

    public String getVoltage() 
    {
        return voltage;
    }
    public void setResistance(String resistance) 
    {
        this.resistance = resistance;
    }

    public String getResistance() 
    {
        return resistance;
    }
    public void setCurrentvalue(Double currentvalue) 
    {
        this.currentvalue = currentvalue;
    }

    public Double getCurrentvalue() 
    {
        return currentvalue;
    }
    public void setEnergyvalue(Double energyvalue) 
    {
        this.energyvalue = energyvalue;
    }

    public Double getEnergyvalue() 
    {
        return energyvalue;
    }
    public void setPowervalue(Double powervalue) 
    {
        this.powervalue = powervalue;
    }

    public Double getPowervalue() 
    {
        return powervalue;
    }
    public void setWeldingquality(String weldingquality) 
    {
        this.weldingquality = weldingquality;
    }

    public String getWeldingquality() 
    {
        return weldingquality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("weldingspotid", getWeldingspotid())
            .append("datatime", getDatatime())
            .append("current", getCurrent())
            .append("voltage", getVoltage())
            .append("resistance", getResistance())
            .append("currentvalue", getCurrentvalue())
            .append("energyvalue", getEnergyvalue())
            .append("powervalue", getPowervalue())
            .append("weldingquality", getWeldingquality())
            .append("weldingQualityNum",getWeldingQualityNum())
            .append("dateTotalNum",getDateTotalNum())
            .append("YMD",getYMD())
            .toString();
    }

    public Long getWeldingQualityNum() {
        return weldingQualityNum;
    }

    public void setWeldingQualityNum(Long weldingQualityNum) {
        this.weldingQualityNum = weldingQualityNum;
    }

    public Long getDateTotalNum() {
        return dateTotalNum;
    }

    public void setDateTotalNum(Long dateTotalNum) {
        this.dateTotalNum = dateTotalNum;
    }

    public String getYMD() {
        return YMD;
    }

    public void setYMD(String YMD) {
        this.YMD = YMD;
    }
}
