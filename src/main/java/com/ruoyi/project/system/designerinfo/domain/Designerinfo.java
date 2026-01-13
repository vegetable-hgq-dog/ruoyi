package com.ruoyi.project.system.designerinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 研发人员信息对象 designerinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Designerinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设计者ID */
    private Long designerid;

    /** 登录系统用户名 */
    @Excel(name = "登录系统用户名")
    private String designername;

    /** 登录系统密码 */
    @Excel(name = "登录系统密码")
    private String designerpassword;

    public void setDesignerid(Long designerid) 
    {
        this.designerid = designerid;
    }

    public Long getDesignerid() 
    {
        return designerid;
    }
    public void setDesignername(String designername) 
    {
        this.designername = designername;
    }

    public String getDesignername() 
    {
        return designername;
    }
    public void setDesignerpassword(String designerpassword) 
    {
        this.designerpassword = designerpassword;
    }

    public String getDesignerpassword() 
    {
        return designerpassword;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("designerid", getDesignerid())
            .append("designername", getDesignername())
            .append("designerpassword", getDesignerpassword())
            .toString();
    }
}
