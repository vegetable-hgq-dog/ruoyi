package com.ruoyi.project.system.firmkeychainparameter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 关键链条参数对象 firmkeychainparameter
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public class Firmkeychainparameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 预计实际供应量 */
    @Excel(name = "预计实际供应量")
    private Long firmsupply;

    /** 企业理论供应量 */
    @Excel(name = "企业理论供应量")
    private Long firmplansupply;

    /** 预计实际需求量 */
    @Excel(name = "预计实际需求量")
    private Long firmdemands;

    /** 企业理论需求量 */
    @Excel(name = "企业理论需求量")
    private Long firmplandemand;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** null */
    private Long id;

    public void setFirmsupply(Long firmsupply) 
    {
        this.firmsupply = firmsupply;
    }

    public Long getFirmsupply() 
    {
        return firmsupply;
    }
    public void setFirmplansupply(Long firmplansupply) 
    {
        this.firmplansupply = firmplansupply;
    }

    public Long getFirmplansupply() 
    {
        return firmplansupply;
    }
    public void setFirmdemands(Long firmdemands) 
    {
        this.firmdemands = firmdemands;
    }

    public Long getFirmdemands() 
    {
        return firmdemands;
    }
    public void setFirmplandemand(Long firmplandemand) 
    {
        this.firmplandemand = firmplandemand;
    }

    public Long getFirmplandemand() 
    {
        return firmplandemand;
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
            .append("firmsupply", getFirmsupply())
            .append("firmplansupply", getFirmplansupply())
            .append("firmdemands", getFirmdemands())
            .append("firmplandemand", getFirmplandemand())
            .append("firmname", getFirmname())
            .append("id", getId())
            .toString();
    }
}
