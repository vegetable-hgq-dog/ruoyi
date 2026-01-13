package com.ruoyi.project.system.carrierInf.service;

import java.util.List;
import com.ruoyi.project.system.carrierInf.domain.CarriersTable;

/**
 * 承运商信息Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface ICarriersTableService 
{
    /**
     * 查询承运商信息
     * 
     * @param id 承运商信息ID
     * @return 承运商信息
     */
    public CarriersTable selectCarriersTableById(Long id);

    /**
     * 查询承运商信息列表
     * 
     * @param carriersTable 承运商信息
     * @return 承运商信息集合
     */
    public List<CarriersTable> selectCarriersTableList(CarriersTable carriersTable);

    /**
     * 新增承运商信息
     * 
     * @param carriersTable 承运商信息
     * @return 结果
     */
    public int insertCarriersTable(CarriersTable carriersTable);

    /**
     * 修改承运商信息
     * 
     * @param carriersTable 承运商信息
     * @return 结果
     */
    public int updateCarriersTable(CarriersTable carriersTable);

    /**
     * 批量删除承运商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarriersTableByIds(String ids);

    /**
     * 删除承运商信息信息
     * 
     * @param id 承运商信息ID
     * @return 结果
     */
    public int deleteCarriersTableById(Long id);

    public String importCarriers(List<CarriersTable> carriersList, boolean updateSupport, String operName);
}
