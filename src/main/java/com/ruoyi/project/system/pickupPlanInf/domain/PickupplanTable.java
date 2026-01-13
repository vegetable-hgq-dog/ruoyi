package com.ruoyi.project.system.pickupPlanInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 取货计划对象 pickupplan_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class PickupplanTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 路线 */
    @Excel(name = "路线")
    private String planroute;

    /** 卸货地点 */
    @Excel(name = "卸货地点")
    private String unloadlocation;

    /** 计划交付时间 */
    @Excel(name = "计划交付时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date plantimeofdelivery;

    /** 预计交付时间 */
    @Excel(name = "预计交付时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date estimateddeliverytime;

    /** 计划取货时间 */
    @Excel(name = "计划取货时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date plantakegoodstime;

    /** 预警状态 */
    @Excel(name = "预警状态")
    private String warningstate;

    /** 取货类型 */
    @Excel(name = "取货类型", readConverterExp = "1=普运", prompt = "1=普运")
    private String pickuptype;

    /** 取货计划编号 */
    @Excel(name = "取货计划编号")
    private String pickupplanid;

    /** 序号 */
    private Long id;

    public void setPlanroute(String planroute) 
    {
        this.planroute = planroute;
    }

    public String getPlanroute() 
    {
        return planroute;
    }
    public void setUnloadlocation(String unloadlocation) 
    {
        this.unloadlocation = unloadlocation;
    }

    public String getUnloadlocation() 
    {
        return unloadlocation;
    }
    public void setPlantimeofdelivery(Date plantimeofdelivery) 
    {
        this.plantimeofdelivery = plantimeofdelivery;
    }

    public Date getPlantimeofdelivery() 
    {
        return plantimeofdelivery;
    }
    public void setEstimateddeliverytime(Date estimateddeliverytime) 
    {
        this.estimateddeliverytime = estimateddeliverytime;
    }

    public Date getEstimateddeliverytime() 
    {
        return estimateddeliverytime;
    }
    public void setPlantakegoodstime(Date plantakegoodstime) 
    {
        this.plantakegoodstime = plantakegoodstime;
    }

    public Date getPlantakegoodstime() 
    {
        return plantakegoodstime;
    }
    public void setWarningstate(String warningstate) 
    {
        this.warningstate = warningstate;
    }

    public String getWarningstate() 
    {
        return warningstate;
    }
    public void setPickuptype(String pickuptype) 
    {
        this.pickuptype = pickuptype;
    }

    public String getPickuptype() 
    {
        return pickuptype;
    }
    public void setPickupplanid(String pickupplanid) 
    {
        this.pickupplanid = pickupplanid;
    }

    public String getPickupplanid() 
    {
        return pickupplanid;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("planroute", getPlanroute())
            .append("unloadlocation", getUnloadlocation())
            .append("plantimeofdelivery", getPlantimeofdelivery())
            .append("estimateddeliverytime", getEstimateddeliverytime())
            .append("plantakegoodstime", getPlantakegoodstime())
            .append("warningstate", getWarningstate())
            .append("pickuptype", getPickuptype())
            .append("pickupplanid", getPickupplanid())
            .append("id", getId())
            .toString();
    }
}
