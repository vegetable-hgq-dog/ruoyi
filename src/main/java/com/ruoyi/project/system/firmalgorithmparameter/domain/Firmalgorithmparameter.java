package com.ruoyi.project.system.firmalgorithmparameter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 需求数据对象 firmalgorithmparameter
 * 
 * @author ruoyi
 * @date 2024-04-16
 */
public class Firmalgorithmparameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运输耗时 */
    @Excel(name = "运输耗时")
    private Double transportdate;

    /** 零部件或物料生产能力 */
    @Excel(name = "零部件或物料生产能力")
    private Double tp;

    /** 延迟率 */
    @Excel(name = "延迟率")
    private Double de;

    /** 不合格率 */
    @Excel(name = "不合格率")
    private Double dq;

    /** 理论上最大供应量（整数） */
    @Excel(name = "理论上最大供应量", readConverterExp = "整=数")
    private Long upper;

    /** 起订量（整数） */
    @Excel(name = "起订量", readConverterExp = "整=数")
    private Long lower;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** 编号 */
    private Long id;

    public void setTransportdate(Double transportdate) 
    {
        this.transportdate = transportdate;
    }

    public Double getTransportdate() 
    {
        return transportdate;
    }
    public void setTp(Double tp) 
    {
        this.tp = tp;
    }

    public Double getTp() 
    {
        return tp;
    }
    public void setDe(Double de) 
    {
        this.de = de;
    }

    public Double getDe() 
    {
        return de;
    }
    public void setDq(Double dq) 
    {
        this.dq = dq;
    }

    public Double getDq() 
    {
        return dq;
    }
    public void setUpper(Long upper) 
    {
        this.upper = upper;
    }

    public Long getUpper() 
    {
        return upper;
    }
    public void setLower(Long lower) 
    {
        this.lower = lower;
    }

    public Long getLower() 
    {
        return lower;
    }
    public void setFirmname(String firmname) 
    {
        this.firmname = firmname;
    }

    public String getFirmname() 
    {
        return firmname;
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
            .append("transportdate", getTransportdate())
            .append("tp", getTp())
            .append("de", getDe())
            .append("dq", getDq())
            .append("upper", getUpper())
            .append("lower", getLower())
            .append("firmname", getFirmname())
            .append("id", getId())
            .toString();
    }
}
