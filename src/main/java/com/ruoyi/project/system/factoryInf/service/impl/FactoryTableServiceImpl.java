package com.ruoyi.project.system.factoryInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.factoryInf.mapper.FactoryTableMapper;
import com.ruoyi.project.system.factoryInf.domain.FactoryTable;
import com.ruoyi.project.system.factoryInf.service.IFactoryTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工厂信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class FactoryTableServiceImpl implements IFactoryTableService 
{
    @Autowired
    private FactoryTableMapper factoryTableMapper;

    /**
     * 查询工厂信息
     * 
     * @param id 工厂信息ID
     * @return 工厂信息
     */
    @Override
    public FactoryTable selectFactoryTableById(Long id)
    {
        return factoryTableMapper.selectFactoryTableById(id);
    }

    /**
     * 查询工厂信息列表
     * 
     * @param factoryTable 工厂信息
     * @return 工厂信息
     */
    @Override
    public List<FactoryTable> selectFactoryTableList(FactoryTable factoryTable)
    {
        return factoryTableMapper.selectFactoryTableList(factoryTable);
    }

    /**
     * 新增工厂信息
     * 
     * @param factoryTable 工厂信息
     * @return 结果
     */
    @Override
    public int insertFactoryTable(FactoryTable factoryTable)
    {
        return factoryTableMapper.insertFactoryTable(factoryTable);
    }

    /**
     * 修改工厂信息
     * 
     * @param factoryTable 工厂信息
     * @return 结果
     */
    @Override
    public int updateFactoryTable(FactoryTable factoryTable)
    {
        return factoryTableMapper.updateFactoryTable(factoryTable);
    }

    /**
     * 删除工厂信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFactoryTableByIds(String ids)
    {
        return factoryTableMapper.deleteFactoryTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工厂信息信息
     * 
     * @param id 工厂信息ID
     * @return 结果
     */
    @Override
    public int deleteFactoryTableById(Long id)
    {
        return factoryTableMapper.deleteFactoryTableById(id);
    }

    @Override
    public String importFactory(List<FactoryTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (FactoryTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                FactoryTable u = factoryTableMapper.selectByFactoryid(im.getFactoryid());
                System.out.println(im.getFactoryid());
                if (StringUtils.isNull(u))
                {

                    this.insertFactoryTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工厂 " + im.getFactoryid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.factoryTableMapper.updateFactoryid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、工厂 " + im.getFactoryid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、工厂 " + im.getFactoryid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、工厂 " + im.getFactoryid() + " 导入失败：";
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
    public List<FactoryTable> selectFactoryInfo(){
        return factoryTableMapper.selectFactoryInfo();
    }
}
