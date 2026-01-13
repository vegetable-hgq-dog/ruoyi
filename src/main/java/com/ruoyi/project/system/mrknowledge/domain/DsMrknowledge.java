package com.ruoyi.project.system.mrknowledge.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 制造需求对象 ds_mrknowledge
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsMrknowledge extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 需求编号 */
    @Excel(name = "需求编号")
    private Long mritemid;

    /** 需求类型 */
    @Excel(name = "需求类型")
    private String mritemtype;

    /** 需求详情 */
    @Excel(name = "需求详情")
    private String mritemcontent;

    /** 所属特征编号 */
    @Excel(name = "所属特征编号")
    private Long featureid;

    public void setMritemid(Long mritemid) 
    {
        this.mritemid = mritemid;
    }

    public Long getMritemid() 
    {
        return mritemid;
    }
    public void setMritemtype(String mritemtype) 
    {
        this.mritemtype = mritemtype;
    }

    public String getMritemtype() 
    {
        return mritemtype;
    }
    public void setMritemcontent(String mritemcontent) 
    {
        this.mritemcontent = mritemcontent;
    }

    public String getMritemcontent() 
    {
        return mritemcontent;
    }
    public void setFeatureid(Long featureid) 
    {
        this.featureid = featureid;
    }

    public Long getFeatureid() 
    {
        return featureid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mritemid", getMritemid())
            .append("mritemtype", getMritemtype())
            .append("mritemcontent", getMritemcontent())
            .append("featureid", getFeatureid())
            .toString();
    }
}
