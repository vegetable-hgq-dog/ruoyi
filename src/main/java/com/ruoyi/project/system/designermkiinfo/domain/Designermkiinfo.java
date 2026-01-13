package com.ruoyi.project.system.designermkiinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 研发人员知识交互信息对象 designermkiinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Designermkiinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 制造知识ID */
    @Excel(name = "制造知识ID")
    private Long mkiid;

    /** 设计者ID */
    @Excel(name = "设计者ID")
    private Long designerid;

    /** 交互次数 */
    @Excel(name = "交互次数")
    private Long interactionnum;

    public void setMkiid(Long mkiid) 
    {
        this.mkiid = mkiid;
    }

    public Long getMkiid() 
    {
        return mkiid;
    }
    public void setDesignerid(Long designerid) 
    {
        this.designerid = designerid;
    }

    public Long getDesignerid() 
    {
        return designerid;
    }
    public void setInteractionnum(Long interactionnum) 
    {
        this.interactionnum = interactionnum;
    }

    public Long getInteractionnum() 
    {
        return interactionnum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mkiid", getMkiid())
            .append("designerid", getDesignerid())
            .append("interactionnum", getInteractionnum())
            .toString();
    }
}
