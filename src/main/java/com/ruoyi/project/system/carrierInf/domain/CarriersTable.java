package com.ruoyi.project.system.carrierInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 承运商信息对象 carriers_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class CarriersTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 承运商联系方式 */
    @Excel(name = "承运商联系方式")
    private String contactinformation;

    /** 承运商联系人 */
    @Excel(name = "承运商联系人")
    private String carriercontacts;

    /** 承运商名称 */
    @Excel(name = "承运商名称")
    private String carriername;

    /** 序号 */
    private Long id;

    public void setContactinformation(String contactinformation) 
    {
        this.contactinformation = contactinformation;
    }

    public String getContactinformation() 
    {
        return contactinformation;
    }
    public void setCarriercontacts(String carriercontacts) 
    {
        this.carriercontacts = carriercontacts;
    }

    public String getCarriercontacts() 
    {
        return carriercontacts;
    }
    public void setCarriername(String carriername) 
    {
        this.carriername = carriername;
    }

    public String getCarriername() 
    {
        return carriername;
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
            .append("contactinformation", getContactinformation())
            .append("carriercontacts", getCarriercontacts())
            .append("carriername", getCarriername())
            .append("id", getId())
            .toString();
    }
}
