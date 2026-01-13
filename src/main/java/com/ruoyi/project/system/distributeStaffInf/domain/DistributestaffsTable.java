package com.ruoyi.project.system.distributeStaffInf.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 配送人员对象 distributestaffs_table
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public class DistributestaffsTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 承运商名称 */
    @Excel(name = "承运商名称")
    private String carriername;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telephone;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String drivername;

    /** 序号 */
    private Long id;

    public void setCarriername(String carriername) 
    {
        this.carriername = carriername;
    }

    public String getCarriername() 
    {
        return carriername;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setDrivername(String drivername) 
    {
        this.drivername = drivername;
    }

    public String getDrivername() 
    {
        return drivername;
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
            .append("carriername", getCarriername())
            .append("telephone", getTelephone())
            .append("drivername", getDrivername())
            .append("id", getId())
            .toString();
    }
}
