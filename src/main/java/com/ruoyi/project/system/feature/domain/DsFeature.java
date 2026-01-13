package com.ruoyi.project.system.feature.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 特征信息对象 ds_feature
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsFeature extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 特征编号 */
    @Excel(name = "特征编号")
    private Long featureid;

    /** 特征名称 */
    @Excel(name = "特征名称")
    private String featurename;

    /** 特征类型 */
    @Excel(name = "特征类型")
    private String featuretype;

    /** 制造属性 */
    @Excel(name = "制造属性")
    private String featuremanufacturing;

    /** 所属产品 */
    @Excel(name = "所属产品")
    private Long componentid;

    public void setFeatureid(Long featureid) 
    {
        this.featureid = featureid;
    }

    public Long getFeatureid() 
    {
        return featureid;
    }
    public void setFeaturename(String featurename) 
    {
        this.featurename = featurename;
    }

    public String getFeaturename() 
    {
        return featurename;
    }
    public void setFeaturetype(String featuretype) 
    {
        this.featuretype = featuretype;
    }

    public String getFeaturetype() 
    {
        return featuretype;
    }
    public void setFeaturemanufacturing(String featuremanufacturing) 
    {
        this.featuremanufacturing = featuremanufacturing;
    }

    public String getFeaturemanufacturing() 
    {
        return featuremanufacturing;
    }
    public void setComponentid(Long componentid) 
    {
        this.componentid = componentid;
    }

    public Long getComponentid() 
    {
        return componentid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("featureid", getFeatureid())
            .append("featurename", getFeaturename())
            .append("featuretype", getFeaturetype())
            .append("featuremanufacturing", getFeaturemanufacturing())
            .append("componentid", getComponentid())
            .toString();
    }
}
