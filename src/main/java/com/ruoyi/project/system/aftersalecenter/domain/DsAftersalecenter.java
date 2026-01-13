package com.ruoyi.project.system.aftersalecenter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * aftersalecenter对象 ds_aftersalecenter
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public class DsAftersalecenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 负责人 */
    @Excel(name = "负责人")
    private String centerleader;

    /** 中心电话 */
    @Excel(name = "中心电话")
    private Long centerphone;

    /** 中心所在地 */
    @Excel(name = "中心所在地")
    private String centerlocation;

    /** 中心ID */
    private Long centerid;

    public void setCenterleader(String centerleader) 
    {
        this.centerleader = centerleader;
    }

    public String getCenterleader() 
    {
        return centerleader;
    }
    public void setCenterphone(Long centerphone) 
    {
        this.centerphone = centerphone;
    }

    public Long getCenterphone() 
    {
        return centerphone;
    }
    public void setCenterlocation(String centerlocation) 
    {
        this.centerlocation = centerlocation;
    }

    public String getCenterlocation() 
    {
        return centerlocation;
    }
    public void setCenterid(Long centerid) 
    {
        this.centerid = centerid;
    }

    public Long getCenterid() 
    {
        return centerid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("centerleader", getCenterleader())
            .append("centerphone", getCenterphone())
            .append("centerlocation", getCenterlocation())
            .append("centerid", getCenterid())
            .toString();
    }
}
