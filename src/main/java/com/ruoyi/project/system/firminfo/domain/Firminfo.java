package com.ruoyi.project.system.firminfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 供应链企业信息对象 firminfo
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public class Firminfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表示该企业位于供应链几级，0表示链主 */
    @Excel(name = "表示该企业位于供应链几级，0表示链主")
    private Long productlayer;

    /** null表示自己为核心企业，否则表示其物料供应企业的名称 */
    @Excel(name = "null表示自己为核心企业，否则表示其物料供应企业的名称")
    private String targetfirm;

    /** 生产的物料或零部件名称 */
    @Excel(name = "生产的物料或零部件名称")
    private String offerproduct;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** 编号 */
    private Long firmId;

    public void setProductlayer(Long productlayer) 
    {
        this.productlayer = productlayer;
    }

    public Long getProductlayer() 
    {
        return productlayer;
    }
    public void setTargetfirm(String targetfirm) 
    {
        this.targetfirm = targetfirm;
    }

    public String getTargetfirm() 
    {
        return targetfirm;
    }
    public void setOfferproduct(String offerproduct) 
    {
        this.offerproduct = offerproduct;
    }

    public String getOfferproduct() 
    {
        return offerproduct;
    }
    public void setFirmname(String firmname) 
    {
        this.firmname = firmname;
    }

    public String getFirmname() 
    {
        return firmname;
    }
    public void setFirmId(Long firmId) 
    {
        this.firmId = firmId;
    }

    public Long getFirmId() 
    {
        return firmId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productlayer", getProductlayer())
            .append("targetfirm", getTargetfirm())
            .append("offerproduct", getOfferproduct())
            .append("firmname", getFirmname())
            .append("firmId", getFirmId())
            .toString();
    }
}
