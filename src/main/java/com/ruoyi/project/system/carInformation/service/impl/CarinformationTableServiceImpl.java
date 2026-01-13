package com.ruoyi.project.system.carInformation.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.carInformation.mapper.CarinformationTableMapper;
import com.ruoyi.project.system.carInformation.domain.CarinformationTable;
import com.ruoyi.project.system.carInformation.service.ICarinformationTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 车辆信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class CarinformationTableServiceImpl implements ICarinformationTableService 
{
    @Autowired
    private CarinformationTableMapper carinformationTableMapper;

    /**
     * 查询车辆信息
     * 
     * @param id 车辆信息ID
     * @return 车辆信息
     */
    @Override
    public CarinformationTable selectCarinformationTableById(Long id)
    {
        return carinformationTableMapper.selectCarinformationTableById(id);
    }

    /**
     * 查询车辆信息列表
     * 
     * @param carinformationTable 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<CarinformationTable> selectCarinformationTableList(CarinformationTable carinformationTable)
    {
        return carinformationTableMapper.selectCarinformationTableList(carinformationTable);
    }

    /**
     * 新增车辆信息
     * 
     * @param carinformationTable 车辆信息
     * @return 结果
     */
    @Override
    public int insertCarinformationTable(CarinformationTable carinformationTable)
    {
        return carinformationTableMapper.insertCarinformationTable(carinformationTable);
    }

    /**
     * 修改车辆信息
     * 
     * @param carinformationTable 车辆信息
     * @return 结果
     */
    @Override
    public int updateCarinformationTable(CarinformationTable carinformationTable)
    {
        return carinformationTableMapper.updateCarinformationTable(carinformationTable);
    }

    /**
     * 删除车辆信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCarinformationTableByIds(String ids)
    {
        return carinformationTableMapper.deleteCarinformationTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除车辆信息信息
     * 
     * @param id 车辆信息ID
     * @return 结果
     */
    @Override
    public int deleteCarinformationTableById(Long id)
    {
        return carinformationTableMapper.deleteCarinformationTableById(id);
    }

    @Override
    public String importCarImformation(List<CarinformationTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (CarinformationTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                CarinformationTable u = carinformationTableMapper.selectByLicenseplate(im.getLicenseplate());
                System.out.println(im.getLicenseplate());
                if (StringUtils.isNull(u))
                {

                    this.insertCarinformationTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、车辆 " + im.getLicenseplate() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.carinformationTableMapper.updateCarinformation(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、车辆 " + im.getLicenseplate() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、车辆 " + im.getLicenseplate() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、车辆 " + im.getLicenseplate() + " 导入失败：";
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
