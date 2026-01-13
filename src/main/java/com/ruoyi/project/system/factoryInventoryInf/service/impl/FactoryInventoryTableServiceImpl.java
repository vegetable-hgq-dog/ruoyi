package com.ruoyi.project.system.factoryInventoryInf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.factoryInventoryInf.mapper.FactoryInventoryTableMapper;
import com.ruoyi.project.system.factoryInventoryInf.domain.FactoryInventoryTable;
import com.ruoyi.project.system.factoryInventoryInf.service.IFactoryInventoryTableService;
import com.ruoyi.common.utils.text.Convert;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;

/**
 * 工厂库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-11
 */
@Service
public class FactoryInventoryTableServiceImpl implements IFactoryInventoryTableService 
{
    @Autowired
    private FactoryInventoryTableMapper factoryInventoryTableMapper;

    /**
     * 查询工厂库存
     * 
     * @param id 工厂库存ID
     * @return 工厂库存
     */
    @Override
    public FactoryInventoryTable selectFactoryInventoryTableById(Long id)
    {
        return factoryInventoryTableMapper.selectFactoryInventoryTableById(id);
    }

    /**
     * 查询工厂库存列表
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 工厂库存
     */
    @Override
    public List<FactoryInventoryTable> selectFactoryInventoryTableList(FactoryInventoryTable factoryInventoryTable)
    {
        return factoryInventoryTableMapper.selectFactoryInventoryTableList(factoryInventoryTable);
    }

    /**
     * 新增工厂库存
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 结果
     */
    @Override
    public int insertFactoryInventoryTable(FactoryInventoryTable factoryInventoryTable)
    {
        return factoryInventoryTableMapper.insertFactoryInventoryTable(factoryInventoryTable);
    }

    /**
     * 修改工厂库存
     * 
     * @param factoryInventoryTable 工厂库存
     * @return 结果
     */
    @Override
    public int updateFactoryInventoryTable(FactoryInventoryTable factoryInventoryTable)
    {
        return factoryInventoryTableMapper.updateFactoryInventoryTable(factoryInventoryTable);
    }

    /**
     * 删除工厂库存对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFactoryInventoryTableByIds(String ids)
    {
        return factoryInventoryTableMapper.deleteFactoryInventoryTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工厂库存信息
     * 
     * @param id 工厂库存ID
     * @return 结果
     */
    @Override
    public int deleteFactoryInventoryTableById(Long id)
    {
        return factoryInventoryTableMapper.deleteFactoryInventoryTableById(id);
    }


    @Override
    public String importFactoryInventory(List<FactoryInventoryTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FactoryInventoryTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                FactoryInventoryTable u = factoryInventoryTableMapper.selectByInventoryid(im.getInventoryid());
                System.out.println(im.getInventoryid());
                if (StringUtils.isNull(u))
                {

                    this.insertFactoryInventoryTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工厂库存 " + im.getInventoryid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.factoryInventoryTableMapper.updateInventoryid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工厂库存 " + im.getInventoryid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、工厂库存 " + im.getInventoryid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、工厂库存 " + im.getInventoryid() + " 导入失败：";
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
    public List getAllFactoryInventoryData(){
        return factoryInventoryTableMapper.getAllFactoryInventoryData();
    }
}
