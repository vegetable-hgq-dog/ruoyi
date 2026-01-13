package com.ruoyi.project.system.productline.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 产线信息对象 ds_productline
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsProductline extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产线ID（标识、主键） */
    private Long productlineid;

    /** 产线名称 */
    @Excel(name = "产线名称")
    private String productlinename;

    /** 产线类型 */
    @Excel(name = "产线类型")
    private String productlinetype;

    /** 所属车间 */
    @Excel(name = "所属车间")
    private Long workshopid;

    public void setProductlineid(Long productlineid) 
    {
        this.productlineid = productlineid;
    }

    public Long getProductlineid() 
    {
        return productlineid;
    }
    public void setProductlinename(String productlinename) 
    {
        this.productlinename = productlinename;
    }

    public String getProductlinename() 
    {
        return productlinename;
    }
    public void setProductlinetype(String productlinetype) 
    {
        this.productlinetype = productlinetype;
    }

    public String getProductlinetype() 
    {
        return productlinetype;
    }
    public void setWorkshopid(Long workshopid) 
    {
        this.workshopid = workshopid;
    }

    public Long getWorkshopid() 
    {
        return workshopid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("productlineid", getProductlineid())
            .append("productlinename", getProductlinename())
            .append("productlinetype", getProductlinetype())
            .append("workshopid", getWorkshopid())
            .toString();
    }
}
