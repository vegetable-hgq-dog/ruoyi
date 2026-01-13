package com.ruoyi.project.system.materialInventoryInf.mapper;

import java.util.List;


import com.ruoyi.project.system.materialInventoryInf.domain.MaterialInventoryTable;

/**
 * 供应商库存Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface MaterialInventoryTableMapper 
{
    /**
     * 查询供应商库存
     * 
     * @param id 供应商库存ID
     * @return 供应商库存
     */
    public MaterialInventoryTable selectMaterialInventoryTableById(Long id);

    /**
     * 查询供应商库存列表
     * 
     * @param materialInventoryTable 供应商库存
     * @return 供应商库存集合
     */
    public List<MaterialInventoryTable> selectMaterialInventoryTableList(MaterialInventoryTable materialInventoryTable);

    /**
     * 新增供应商库存
     * 
     * @param materialInventoryTable 供应商库存
     * @return 结果
     */
    public int insertMaterialInventoryTable(MaterialInventoryTable materialInventoryTable);

    /**
     * 修改供应商库存
     * 
     * @param materialInventoryTable 供应商库存
     * @return 结果
     */
    public int updateMaterialInventoryTable(MaterialInventoryTable materialInventoryTable);

    /**
     * 删除供应商库存
     * 
     * @param id 供应商库存ID
     * @return 结果
     */
    public int deleteMaterialInventoryTableById(Long id);

    /**
     * 批量删除供应商库存
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialInventoryTableByIds(String[] ids);

    public MaterialInventoryTable selectByInventoryid(String inventoryid);

    public int updateInventoryid(MaterialInventoryTable materialInventoryTable);
}
