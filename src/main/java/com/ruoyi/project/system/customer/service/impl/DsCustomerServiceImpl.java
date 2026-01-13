package com.ruoyi.project.system.customer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.customer.mapper.DsCustomerMapper;
import com.ruoyi.project.system.customer.domain.DsCustomer;
import com.ruoyi.project.system.customer.service.IDsCustomerService;
import com.ruoyi.common.utils.text.Convert;

/**
 * customerService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsCustomerServiceImpl implements IDsCustomerService 
{
    @Autowired
    private DsCustomerMapper dsCustomerMapper;

    /**
     * 查询customer
     * 
     * @param customerid customerID
     * @return customer
     */
    @Override
    public DsCustomer selectDsCustomerById(Long customerid)
    {
        return dsCustomerMapper.selectDsCustomerById(customerid);
    }

    /**
     * 查询customer列表
     * 
     * @param dsCustomer customer
     * @return customer
     */
    @Override
    public List<DsCustomer> selectDsCustomerList(DsCustomer dsCustomer)
    {
        return dsCustomerMapper.selectDsCustomerList(dsCustomer);
    }

    /**
     * 新增customer
     * 
     * @param dsCustomer customer
     * @return 结果
     */
    @Override
    public int insertDsCustomer(DsCustomer dsCustomer)
    {
        return dsCustomerMapper.insertDsCustomer(dsCustomer);
    }

    /**
     * 修改customer
     * 
     * @param dsCustomer customer
     * @return 结果
     */
    @Override
    public int updateDsCustomer(DsCustomer dsCustomer)
    {
        return dsCustomerMapper.updateDsCustomer(dsCustomer);
    }

    /**
     * 删除customer对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsCustomerByIds(String ids)
    {
        return dsCustomerMapper.deleteDsCustomerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除customer信息
     * 
     * @param customerid customerID
     * @return 结果
     */
    @Override
    public int deleteDsCustomerById(Long customerid)
    {
        return dsCustomerMapper.deleteDsCustomerById(customerid);
    }

    @Override
    public List selectCustomerId(){
        return dsCustomerMapper.selectCustomerId();
    }
}
