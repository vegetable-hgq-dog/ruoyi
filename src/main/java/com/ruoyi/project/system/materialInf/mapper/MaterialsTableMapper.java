package com.ruoyi.project.system.materialInf.mapper;

import java.util.List;


import com.ruoyi.project.system.materialInf.domain.MaterialsTable;

/**
 * 物料信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface MaterialsTableMapper 
{
    /**
     * 查询物料信息
     * 
     * @param id 物料信息ID
     * @return 物料信息
     */
    public MaterialsTable selectMaterialsTableById(Long id);

    /**
     * 查询物料信息列表
     * 
     * @param materialsTable 物料信息
     * @return 物料信息集合
     */
    public List<MaterialsTable> selectMaterialsTableList(MaterialsTable materialsTable);

    /**
     * 新增物料信息
     * 
     * @param materialsTable 物料信息
     * @return 结果
     */
    public int insertMaterialsTable(MaterialsTable materialsTable);

    /**
     * 修改物料信息
     * 
     * @param materialsTable 物料信息
     * @return 结果
     */
    public int updateMaterialsTable(MaterialsTable materialsTable);

    /**
     * 删除物料信息
     * 
     * @param id 物料信息ID
     * @return 结果
     */
    public int deleteMaterialsTableById(Long id);

    /**
     * 批量删除物料信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialsTableByIds(String[] ids);

    public MaterialsTable selectBymaterialid(String inventoryid);

    public int updateMaterialid(MaterialsTable materialsTable);

    public List getAllMaterialData();
}
