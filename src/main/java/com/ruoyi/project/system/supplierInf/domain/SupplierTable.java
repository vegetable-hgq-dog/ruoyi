package com.ruoyi.project.system.supplierInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 供应商信息对象 supplier_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class SupplierTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 供应商地址 */
    @Excel(name = "供应商地址")
    private String supplieraddress;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String suppliername;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierid;

    /** 序号 */
    private Long id;

    public void setSupplieraddress(String supplieraddress) 
    {
        this.supplieraddress = supplieraddress;
    }

    public String getSupplieraddress() 
    {
        return supplieraddress;
    }
    public void setSuppliername(String suppliername) 
    {
        this.suppliername = suppliername;
    }

    public String getSuppliername() 
    {
        return suppliername;
    }
    public void setSupplierid(String supplierid) 
    {
        this.supplierid = supplierid;
    }

    public String getSupplierid() 
    {
        return supplierid;
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
            .append("supplieraddress", getSupplieraddress())
            .append("suppliername", getSuppliername())
            .append("supplierid", getSupplierid())
            .append("id", getId())
            .toString();
    }
}
