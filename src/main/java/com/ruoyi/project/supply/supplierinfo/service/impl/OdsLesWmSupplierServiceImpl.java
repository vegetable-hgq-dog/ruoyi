package com.ruoyi.project.supply.supplierinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.supply.supplierinfo.mapper.OdsLesWmSupplierMapper;
import com.ruoyi.project.supply.supplierinfo.domain.OdsLesWmSupplier;
import com.ruoyi.project.supply.supplierinfo.service.IOdsLesWmSupplierService;
import com.ruoyi.common.utils.text.Convert;

/**
 * supplier_infoService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-03
 */
@Service
public class OdsLesWmSupplierServiceImpl implements IOdsLesWmSupplierService 
{
    @Autowired
    private OdsLesWmSupplierMapper odsLesWmSupplierMapper;

    /**
     * 查询supplier_info
     * 
     * @param autoid supplier_infoID
     * @return supplier_info
     */
    @Override
    public OdsLesWmSupplier selectOdsLesWmSupplierById(Long autoid)
    {
        return odsLesWmSupplierMapper.selectOdsLesWmSupplierById(autoid);
    }

    /**
     * 查询supplier_info列表
     * 
     * @param odsLesWmSupplier supplier_info
     * @return supplier_info
     */
    @Override
    public List<OdsLesWmSupplier> selectOdsLesWmSupplierList(OdsLesWmSupplier odsLesWmSupplier)
    {
        return odsLesWmSupplierMapper.selectOdsLesWmSupplierList(odsLesWmSupplier);
    }

    /**
     * 新增supplier_info
     * 
     * @param odsLesWmSupplier supplier_info
     * @return 结果
     */
    @Override
    public int insertOdsLesWmSupplier(OdsLesWmSupplier odsLesWmSupplier)
    {
        return odsLesWmSupplierMapper.insertOdsLesWmSupplier(odsLesWmSupplier);
    }

    /**
     * 修改supplier_info
     * 
     * @param odsLesWmSupplier supplier_info
     * @return 结果
     */
    @Override
    public int updateOdsLesWmSupplier(OdsLesWmSupplier odsLesWmSupplier)
    {
        return odsLesWmSupplierMapper.updateOdsLesWmSupplier(odsLesWmSupplier);
    }

    /**
     * 删除supplier_info对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOdsLesWmSupplierByIds(String ids)
    {
        return odsLesWmSupplierMapper.deleteOdsLesWmSupplierByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除supplier_info信息
     * 
     * @param autoid supplier_infoID
     * @return 结果
     */
    @Override
    public int deleteOdsLesWmSupplierById(Long autoid)
    {
        return odsLesWmSupplierMapper.deleteOdsLesWmSupplierById(autoid);
    }
}
