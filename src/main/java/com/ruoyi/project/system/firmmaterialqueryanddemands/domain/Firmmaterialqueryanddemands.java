package com.ruoyi.project.system.firmmaterialqueryanddemands.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 需求数据对象 firmmaterialqueryanddemands
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public class Firmmaterialqueryanddemands extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料或零部件需求量 */
    @Excel(name = "物料或零部件需求量")
    private Long demands;

    /** 需要的物料或零部件名称 */
    @Excel(name = "需要的物料或零部件名称")
    private String materialquery;

    /** null */
    private Long id;

    public void setDemands(Long demands) 
    {
        this.demands = demands;
    }

    public Long getDemands() 
    {
        return demands;
    }
    public void setMaterialquery(String materialquery) 
    {
        this.materialquery = materialquery;
    }

    public String getMaterialquery() 
    {
        return materialquery;
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
            .append("demands", getDemands())
            .append("materialquery", getMaterialquery())
            .append("id", getId())
            .toString();
    }
}
