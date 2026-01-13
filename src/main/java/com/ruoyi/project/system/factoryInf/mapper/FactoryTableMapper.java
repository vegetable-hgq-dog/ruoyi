package com.ruoyi.project.system.factoryInf.mapper;

import java.util.List;


import com.ruoyi.project.system.factoryInf.domain.FactoryTable;

/**
 * 工厂信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface FactoryTableMapper 
{
    /**
     * 查询工厂信息
     * 
     * @param id 工厂信息ID
     * @return 工厂信息
     */
    public FactoryTable selectFactoryTableById(Long id);

    /**
     * 查询工厂信息列表
     * 
     * @param factoryTable 工厂信息
     * @return 工厂信息集合
     */
    public List<FactoryTable> selectFactoryTableList(FactoryTable factoryTable);

    /**
     * 新增工厂信息
     * 
     * @param factoryTable 工厂信息
     * @return 结果
     */
    public int insertFactoryTable(FactoryTable factoryTable);

    /**
     * 修改工厂信息
     * 
     * @param factoryTable 工厂信息
     * @return 结果
     */
    public int updateFactoryTable(FactoryTable factoryTable);

    /**
     * 删除工厂信息
     * 
     * @param id 工厂信息ID
     * @return 结果
     */
    public int deleteFactoryTableById(Long id);

    /**
     * 批量删除工厂信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFactoryTableByIds(String[] ids);

    public FactoryTable selectByFactoryid(String factoryid);

    public int updateFactoryid(FactoryTable factoryTable);

    public List<FactoryTable> selectFactoryInfo();
}
