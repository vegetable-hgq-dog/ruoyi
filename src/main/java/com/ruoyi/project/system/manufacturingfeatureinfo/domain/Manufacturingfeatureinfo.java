package com.ruoyi.project.system.manufacturingfeatureinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 制造特征对象 manufacturingfeatureinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Manufacturingfeatureinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 制造特征ID */
    private Long manufacturingfeatureid;

    /** 制造特征名称 */
    @Excel(name = "制造特征名称")
    private String manufacturingfeaturename;

    /** 制造特征类型 */
    @Excel(name = "制造特征类型")
    private String manufacturingfeaturetype;

    public void setManufacturingfeatureid(Long manufacturingfeatureid) 
    {
        this.manufacturingfeatureid = manufacturingfeatureid;
    }

    public Long getManufacturingfeatureid() 
    {
        return manufacturingfeatureid;
    }
    public void setManufacturingfeaturename(String manufacturingfeaturename) 
    {
        this.manufacturingfeaturename = manufacturingfeaturename;
    }

    public String getManufacturingfeaturename() 
    {
        return manufacturingfeaturename;
    }
    public void setManufacturingfeaturetype(String manufacturingfeaturetype) 
    {
        this.manufacturingfeaturetype = manufacturingfeaturetype;
    }

    public String getManufacturingfeaturetype() 
    {
        return manufacturingfeaturetype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("manufacturingfeatureid", getManufacturingfeatureid())
            .append("manufacturingfeaturename", getManufacturingfeaturename())
            .append("manufacturingfeaturetype", getManufacturingfeaturetype())
            .toString();
    }
}
