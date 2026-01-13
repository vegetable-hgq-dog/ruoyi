package com.ruoyi.project.manufacture.robotAlert.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * robot_alert对象 ods_mb050_exterror_rds_v_di
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public class OdsMb050ExterrorRdsVDi extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 抽取时间 */
    private Date etltime;

    /** 伺服器信息 */
    @Excel(name = "伺服器信息")
    private String servodyndvstateTxt;

    /** 伺服器状态 */
    @Excel(name = "伺服器状态")
    private Long servodyndvstate;

    /** 故障信息 */
    @Excel(name = "故障信息")
    private String iserrorTxt;

    /** 是否故障 */
    @Excel(name = "是否故障")
    private Integer iserror;

    /** 预警信息2 */
    @Excel(name = "预警信息2")
    private String errorcode2Txt;

    /** 预警代码2 */
    @Excel(name = "预警代码2")
    private Long errorcode2;

    /** 预警信息1 */
    @Excel(name = "预警信息1")
    private String errorcode1Txt;

    /** 预警代码1 */
    @Excel(name = "预警代码1")
    private Long errorcode1;

    /** 机器人 */
    @Excel(name = "机器人")
    private String timername;

    /** 预警时间 */
    @Excel(name = "预警时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datetime;

    /** ID */
    @Excel(name = "ID")
    private Long protrecordId;

    /** 自增ID */
    private Long autoid;

    public void setEtltime(Date etltime) 
    {
        this.etltime = etltime;
    }

    public Date getEtltime() 
    {
        return etltime;
    }
    public void setServodyndvstateTxt(String servodyndvstateTxt) 
    {
        this.servodyndvstateTxt = servodyndvstateTxt;
    }

    public String getServodyndvstateTxt() 
    {
        return servodyndvstateTxt;
    }
    public void setServodyndvstate(Long servodyndvstate) 
    {
        this.servodyndvstate = servodyndvstate;
    }

    public Long getServodyndvstate() 
    {
        return servodyndvstate;
    }
    public void setIserrorTxt(String iserrorTxt) 
    {
        this.iserrorTxt = iserrorTxt;
    }

    public String getIserrorTxt() 
    {
        return iserrorTxt;
    }
    public void setIserror(Integer iserror) 
    {
        this.iserror = iserror;
    }

    public Integer getIserror() 
    {
        return iserror;
    }
    public void setErrorcode2Txt(String errorcode2Txt) 
    {
        this.errorcode2Txt = errorcode2Txt;
    }

    public String getErrorcode2Txt() 
    {
        return errorcode2Txt;
    }
    public void setErrorcode2(Long errorcode2) 
    {
        this.errorcode2 = errorcode2;
    }

    public Long getErrorcode2() 
    {
        return errorcode2;
    }
    public void setErrorcode1Txt(String errorcode1Txt) 
    {
        this.errorcode1Txt = errorcode1Txt;
    }

    public String getErrorcode1Txt() 
    {
        return errorcode1Txt;
    }
    public void setErrorcode1(Long errorcode1) 
    {
        this.errorcode1 = errorcode1;
    }

    public Long getErrorcode1() 
    {
        return errorcode1;
    }
    public void setTimername(String timername) 
    {
        this.timername = timername;
    }

    public String getTimername() 
    {
        return timername;
    }
    public void setDatetime(Date datetime) 
    {
        this.datetime = datetime;
    }

    public Date getDatetime() 
    {
        return datetime;
    }
    public void setProtrecordId(Long protrecordId) 
    {
        this.protrecordId = protrecordId;
    }

    public Long getProtrecordId() 
    {
        return protrecordId;
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
            .append("servodyndvstateTxt", getServodyndvstateTxt())
            .append("servodyndvstate", getServodyndvstate())
            .append("iserrorTxt", getIserrorTxt())
            .append("iserror", getIserror())
            .append("errorcode2Txt", getErrorcode2Txt())
            .append("errorcode2", getErrorcode2())
            .append("errorcode1Txt", getErrorcode1Txt())
            .append("errorcode1", getErrorcode1())
            .append("timername", getTimername())
            .append("datetime", getDatetime())
            .append("protrecordId", getProtrecordId())
            .append("autoid", getAutoid())
            .toString();
    }
}
