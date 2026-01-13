package com.ruoyi.project.system.customer.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * customer对象 ds_customer
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsCustomer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer customerage;

    /** 所在地 */
    @Excel(name = "所在地")
    private String customerbuyplace;

    /** 性别 */
    @Excel(name = "性别")
    private String customersex;

    /** 顾客姓名 */
    @Excel(name = "顾客姓名")
    private String customername;

    /** 顾客ID */
    private Long customerid;

    public void setCustomerage(Integer customerage) 
    {
        this.customerage = customerage;
    }

    public Integer getCustomerage() 
    {
        return customerage;
    }
    public void setCustomerbuyplace(String customerbuyplace) 
    {
        this.customerbuyplace = customerbuyplace;
    }

    public String getCustomerbuyplace() 
    {
        return customerbuyplace;
    }
    public void setCustomersex(String customersex) 
    {
        this.customersex = customersex;
    }

    public String getCustomersex() 
    {
        return customersex;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }

    public String getCustomername() 
    {
        return customername;
    }
    public void setCustomerid(Long customerid) 
    {
        this.customerid = customerid;
    }

    public Long getCustomerid() 
    {
        return customerid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerage", getCustomerage())
            .append("customerbuyplace", getCustomerbuyplace())
            .append("customersex", getCustomersex())
            .append("customername", getCustomername())
            .append("customerid", getCustomerid())
            .toString();
    }
}
