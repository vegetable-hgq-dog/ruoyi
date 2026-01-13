package com.ruoyi.project.supply.materialsupply.service;

import java.util.List;
import com.ruoyi.project.supply.materialsupply.domain.OdsIwmWmTotal;

/**
 * material_supplyService接口
 * 
 * @author xjtu
 * @date 2023-08-03
 */
public interface IOdsIwmWmTotalService 
{
    /**
     * 查询material_supply
     * 
     * @param autoid material_supplyID
     * @return material_supply
     */
    public OdsIwmWmTotal selectOdsIwmWmTotalById(Long autoid);

    /**
     * 查询material_supply列表
     * 
     * @param odsIwmWmTotal material_supply
     * @return material_supply集合
     */
    public List<OdsIwmWmTotal> selectOdsIwmWmTotalList(OdsIwmWmTotal odsIwmWmTotal);

    /**
     * 新增material_supply
     * 
     * @param odsIwmWmTotal material_supply
     * @return 结果
     */
    public int insertOdsIwmWmTotal(OdsIwmWmTotal odsIwmWmTotal);

    /**
     * 修改material_supply
     * 
     * @param odsIwmWmTotal material_supply
     * @return 结果
     */
    public int updateOdsIwmWmTotal(OdsIwmWmTotal odsIwmWmTotal);

    /**
     * 批量删除material_supply
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOdsIwmWmTotalByIds(String ids);

    /**
     * 删除material_supply信息
     * 
     * @param autoid material_supplyID
     * @return 结果
     */
    public int deleteOdsIwmWmTotalById(Long autoid);
}
