package com.ruoyi.project.system.parameter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 参数信息对象 ds_parameter
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsParameter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 参数ID（标识、主键） */
    @Excel(name = "参数ID", readConverterExp = "标=识、主键")
    private Long parameterid;

    /** 参数名称 */
    @Excel(name = "参数名称")
    private String parametername;

    /** 参数描述 */
    @Excel(name = "参数描述")
    private String parameterdescription;

    /** 参数单位 */
    @Excel(name = "参数单位")
    private String parameterunit;

    public void setParameterid(Long parameterid) 
    {
        this.parameterid = parameterid;
    }

    public Long getParameterid() 
    {
        return parameterid;
    }
    public void setParametername(String parametername) 
    {
        this.parametername = parametername;
    }

    public String getParametername() 
    {
        return parametername;
    }
    public void setParameterdescription(String parameterdescription) 
    {
        this.parameterdescription = parameterdescription;
    }

    public String getParameterdescription() 
    {
        return parameterdescription;
    }
    public void setParameterunit(String parameterunit) 
    {
        this.parameterunit = parameterunit;
    }

    public String getParameterunit() 
    {
        return parameterunit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("parameterid", getParameterid())
            .append("parametername", getParametername())
            .append("parameterdescription", getParameterdescription())
            .append("parameterunit", getParameterunit())
            .toString();
    }
}
