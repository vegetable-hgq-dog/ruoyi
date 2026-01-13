package com.ruoyi.project.system.supplierInf.service;

import java.util.List;
import com.ruoyi.project.system.supplierInf.domain.SupplierTable;

/**
 * 供应商信息Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface ISupplierTableService 
{
    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息ID
     * @return 供应商信息
     */
    public SupplierTable selectSupplierTableById(Long id);

    /**
     * 查询供应商信息列表
     * 
     * @param supplierTable 供应商信息
     * @return 供应商信息集合
     */
    public List<SupplierTable> selectSupplierTableList(SupplierTable supplierTable);

    /**
     * 新增供应商信息
     * 
     * @param supplierTable 供应商信息
     * @return 结果
     */
    public int insertSupplierTable(SupplierTable supplierTable);

    /**
     * 修改供应商信息
     * 
     * @param supplierTable 供应商信息
     * @return 结果
     */
    public int updateSupplierTable(SupplierTable supplierTable);

    /**
     * 批量删除供应商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSupplierTableByIds(String ids);

    /**
     * 删除供应商信息信息
     * 
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSupplierTableById(Long id);

    public String importSupplier(List<SupplierTable> supplierList, boolean updateSupport, String operName);

    public List getAllSupplierData();
}
