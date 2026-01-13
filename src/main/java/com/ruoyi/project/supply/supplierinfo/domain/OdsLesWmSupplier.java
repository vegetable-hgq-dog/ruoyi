package com.ruoyi.project.supply.supplierinfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * supplier_info对象 ods_les_wm_supplier
 * 
 * @author xjtu
 * @date 2023-08-03
 */
public class OdsLesWmSupplier extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private String xngys;

    /** null */
    @Excel(name = "null", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyDateTime;

    /** null */
    private String modifyUser;

    /** null */
    private Date createDateTime;

    /** null */
    private String createUser;

    /** null */
    private String processNo;

    /** null */
    private String smtpAddr;

    /** null */
    private String zsutype;

    /** null */
    private String telf;

    /** null */
    private String opt00;

    /** null */
    private String name;

    /** null */
    private String name1;

    /** 城市 */
    @Excel(name = "城市")
    private String regio;

    /** null */
    private String identification;

    /** null */
    private String lockFlag;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 电话 */
    @Excel(name = "电话")
    private String telephone;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contact;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 名称 */
    @Excel(name = "名称")
    private String supplierText;

    /** 供应商编码 */
    @Excel(name = "供应商编码")
    private String supplierCode;

    /** 工厂 */
    @Excel(name = "工厂")
    private String warehouseCode;

    /** 供应商序号 */
    private Long id;

    /** ID */
    private Long autoid;

    public void setXngys(String xngys) 
    {
        this.xngys = xngys;
    }

    public String getXngys() 
    {
        return xngys;
    }
    public void setModifyDateTime(Date modifyDateTime) 
    {
        this.modifyDateTime = modifyDateTime;
    }

    public Date getModifyDateTime() 
    {
        return modifyDateTime;
    }
    public void setModifyUser(String modifyUser) 
    {
        this.modifyUser = modifyUser;
    }

    public String getModifyUser() 
    {
        return modifyUser;
    }
    public void setCreateDateTime(Date createDateTime) 
    {
        this.createDateTime = createDateTime;
    }

    public Date getCreateDateTime() 
    {
        return createDateTime;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }
    public void setProcessNo(String processNo) 
    {
        this.processNo = processNo;
    }

    public String getProcessNo() 
    {
        return processNo;
    }
    public void setSmtpAddr(String smtpAddr) 
    {
        this.smtpAddr = smtpAddr;
    }

    public String getSmtpAddr() 
    {
        return smtpAddr;
    }
    public void setZsutype(String zsutype) 
    {
        this.zsutype = zsutype;
    }

    public String getZsutype() 
    {
        return zsutype;
    }
    public void setTelf(String telf) 
    {
        this.telf = telf;
    }

    public String getTelf() 
    {
        return telf;
    }
    public void setOpt00(String opt00) 
    {
        this.opt00 = opt00;
    }

    public String getOpt00() 
    {
        return opt00;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setName1(String name1) 
    {
        this.name1 = name1;
    }

    public String getName1() 
    {
        return name1;
    }
    public void setRegio(String regio) 
    {
        this.regio = regio;
    }

    public String getRegio() 
    {
        return regio;
    }
    public void setIdentification(String identification) 
    {
        this.identification = identification;
    }

    public String getIdentification() 
    {
        return identification;
    }
    public void setLockFlag(String lockFlag) 
    {
        this.lockFlag = lockFlag;
    }

    public String getLockFlag() 
    {
        return lockFlag;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setSupplierText(String supplierText) 
    {
        this.supplierText = supplierText;
    }

    public String getSupplierText() 
    {
        return supplierText;
    }
    public void setSupplierCode(String supplierCode) 
    {
        this.supplierCode = supplierCode;
    }

    public String getSupplierCode() 
    {
        return supplierCode;
    }
    public void setWarehouseCode(String warehouseCode) 
    {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseCode() 
    {
        return warehouseCode;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAutoid(Long autoid) 
    {
        this.autoid = autoid;
    }

    public Long getAutoid() 
    {
        return autoid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xngys", getXngys())
            .append("modifyDateTime", getModifyDateTime())
            .append("modifyUser", getModifyUser())
            .append("createDateTime", getCreateDateTime())
            .append("createUser", getCreateUser())
            .append("processNo", getProcessNo())
            .append("smtpAddr", getSmtpAddr())
            .append("zsutype", getZsutype())
            .append("telf", getTelf())
            .append("opt00", getOpt00())
            .append("name", getName())
            .append("name1", getName1())
            .append("regio", getRegio())
            .append("identification", getIdentification())
            .append("lockFlag", getLockFlag())
            .append("email", getEmail())
            .append("telephone", getTelephone())
            .append("contact", getContact())
            .append("address", getAddress())
            .append("supplierText", getSupplierText())
            .append("supplierCode", getSupplierCode())
            .append("warehouseCode", getWarehouseCode())
            .append("id", getId())
            .append("autoid", getAutoid())
            .toString();
    }
}
