package com.ruoyi.project.system.factoryInventoryInf.mapper;

import java.util.List;
import com.ruoyi.project.system.factoryInventoryInf.domain.FactoryInventoryTable;

/**
 * 工厂库存Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public interface FactoryInventoryTableMapper 
{
    /**
     * 查询工厂库存
     * 
     * @param id 工厂库存ID
     * @return 工厂库存
     */
    public FactoryInventoryTable selectFactoryInventoryTableById(Long id);

    /**
     * 查询工厂库存列表
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 工厂库存集合
     */
    public List<FactoryInventoryTable> selectFactoryInventoryTableList(FactoryInventoryTable factoryInventoryTable);

    /**
     * 新增工厂库存
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 结果
     */
    public int insertFactoryInventoryTable(FactoryInventoryTable factoryInventoryTable);

    /**
     * 修改工厂库存
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 结果
     */
    public int updateFactoryInventoryTable(FactoryInventoryTable factoryInventoryTable);

    /**
     * 删除工厂库存
     * 
     * @param id 工厂库存ID
     * @return 结果
     */
    public int deleteFactoryInventoryTableById(Long id);

    /**
     * 批量删除工厂库存
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFactoryInventoryTableByIds(String[] ids);

    public FactoryInventoryTable selectByInventoryid(String inventoryid);

    public int updateInventoryid(FactoryInventoryTable factoryInventoryTable);

    public List getAllFactoryInventoryData();
}
