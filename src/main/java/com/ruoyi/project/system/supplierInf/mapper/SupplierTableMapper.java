package com.ruoyi.project.system.supplierInf.mapper;

import java.util.List;


import com.ruoyi.project.system.supplierInf.domain.SupplierTable;

/**
 * 供应商信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface SupplierTableMapper 
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
     * 删除供应商信息
     * 
     * @param id 供应商信息ID
     * @return 结果
     */
    public int deleteSupplierTableById(Long id);

    /**
     * 批量删除供应商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSupplierTableByIds(String[] ids);

    public SupplierTable selectBySupplierid(String inventoryid);

    public int updateSupplierid(SupplierTable supplierTable);

    public List getAllSupplierData();
}
