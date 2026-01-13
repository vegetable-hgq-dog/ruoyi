package com.ruoyi.project.system.carrierInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.carrierInf.mapper.CarriersTableMapper;
import com.ruoyi.project.system.carrierInf.domain.CarriersTable;
import com.ruoyi.project.system.carrierInf.service.ICarriersTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 承运商信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class CarriersTableServiceImpl implements ICarriersTableService 
{
    @Autowired
    private CarriersTableMapper carriersTableMapper;

    /**
     * 查询承运商信息
     * 
     * @param id 承运商信息ID
     * @return 承运商信息
     */
    @Override
    public CarriersTable selectCarriersTableById(Long id)
    {
        return carriersTableMapper.selectCarriersTableById(id);
    }

    /**
     * 查询承运商信息列表
     * 
     * @param carriersTable 承运商信息
     * @return 承运商信息
     */
    @Override
    public List<CarriersTable> selectCarriersTableList(CarriersTable carriersTable)
    {
        return carriersTableMapper.selectCarriersTableList(carriersTable);
    }

    /**
     * 新增承运商信息
     * 
     * @param carriersTable 承运商信息
     * @return 结果
     */
    @Override
    public int insertCarriersTable(CarriersTable carriersTable)
    {
        return carriersTableMapper.insertCarriersTable(carriersTable);
    }

    /**
     * 修改承运商信息
     * 
     * @param carriersTable 承运商信息
     * @return 结果
     */
    @Override
    public int updateCarriersTable(CarriersTable carriersTable)
    {
        return carriersTableMapper.updateCarriersTable(carriersTable);
    }

    /**
     * 删除承运商信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCarriersTableByIds(String ids)
    {
        return carriersTableMapper.deleteCarriersTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除承运商信息信息
     * 
     * @param id 承运商信息ID
     * @return 结果
     */
    @Override
    public int deleteCarriersTableById(Long id)
    {
        return carriersTableMapper.deleteCarriersTableById(id);
    }

    @Override
    public String importCarriers(List<CarriersTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CarriersTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                CarriersTable u = carriersTableMapper.selectByCarriername(im.getCarriername());
                System.out.println(im.getCarriername());
                if (StringUtils.isNull(u))
                {

                    this.insertCarriersTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、承运商 " + im.getCarriername() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.carriersTableMapper.updateCarriers(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、承运商 " + im.getCarriername() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、承运商 " + im.getCarriername() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、承运商 " + im.getCarriername() + " 导入失败：";
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
}
