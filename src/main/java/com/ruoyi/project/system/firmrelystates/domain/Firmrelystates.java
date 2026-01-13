package com.ruoyi.project.system.firmrelystates.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 企业群数据管理对象 firmrelystates
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public class Firmrelystates extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 依赖程度 */
    @Excel(name = "依赖程度")
    private String relydegree;

    /** 关联企业名称 */
    @Excel(name = "关联企业名称")
    private String relyfirmname;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** 编号 */
    private Long id;

    public void setRelydegree(String relydegree) 
    {
        this.relydegree = relydegree;
    }

    public String getRelydegree() 
    {
        return relydegree;
    }
    public void setRelyfirmname(String relyfirmname) 
    {
        this.relyfirmname = relyfirmname;
    }

    public String getRelyfirmname() 
    {
        return relyfirmname;
    }
    public void setFirmname(String firmname) 
    {
        this.firmname = firmname;
    }

    public String getFirmname() 
    {
        return firmname;
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
            .append("relydegree", getRelydegree())
            .append("relyfirmname", getRelyfirmname())
            .append("firmname", getFirmname())
            .append("id", getId())
            .toString();
    }
}
