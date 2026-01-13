package com.ruoyi.project.system.pickupPlanInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.pickupPlanInf.mapper.PickupplanTableMapper;
import com.ruoyi.project.system.pickupPlanInf.domain.PickupplanTable;
import com.ruoyi.project.system.pickupPlanInf.service.IPickupplanTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 取货计划Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class PickupplanTableServiceImpl implements IPickupplanTableService 
{
    @Autowired
    private PickupplanTableMapper pickupplanTableMapper;

    /**
     * 查询取货计划
     * 
     * @param id 取货计划ID
     * @return 取货计划
     */
    @Override
    public PickupplanTable selectPickupplanTableById(Long id)
    {
        return pickupplanTableMapper.selectPickupplanTableById(id);
    }

    /**
     * 查询取货计划列表
     * 
     * @param pickupplanTable 取货计划
     * @return 取货计划
     */
    @Override
    public List<PickupplanTable> selectPickupplanTableList(PickupplanTable pickupplanTable)
    {
        return pickupplanTableMapper.selectPickupplanTableList(pickupplanTable);
    }

    /**
     * 新增取货计划
     * 
     * @param pickupplanTable 取货计划
     * @return 结果
     */
    @Override
    public int insertPickupplanTable(PickupplanTable pickupplanTable)
    {
        return pickupplanTableMapper.insertPickupplanTable(pickupplanTable);
    }

    /**
     * 修改取货计划
     * 
     * @param pickupplanTable 取货计划
     * @return 结果
     */
    @Override
    public int updatePickupplanTable(PickupplanTable pickupplanTable)
    {
        return pickupplanTableMapper.updatePickupplanTable(pickupplanTable);
    }

    /**
     * 删除取货计划对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePickupplanTableByIds(String ids)
    {
        return pickupplanTableMapper.deletePickupplanTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除取货计划信息
     * 
     * @param id 取货计划ID
     * @return 结果
     */
    @Override
    public int deletePickupplanTableById(Long id)
    {
        return pickupplanTableMapper.deletePickupplanTableById(id);
    }

    @Override
    public String importPickupplan(List<PickupplanTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (PickupplanTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                PickupplanTable u = pickupplanTableMapper.selectByPickupplanid(im.getPickupplanid());
                System.out.println(im.getPickupplanid());
                if (StringUtils.isNull(u))
                {

                    this.insertPickupplanTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、取货计划 " + im.getPickupplanid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.pickupplanTableMapper.updatePickupplanid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、取货计划 " + im.getPickupplanid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、取货计划 " + im.getPickupplanid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、取货计划 " + im.getPickupplanid() + " 导入失败：";
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
    public List getAllPickupplanData(){
        return pickupplanTableMapper.getAllPickupplanData();
    }
}
