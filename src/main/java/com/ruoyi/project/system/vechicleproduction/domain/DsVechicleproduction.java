package com.ruoyi.project.system.vechicleproduction.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 生产信息对象 ds_vechicleproduction
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public class DsVechicleproduction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long vechicleproductionid;

    /** 产线编号 */
    @Excel(name = "产线编号")
    private Long productlineid;

    /** 车型编号 */
    @Excel(name = "车型编号")
    private Long vechicletypeid;

    /** 规划开始时间 */
    @Excel(name = "规划开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionplantime;

    /** 规划生产数量 */
    @Excel(name = "规划生产数量")
    private Long productionplannum;

    /** 生产开始时间 */
    @Excel(name = "生产开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date productionstarttime;

    /** 已生产数量 */
    @Excel(name = "已生产数量")
    private Long productionnum;

    /** 当前状态 */
    @Excel(name = "当前状态")
    private String currentstatus;

    public void setVechicleproductionid(Long vechicleproductionid) 
    {
        this.vechicleproductionid = vechicleproductionid;
    }

    public Long getVechicleproductionid() 
    {
        return vechicleproductionid;
    }
    public void setProductlineid(Long productlineid) 
    {
        this.productlineid = productlineid;
    }

    public Long getProductlineid() 
    {
        return productlineid;
    }
    public void setVechicletypeid(Long vechicletypeid) 
    {
        this.vechicletypeid = vechicletypeid;
    }

    public Long getVechicletypeid() 
    {
        return vechicletypeid;
    }
    public void setProductionplantime(Date productionplantime) 
    {
        this.productionplantime = productionplantime;
    }

    public Date getProductionplantime() 
    {
        return productionplantime;
    }
    public void setProductionplannum(Long productionplannum) 
    {
        this.productionplannum = productionplannum;
    }

    public Long getProductionplannum() 
    {
        return productionplannum;
    }
    public void setProductionstarttime(Date productionstarttime) 
    {
        this.productionstarttime = productionstarttime;
    }

    public Date getProductionstarttime() 
    {
        return productionstarttime;
    }
    public void setProductionnum(Long productionnum) 
    {
        this.productionnum = productionnum;
    }

    public Long getProductionnum() 
    {
        return productionnum;
    }
    public void setCurrentstatus(String currentstatus) 
    {
        this.currentstatus = currentstatus;
    }

    public String getCurrentstatus() 
    {
        return currentstatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("vechicleproductionid", getVechicleproductionid())
            .append("productlineid", getProductlineid())
            .append("vechicletypeid", getVechicletypeid())
            .append("productionplantime", getProductionplantime())
            .append("productionplannum", getProductionplannum())
            .append("productionstarttime", getProductionstarttime())
            .append("productionnum", getProductionnum())
            .append("currentstatus", getCurrentstatus())
            .toString();
    }
}
