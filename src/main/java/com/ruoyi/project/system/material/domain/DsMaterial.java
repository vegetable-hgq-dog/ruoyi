package com.ruoyi.project.system.material.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 材料信息对象 ds_material
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料序号 */
    @Excel(name = "材料序号")
    private Long materialid;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialname;

    /** 材料类型 */
    @Excel(name = "材料类型")
    private String materialtype;

    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }
    public void setMaterialname(String materialname) 
    {
        this.materialname = materialname;
    }

    public String getMaterialname() 
    {
        return materialname;
    }
    public void setMaterialtype(String materialtype) 
    {
        this.materialtype = materialtype;
    }

    public String getMaterialtype() 
    {
        return materialtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialid", getMaterialid())
            .append("materialname", getMaterialname())
            .append("materialtype", getMaterialtype())
            .toString();
    }
}
