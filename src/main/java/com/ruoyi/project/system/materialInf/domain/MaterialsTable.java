package com.ruoyi.project.system.materialInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 物料信息对象 materials_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class MaterialsTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialname;

    /** 供应商编号 */
    @Excel(name = "供应商编号")
    private String supplierid;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private String factoryid;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private String materialid;

    /** 序号 */
    private Long id;

    public void setMaterialname(String materialname) 
    {
        this.materialname = materialname;
    }

    public String getMaterialname() 
    {
        return materialname;
    }
    public void setSupplierid(String supplierid) 
    {
        this.supplierid = supplierid;
    }

    public String getSupplierid() 
    {
        return supplierid;
    }
    public void setFactoryid(String factoryid) 
    {
        this.factoryid = factoryid;
    }

    public String getFactoryid() 
    {
        return factoryid;
    }
    public void setMaterialid(String materialid) 
    {
        this.materialid = materialid;
    }

    public String getMaterialid() 
    {
        return materialid;
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
            .append("materialname", getMaterialname())
            .append("supplierid", getSupplierid())
            .append("factoryid", getFactoryid())
            .append("materialid", getMaterialid())
            .append("id", getId())
            .toString();
    }
}
