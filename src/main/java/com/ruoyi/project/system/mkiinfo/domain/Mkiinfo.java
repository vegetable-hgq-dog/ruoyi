package com.ruoyi.project.system.mkiinfo.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 制造知识信息对象 mkiinfo
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public class Mkiinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 制造知识ID */
    private Long mkiid;

    /** 制造知识名称 */
    @Excel(name = "制造知识名称")
    private String mkiname;

    /** 工艺 */
    @Excel(name = "工艺")
    private String processname;

    /** 材料 */
    @Excel(name = "材料")
    private String materialname;

    /** 零部件 */
    @Excel(name = "零部件")
    private String partname;

    /** 制造特征 */
    @Excel(name = "制造特征")
    private String manufacturingfeaturename;

    /** 设计特征 */
    @Excel(name = "设计特征")
    private String shapefeaturename;

    /** 类型 */
    @Excel(name = "类型")
    private String ktypename;

    /** 知识文本 */
    @Excel(name = "知识文本")
    private String details;

    /** 时间 */
    @Excel(name = "时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date edittime;

    //ktype  num
    private Long ktypenum;

    public Long getKtypenum() {
        return ktypenum;
    }

    public void setKtypenum(Long ktypenum) {
        this.ktypenum = ktypenum;
    }

    //process num
    private Long processnum;

    public Long getProcessnum() {
        return processnum;
    }

    public void setProcessnum(Long processnum) {
        this.processnum = processnum;
    }

    public void setMkiid(Long mkiid)
    {
        this.mkiid = mkiid;
    }

    public Long getMkiid() 
    {
        return mkiid;
    }
    public void setMkiname(String mkiname) 
    {
        this.mkiname = mkiname;
    }

    public String getMkiname() 
    {
        return mkiname;
    }
    public void setProcessname(String processname) 
    {
        this.processname = processname;
    }

    public String getProcessname() 
    {
        return processname;
    }
    public void setMaterialname(String materialname) 
    {
        this.materialname = materialname;
    }

    public String getMaterialname() 
    {
        return materialname;
    }
    public void setPartname(String partname) 
    {
        this.partname = partname;
    }

    public String getPartname() 
    {
        return partname;
    }
    public void setManufacturingfeaturename(String manufacturingfeaturename) 
    {
        this.manufacturingfeaturename = manufacturingfeaturename;
    }

    public String getManufacturingfeaturename() 
    {
        return manufacturingfeaturename;
    }
    public void setShapefeaturename(String shapefeaturename) 
    {
        this.shapefeaturename = shapefeaturename;
    }

    public String getShapefeaturename() 
    {
        return shapefeaturename;
    }
    public void setKtypename(String ktypename) 
    {
        this.ktypename = ktypename;
    }

    public String getKtypename() 
    {
        return ktypename;
    }
    public void setDetails(String details) 
    {
        this.details = details;
    }

    public String getDetails() 
    {
        return details;
    }
    public void setEdittime(Date edittime) 
    {
        this.edittime = edittime;
    }

    public Date getEdittime() 
    {
        return edittime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mkiid", getMkiid())
            .append("mkiname", getMkiname())
            .append("processname", getProcessname())
            .append("materialname", getMaterialname())
            .append("partname", getPartname())
            .append("manufacturingfeaturename", getManufacturingfeaturename())
            .append("shapefeaturename", getShapefeaturename())
            .append("ktypename", getKtypename())
            .append("details", getDetails())
            .append("edittime", getEdittime())
            .append("ktypenum",getKtypenum())
            .append("processnum",getProcessnum())
            .toString();
    }
}
