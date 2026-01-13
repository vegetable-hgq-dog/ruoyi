package com.ruoyi.project.system.stationsInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工位信息对象 ds_stations
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public class DsStations extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工位ID */
    private Long stationid;

    /** 工位名称 */
    @Excel(name = "工位名称")
    private String stationname;

    /** 工位类型 */
    @Excel(name = "工位类型")
    private String stationtype;

    public void setStationid(Long stationid) 
    {
        this.stationid = stationid;
    }

    public Long getStationid() 
    {
        return stationid;
    }
    public void setStationname(String stationname) 
    {
        this.stationname = stationname;
    }

    public String getStationname() 
    {
        return stationname;
    }
    public void setStationtype(String stationtype) 
    {
        this.stationtype = stationtype;
    }

    public String getStationtype() 
    {
        return stationtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stationid", getStationid())
            .append("stationname", getStationname())
            .append("stationtype", getStationtype())
            .toString();
    }
}
