package com.ruoyi.project.system.processinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工艺信息对象 processinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Processinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺ID */
    private Long processid;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String processname;

    /** 工艺类型 */
    @Excel(name = "工艺类型")
    private String processtype;

    public void setProcessid(Long processid) 
    {
        this.processid = processid;
    }

    public Long getProcessid() 
    {
        return processid;
    }
    public void setProcessname(String processname) 
    {
        this.processname = processname;
    }

    public String getProcessname() 
    {
        return processname;
    }
    public void setProcesstype(String processtype) 
    {
        this.processtype = processtype;
    }

    public String getProcesstype() 
    {
        return processtype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("processid", getProcessid())
            .append("processname", getProcessname())
            .append("processtype", getProcesstype())
            .toString();
    }
}
