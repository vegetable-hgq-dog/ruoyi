package com.ruoyi.project.system.vechicle.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 生产信息对象 ds_vechicle_prod_loc
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public class DsVechicleProdLoc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long id;

    /** 车辆编号 */
    @Excel(name = "车辆编号")
    private String vechicleid;

    /** 工位编号 */
    @Excel(name = "工位编号")
    private Long stationid;

    /** 整车物料编号 */
    @Excel(name = "整车物料编号")
    private String manupartsnumber;

    /** 车型编号 */
    @Excel(name = "车型编号")
    private Long vechicletypeid;

    /** 进入工位时间 */
    @Excel(name = "进入工位时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;

    /** 离开工位时间 */
    @Excel(name = "离开工位时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String processname;

    /** 工艺质量 */
    @Excel(name = "工艺质量")
    private String processquality;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVechicleid(String vechicleid) 
    {
        this.vechicleid = vechicleid;
    }

    public String getVechicleid() 
    {
        return vechicleid;
    }
    public void setStationid(Long stationid) 
    {
        this.stationid = stationid;
    }

    public Long getStationid() 
    {
        return stationid;
    }
    public void setManupartsnumber(String manupartsnumber) 
    {
        this.manupartsnumber = manupartsnumber;
    }

    public String getManupartsnumber() 
    {
        return manupartsnumber;
    }
    public void setVechicletypeid(Long vechicletypeid) 
    {
        this.vechicletypeid = vechicletypeid;
    }

    public Long getVechicletypeid() 
    {
        return vechicletypeid;
    }
    public void setStarttime(Date starttime) 
    {
        this.starttime = starttime;
    }

    public Date getStarttime() 
    {
        return starttime;
    }
    public void setEndtime(Date endtime) 
    {
        this.endtime = endtime;
    }

    public Date getEndtime() 
    {
        return endtime;
    }
    public void setProcessname(String processname) 
    {
        this.processname = processname;
    }

    public String getProcessname() 
    {
        return processname;
    }
    public void setProcessquality(String processquality) 
    {
        this.processquality = processquality;
    }

    public String getProcessquality() 
    {
        return processquality;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("vechicleid", getVechicleid())
            .append("stationid", getStationid())
            .append("manupartsnumber", getManupartsnumber())
            .append("vechicletypeid", getVechicletypeid())
            .append("starttime", getStarttime())
            .append("endtime", getEndtime())
            .append("processname", getProcessname())
            .append("processquality", getProcessquality())
            .toString();
    }
}
