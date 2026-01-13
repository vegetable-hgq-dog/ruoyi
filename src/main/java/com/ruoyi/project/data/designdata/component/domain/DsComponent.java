package com.ruoyi.project.data.designdata.component.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.TreeEntity;

/**
 * 产品信息对象 ds_component
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsComponent extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private Long componentid;

    /** 产品父编号 */
    @Excel(name = "产品父编号")
    private Long componentfatherid;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String componentname;

    /** 产品类型 */
    @Excel(name = "产品类型")
    private String componentlevel;

    /** 产品模型 */
    @Excel(name = "产品模型")
    private String componentmodel;

    /** 产品文档 */
    @Excel(name = "产品文档")
    private String componentstandard;

    /** 产品来源 */
    @Excel(name = "产品来源")
    private String componenttype;

    /** 产品材料 */
    private Long materialid;

    public void setComponentid(Long componentid) 
    {
        this.componentid = componentid;
    }

    public Long getComponentid() 
    {
        return componentid;
    }
    public void setComponentfatherid(Long componentfatherid) 
    {
        this.componentfatherid = componentfatherid;
    }

    public Long getComponentfatherid() 
    {
        return componentfatherid;
    }
    public void setComponentname(String componentname) 
    {
        this.componentname = componentname;
    }

    public String getComponentname() 
    {
        return componentname;
    }
    public void setComponentlevel(String componentlevel) 
    {
        this.componentlevel = componentlevel;
    }

    public String getComponentlevel() 
    {
        return componentlevel;
    }
    public void setComponentmodel(String componentmodel) 
    {
        this.componentmodel = componentmodel;
    }

    public String getComponentmodel() 
    {
        return componentmodel;
    }
    public void setComponentstandard(String componentstandard) 
    {
        this.componentstandard = componentstandard;
    }

    public String getComponentstandard() 
    {
        return componentstandard;
    }
    public void setComponenttype(String componenttype) 
    {
        this.componenttype = componenttype;
    }

    public String getComponenttype() 
    {
        return componenttype;
    }
    public void setMaterialid(Long materialid) 
    {
        this.materialid = materialid;
    }

    public Long getMaterialid() 
    {
        return materialid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("componentid", getComponentid())
            .append("componentfatherid", getComponentfatherid())
            .append("componentname", getComponentname())
            .append("componentlevel", getComponentlevel())
            .append("componentmodel", getComponentmodel())
            .append("componentstandard", getComponentstandard())
            .append("componenttype", getComponenttype())
            .append("materialid", getMaterialid())
            .toString();
    }
}
