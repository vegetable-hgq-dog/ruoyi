package com.ruoyi.project.system.station.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工位信息对象 ds_station
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsStation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工位编号 */
    @Excel(name = "工位编号")
    private Long stationid;

    /** 工位名称 */
    @Excel(name = "工位名称")
    private String stationname;

    /** 工位类型 */
    @Excel(name = "工位类型")
    private String stationtype;

    /** 所属产线 */
    @Excel(name = "所属产线")
    private Long productlineid;

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
    public void setProductlineid(Long productlineid) 
    {
        this.productlineid = productlineid;
    }

    public Long getProductlineid() 
    {
        return productlineid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stationid", getStationid())
            .append("stationname", getStationname())
            .append("stationtype", getStationtype())
            .append("productlineid", getProductlineid())
            .toString();
    }
}
