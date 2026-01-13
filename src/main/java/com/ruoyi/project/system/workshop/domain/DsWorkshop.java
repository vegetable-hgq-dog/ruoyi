package com.ruoyi.project.system.workshop.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 车间信息对象 ds_workshop
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsWorkshop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车间编号 */
    @Excel(name = "车间编号")
    private Long workshopid;

    /** 工厂编号 */
    @Excel(name = "工厂编号")
    private Long factoryid;

    /** 车间名称 */
    @Excel(name = "车间名称")
    private String workshopname;

    /** 车间类型 */
    @Excel(name = "车间类型")
    private String workshoptype;

    public void setWorkshopid(Long workshopid) 
    {
        this.workshopid = workshopid;
    }

    public Long getWorkshopid() 
    {
        return workshopid;
    }
    public void setFactoryid(Long factoryid) 
    {
        this.factoryid = factoryid;
    }

    public Long getFactoryid() 
    {
        return factoryid;
    }
    public void setWorkshopname(String workshopname) 
    {
        this.workshopname = workshopname;
    }

    public String getWorkshopname() 
    {
        return workshopname;
    }
    public void setWorkshoptype(String workshoptype) 
    {
        this.workshoptype = workshoptype;
    }

    public String getWorkshoptype() 
    {
        return workshoptype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("workshopid", getWorkshopid())
            .append("factoryid", getFactoryid())
            .append("workshopname", getWorkshopname())
            .append("workshoptype", getWorkshoptype())
            .toString();
    }
}
