package com.ruoyi.project.system.orderInf.service;

import java.util.List;
import com.ruoyi.project.system.orderInf.domain.OrderTable;

/**
 * 订单信息Service接口
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
public interface IOrderTableService 
{
    /**
     * 查询订单信息
     * 
     * @param id 订单信息ID
     * @return 订单信息
     */
    public OrderTable selectOrderTableById(Long id);

    /**
     * 查询订单信息列表
     * 
     * @param orderTable 订单信息
     * @return 订单信息集合
     */
    public List<OrderTable> selectOrderTableList(OrderTable orderTable);

    /**
     * 新增订单信息
     * 
     * @param orderTable 订单信息
     * @return 结果
     */
    public int insertOrderTable(OrderTable orderTable);

    /**
     * 修改订单信息
     * 
     * @param orderTable 订单信息
     * @return 结果
     */
    public int updateOrderTable(OrderTable orderTable);

    /**
     * 批量删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderTableByIds(String ids);

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息ID
     * @return 结果
     */
    public int deleteOrderTableById(Long id);

    public String importOrder(List<OrderTable> orderList, boolean updateSupport, String operName);

    public List<OrderTable> getData();

    public List getMaterialAmount();

    public List getSupplierAmount();
}
