package com.ruoyi.project.system.customer.mapper;

import java.util.List;
import com.ruoyi.project.system.customer.domain.DsCustomer;

/**
 * customerMapper接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface DsCustomerMapper 
{
    /**
     * 查询customer
     * 
     * @param customerid customerID
     * @return customer
     */
    public DsCustomer selectDsCustomerById(Long customerid);

    /**
     * 查询customer列表
     * 
     * @param dsCustomer customer
     * @return customer集合
     */
    public List<DsCustomer> selectDsCustomerList(DsCustomer dsCustomer);

    /**
     * 新增customer
     * 
     * @param dsCustomer customer
     * @return 结果
     */
    public int insertDsCustomer(DsCustomer dsCustomer);

    /**
     * 修改customer
     * 
     * @param dsCustomer customer
     * @return 结果
     */
    public int updateDsCustomer(DsCustomer dsCustomer);

    /**
     * 删除customer
     * 
     * @param customerid customerID
     * @return 结果
     */
    public int deleteDsCustomerById(Long customerid);

    /**
     * 批量删除customer
     * 
     * @param customerids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsCustomerByIds(String[] customerids);

    public List selectCustomerId();
}
