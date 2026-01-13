package com.ruoyi.project.system.pickupPlanInf.service;

import java.util.List;
import com.ruoyi.project.system.pickupPlanInf.domain.PickupplanTable;

/**
 * 取货计划Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface IPickupplanTableService 
{
    /**
     * 查询取货计划
     * 
     * @param id 取货计划ID
     * @return 取货计划
     */
    public PickupplanTable selectPickupplanTableById(Long id);

    /**
     * 查询取货计划列表
     * 
     * @param pickupplanTable 取货计划
     * @return 取货计划集合
     */
    public List<PickupplanTable> selectPickupplanTableList(PickupplanTable pickupplanTable);

    /**
     * 新增取货计划
     * 
     * @param pickupplanTable 取货计划
     * @return 结果
     */
    public int insertPickupplanTable(PickupplanTable pickupplanTable);

    /**
     * 修改取货计划
     * 
     * @param pickupplanTable 取货计划
     * @return 结果
     */
    public int updatePickupplanTable(PickupplanTable pickupplanTable);

    /**
     * 批量删除取货计划
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePickupplanTableByIds(String ids);

    /**
     * 删除取货计划信息
     * 
     * @param id 取货计划ID
     * @return 结果
     */
    public int deletePickupplanTableById(Long id);

    public String importPickupplan(List<PickupplanTable> pickupplanList, boolean updateSupport, String operName);

    public List getAllPickupplanData();
}
