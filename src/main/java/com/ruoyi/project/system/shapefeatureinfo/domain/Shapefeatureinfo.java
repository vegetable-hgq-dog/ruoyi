package com.ruoyi.project.system.shapefeatureinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 设计特征信息对象 shapefeatureinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Shapefeatureinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设计特征ID */
    private Long shapefeatureid;

    /** 设计特征名称 */
    @Excel(name = "设计特征名称")
    private String shapefeaturename;

    /** 设计特征类型 */
    @Excel(name = "设计特征类型")
    private String shapefeaturetype;

    public void setShapefeatureid(Long shapefeatureid) 
    {
        this.shapefeatureid = shapefeatureid;
    }

    public Long getShapefeatureid() 
    {
        return shapefeatureid;
    }
    public void setShapefeaturename(String shapefeaturename) 
    {
        this.shapefeaturename = shapefeaturename;
    }

    public String getShapefeaturename() 
    {
        return shapefeaturename;
    }
    public void setShapefeaturetype(String shapefeaturetype) 
    {
        this.shapefeaturetype = shapefeaturetype;
    }

    public String getShapefeaturetype() 
    {
        return shapefeaturetype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shapefeatureid", getShapefeatureid())
            .append("shapefeaturename", getShapefeaturename())
            .append("shapefeaturetype", getShapefeaturetype())
            .toString();
    }
}
