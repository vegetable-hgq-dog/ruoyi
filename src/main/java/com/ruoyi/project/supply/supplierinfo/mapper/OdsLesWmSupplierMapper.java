package com.ruoyi.project.supply.supplierinfo.mapper;

import java.util.List;
import com.ruoyi.project.supply.supplierinfo.domain.OdsLesWmSupplier;

/**
 * supplier_infoMapper接口
 * 
 * @author xjtu
 * @date 2023-08-03
 */
public interface OdsLesWmSupplierMapper 
{
    /**
     * 查询supplier_info
     * 
     * @param autoid supplier_infoID
     * @return supplier_info
     */
    public OdsLesWmSupplier selectOdsLesWmSupplierById(Long autoid);

    /**
     * 查询supplier_info列表
     * 
     * @param odsLesWmSupplier supplier_info
     * @return supplier_info集合
     */
    public List<OdsLesWmSupplier> selectOdsLesWmSupplierList(OdsLesWmSupplier odsLesWmSupplier);

    /**
     * 新增supplier_info
     * 
     * @param odsLesWmSupplier supplier_info
     * @return 结果
     */
    public int insertOdsLesWmSupplier(OdsLesWmSupplier odsLesWmSupplier);

    /**
     * 修改supplier_info
     * 
     * @param odsLesWmSupplier supplier_info
     * @return 结果
     */
    public int updateOdsLesWmSupplier(OdsLesWmSupplier odsLesWmSupplier);

    /**
     * 删除supplier_info
     * 
     * @param autoid supplier_infoID
     * @return 结果
     */
    public int deleteOdsLesWmSupplierById(Long autoid);

    /**
     * 批量删除supplier_info
     * 
     * @param autoids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOdsLesWmSupplierByIds(String[] autoids);
}
