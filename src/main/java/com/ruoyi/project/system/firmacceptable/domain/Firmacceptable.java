package com.ruoyi.project.system.firmacceptable.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 可接受不可操作的程度对象 firmacceptable
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public class Firmacceptable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 可接受不可操作性程度 */
    @Excel(name = "可接受不可操作性程度")
    private Double acceptablechange;

    /** 企业名称 */
    @Excel(name = "企业名称")
    private String firmname;

    /** null */
    private Long id;

    public void setAcceptablechange(Double acceptablechange) 
    {
        this.acceptablechange = acceptablechange;
    }

    public Double getAcceptablechange() 
    {
        return acceptablechange;
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
            .append("acceptablechange", getAcceptablechange())
            .append("firmname", getFirmname())
            .append("id", getId())
            .toString();
    }
}
