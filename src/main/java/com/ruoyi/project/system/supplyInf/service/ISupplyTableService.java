package com.ruoyi.project.system.supplyInf.service;

import java.util.List;
import com.ruoyi.project.system.supplyInf.domain.SupplyTable;

/**
 * 供应信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
public interface ISupplyTableService 
{
    /**
     * 查询供应信息
     * 
     * @param id 供应信息ID
     * @return 供应信息
     */
    public SupplyTable selectSupplyTableById(Long id);

    /**
     * 查询供应信息列表
     * 
     * @param supplyTable 供应信息
     * @return 供应信息集合
     */
    public List<SupplyTable> selectSupplyTableList(SupplyTable supplyTable);

    /**
     * 新增供应信息
     * 
     * @param supplyTable 供应信息
     * @return 结果
     */
    public int insertSupplyTable(SupplyTable supplyTable);

    /**
     * 修改供应信息
     * 
     * @param supplyTable 供应信息
     * @return 结果
     */
    public int updateSupplyTable(SupplyTable supplyTable);

    /**
     * 批量删除供应信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSupplyTableByIds(String ids);

    /**
     * 删除供应信息信息
     * 
     * @param id 供应信息ID
     * @return 结果
     */
    public int deleteSupplyTableById(Long id);

    public List getAllSupplyData();
}
