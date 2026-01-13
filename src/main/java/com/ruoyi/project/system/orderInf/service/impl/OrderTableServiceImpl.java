package com.ruoyi.project.system.orderInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.orderInf.mapper.OrderTableMapper;
import com.ruoyi.project.system.orderInf.domain.OrderTable;
import com.ruoyi.project.system.orderInf.service.IOrderTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 订单信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class OrderTableServiceImpl implements IOrderTableService 
{
    @Autowired
    private OrderTableMapper orderTableMapper;

    /**
     * 查询订单信息
     * 
     * @param id 订单信息ID
     * @return 订单信息
     */
    @Override
    public OrderTable selectOrderTableById(Long id)
    {
        return orderTableMapper.selectOrderTableById(id);
    }

    /**
     * 查询订单信息列表
     * 
     * @param orderTable 订单信息
     * @return 订单信息
     */
    @Override
    public List<OrderTable> selectOrderTableList(OrderTable orderTable)
    {
        return orderTableMapper.selectOrderTableList(orderTable);
    }

    /**
     * 新增订单信息
     * 
     * @param orderTable 订单信息
     * @return 结果
     */
    @Override
    public int insertOrderTable(OrderTable orderTable)
    {
        return orderTableMapper.insertOrderTable(orderTable);
    }

    /**
     * 修改订单信息
     * 
     * @param orderTable 订单信息
     * @return 结果
     */
    @Override
    public int updateOrderTable(OrderTable orderTable)
    {
        return orderTableMapper.updateOrderTable(orderTable);
    }

    /**
     * 删除订单信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderTableByIds(String ids)
    {
        return orderTableMapper.deleteOrderTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单信息信息
     * 
     * @param id 订单信息ID
     * @return 结果
     */
    @Override
    public int deleteOrderTableById(Long id)
    {
        return orderTableMapper.deleteOrderTableById(id);
    }

    @Override
    public String importOrder(List<OrderTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (OrderTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                OrderTable u = orderTableMapper.selectByOrderid(im.getOrderid());
                System.out.println(im.getOrderid());
                if (StringUtils.isNull(u))
                {

                    this.insertOrderTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、订单 " + im.getOrderid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.orderTableMapper.updateOrderid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、订单 " + im.getOrderid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、订单 " + im.getOrderid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、订单 " + im.getOrderid() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List<OrderTable> getData(){

        return orderTableMapper.getData();
    }

    @Override
    public List getMaterialAmount(){
        return orderTableMapper.getMaterialAmount();
    }

    @Override
    public List getSupplierAmount(){
        return orderTableMapper.getSupplierAmount();
    }
}
