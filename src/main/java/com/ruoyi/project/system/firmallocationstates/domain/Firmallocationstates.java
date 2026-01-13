package com.ruoyi.project.system.firmallocationstates.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 初始分配方案对象 firmallocationstates
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public class Firmallocationstates extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 该企业负责生产的物料或零部件 */
    @Excel(name = "该企业负责生产的物料或零部件")
    private String offerproduct;

    /** 该企业订单分配量 */
    @Excel(name = "该企业订单分配量")
    private Long allocations;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** 编号 */
    private Long id;

    public void setOfferproduct(String offerproduct) 
    {
        this.offerproduct = offerproduct;
    }

    public String getOfferproduct() 
    {
        return offerproduct;
    }
    public void setAllocations(Long allocations) 
    {
        this.allocations = allocations;
    }

    public Long getAllocations() 
    {
        return allocations;
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
            .append("offerproduct", getOfferproduct())
            .append("allocations", getAllocations())
            .append("firmname", getFirmname())
            .append("id", getId())
            .toString();
    }
}
