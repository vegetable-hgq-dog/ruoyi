package com.ruoyi.project.system.distributeStaffInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.distributeStaffInf.mapper.DistributestaffsTableMapper;
import com.ruoyi.project.system.distributeStaffInf.domain.DistributestaffsTable;
import com.ruoyi.project.system.distributeStaffInf.service.IDistributestaffsTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 配送人员Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class DistributestaffsTableServiceImpl implements IDistributestaffsTableService 
{
    @Autowired
    private DistributestaffsTableMapper distributestaffsTableMapper;

    /**
     * 查询配送人员
     * 
     * @param id 配送人员ID
     * @return 配送人员
     */
    @Override
    public DistributestaffsTable selectDistributestaffsTableById(Long id)
    {
        return distributestaffsTableMapper.selectDistributestaffsTableById(id);
    }

    /**
     * 查询配送人员列表
     * 
     * @param distributestaffsTable 配送人员
     * @return 配送人员
     */
    @Override
    public List<DistributestaffsTable> selectDistributestaffsTableList(DistributestaffsTable distributestaffsTable)
    {
        return distributestaffsTableMapper.selectDistributestaffsTableList(distributestaffsTable);
    }

    /**
     * 新增配送人员
     * 
     * @param distributestaffsTable 配送人员
     * @return 结果
     */
    @Override
    public int insertDistributestaffsTable(DistributestaffsTable distributestaffsTable)
    {
        return distributestaffsTableMapper.insertDistributestaffsTable(distributestaffsTable);
    }

    /**
     * 修改配送人员
     * 
     * @param distributestaffsTable 配送人员
     * @return 结果
     */
    @Override
    public int updateDistributestaffsTable(DistributestaffsTable distributestaffsTable)
    {
        return distributestaffsTableMapper.updateDistributestaffsTable(distributestaffsTable);
    }

    /**
     * 删除配送人员对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDistributestaffsTableByIds(String ids)
    {
        return distributestaffsTableMapper.deleteDistributestaffsTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除配送人员信息
     * 
     * @param id 配送人员ID
     * @return 结果
     */
    @Override
    public int deleteDistributestaffsTableById(Long id)
    {
        return distributestaffsTableMapper.deleteDistributestaffsTableById(id);
    }

    @Override
    public String importDistributestaffs(List<DistributestaffsTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DistributestaffsTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                DistributestaffsTable u = distributestaffsTableMapper.selectByDrivername(im.getDrivername());
                System.out.println(im.getDrivername());
                if (StringUtils.isNull(u))
                {

                    this.insertDistributestaffsTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、司机 " + im.getDrivername() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.distributestaffsTableMapper.updateDrivername(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、司机 " + im.getDrivername() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、司机 " + im.getDrivername() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、司机 " + im.getDrivername() + " 导入失败：";
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
