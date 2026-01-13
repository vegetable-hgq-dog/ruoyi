package com.ruoyi.project.system.ktypeinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 知识类型对象 ktypeinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Ktypeinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 知识类型ID */
    private Long ktypeid;

    /** 知识类型名称 */
    @Excel(name = "知识类型名称")
    private String ktypename;

    /** 知识类型类型 */
    @Excel(name = "知识类型类型")
    private String ktypetype;

    public void setKtypeid(Long ktypeid) 
    {
        this.ktypeid = ktypeid;
    }

    public Long getKtypeid() 
    {
        return ktypeid;
    }
    public void setKtypename(String ktypename) 
    {
        this.ktypename = ktypename;
    }

    public String getKtypename() 
    {
        return ktypename;
    }
    public void setKtypetype(String ktypetype) 
    {
        this.ktypetype = ktypetype;
    }

    public String getKtypetype() 
    {
        return ktypetype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ktypeid", getKtypeid())
            .append("ktypename", getKtypename())
            .append("ktypetype", getKtypetype())
            .toString();
    }
}
