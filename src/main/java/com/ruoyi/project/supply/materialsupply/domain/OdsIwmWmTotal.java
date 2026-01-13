package com.ruoyi.project.supply.materialsupply.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * material_supply对象 ods_iwm_wm_total
 * 
 * @author xjtu
 * @date 2023-08-03
 */
public class OdsIwmWmTotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存类型 */
    @Excel(name = "库存类型")
    private String materialWareType;

    /** 实际数量 */
    @Excel(name = "实际数量")
    private Long materialWareNum;

    /** 单位 */
    @Excel(name = "单位")
    private String materialUnit;

    /** 物料描述 */
    @Excel(name = "物料描述")
    private String materialText;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String materialCode;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplierName;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 仓库 */
    @Excel(name = "仓库")
    private String warehouseCode;

    /** 工厂 */
    @Excel(name = "工厂")
    private String factorCode;

    /** ID */
    private Long autoid;

    public void setMaterialWareType(String materialWareType) 
    {
        this.materialWareType = materialWareType;
    }

    public String getMaterialWareType() 
    {
        return materialWareType;
    }
    public void setMaterialWareNum(Long materialWareNum) 
    {
        this.materialWareNum = materialWareNum;
    }

    public Long getMaterialWareNum() 
    {
        return materialWareNum;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setMaterialText(String materialText) 
    {
        this.materialText = materialText;
    }

    public String getMaterialText() 
    {
        return materialText;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }
    public void setWarehouseCode(String warehouseCode) 
    {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() 
    {
        return warehouseCode;
    }
    public void setFactorCode(String factorCode) 
    {
        this.factorCode = factorCode;
    }

    public String getFactorCode() 
    {
        return factorCode;
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
            .append("materialWareType", getMaterialWareType())
            .append("materialWareNum", getMaterialWareNum())
            .append("materialUnit", getMaterialUnit())
            .append("materialText", getMaterialText())
            .append("materialCode", getMaterialCode())
            .append("supplierName", getSupplierName())
            .append("supplierCode", getSupplierCode())
            .append("warehouseCode", getWarehouseCode())
            .append("factorCode", getFactorCode())
            .append("autoid", getAutoid())
            .toString();
    }
}
