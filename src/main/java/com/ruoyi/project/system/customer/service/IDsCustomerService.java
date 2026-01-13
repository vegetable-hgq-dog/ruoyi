package com.ruoyi.project.system.customer.service;

import java.util.List;
import com.ruoyi.project.system.customer.domain.DsCustomer;

/**
 * customerService接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface IDsCustomerService 
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
     * 批量删除customer
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsCustomerByIds(String ids);

    /**
     * 删除customer信息
     * 
     * @param customerid customerID
     * @return 结果
     */
    public int deleteDsCustomerById(Long customerid);

    public List selectCustomerId();
}
