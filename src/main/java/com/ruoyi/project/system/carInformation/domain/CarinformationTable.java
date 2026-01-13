package com.ruoyi.project.system.carInformation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 车辆信息对象 carinformation_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class CarinformationTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车型 */
    @Excel(name = "车型", readConverterExp = "1=12.5m重型半挂牵引车,2=15m箱式飞翼车,3=9.6m厢式飞翼车",prompt = "1=12.5m重型半挂牵引车,2=15m箱式飞翼车,3=9.6m厢式飞翼车")
    private String cartype;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String licenseplate;

    /** 序号 */
    private Long id;

    public void setCartype(String cartype) 
    {
        this.cartype = cartype;
    }

    public String getCartype() 
    {
        return cartype;
    }
    public void setLicenseplate(String licenseplate) 
    {
        this.licenseplate = licenseplate;
    }

    public String getLicenseplate() 
    {
        return licenseplate;
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
            .append("cartype", getCartype())
            .append("licenseplate", getLicenseplate())
            .append("id", getId())
            .toString();
    }
}
