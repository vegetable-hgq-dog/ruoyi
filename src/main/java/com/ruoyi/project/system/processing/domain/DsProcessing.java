package com.ruoyi.project.system.processing.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 工艺信息对象 ds_processing
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsProcessing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private Long processingid;

    /** 工艺名称 */
    @Excel(name = "工艺名称")
    private String processingname;

    /** 工艺类型 */
    @Excel(name = "工艺类型")
    private String processingtype;

    /** 工艺设备 */
    @Excel(name = "工艺设备")
    private String processingdevice;

    /** 工艺内容 */
    @Excel(name = "工艺内容")
    private String processingcontent;

    /** 所属特征编号 */
    @Excel(name = "所属特征编号")
    private Long featureid;

    public void setProcessingid(Long processingid) 
    {
        this.processingid = processingid;
    }

    public Long getProcessingid() 
    {
        return processingid;
    }
    public void setProcessingname(String processingname) 
    {
        this.processingname = processingname;
    }

    public String getProcessingname() 
    {
        return processingname;
    }
    public void setProcessingtype(String processingtype) 
    {
        this.processingtype = processingtype;
    }

    public String getProcessingtype() 
    {
        return processingtype;
    }
    public void setProcessingdevice(String processingdevice) 
    {
        this.processingdevice = processingdevice;
    }

    public String getProcessingdevice() 
    {
        return processingdevice;
    }
    public void setProcessingcontent(String processingcontent) 
    {
        this.processingcontent = processingcontent;
    }

    public String getProcessingcontent() 
    {
        return processingcontent;
    }
    public void setFeatureid(Long featureid) 
    {
        this.featureid = featureid;
    }

    public Long getFeatureid() 
    {
        return featureid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("processingid", getProcessingid())
            .append("processingname", getProcessingname())
            .append("processingtype", getProcessingtype())
            .append("processingdevice", getProcessingdevice())
            .append("processingcontent", getProcessingcontent())
            .append("featureid", getFeatureid())
            .toString();
    }
}
