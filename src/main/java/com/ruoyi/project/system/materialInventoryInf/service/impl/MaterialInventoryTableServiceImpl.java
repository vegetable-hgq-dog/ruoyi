package com.ruoyi.project.system.materialInventoryInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.materialInventoryInf.mapper.MaterialInventoryTableMapper;
import com.ruoyi.project.system.materialInventoryInf.domain.MaterialInventoryTable;
import com.ruoyi.project.system.materialInventoryInf.service.IMaterialInventoryTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 供应商库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class MaterialInventoryTableServiceImpl implements IMaterialInventoryTableService 
{
    @Autowired
    private MaterialInventoryTableMapper materialInventoryTableMapper;

    /**
     * 查询供应商库存
     * 
     * @param id 供应商库存ID
     * @return 供应商库存
     */
    @Override
    public MaterialInventoryTable selectMaterialInventoryTableById(Long id)
    {
        return materialInventoryTableMapper.selectMaterialInventoryTableById(id);
    }

    /**
     * 查询供应商库存列表
     * 
     * @param materialInventoryTable 供应商库存
     * @return 供应商库存
     */
    @Override
    public List<MaterialInventoryTable> selectMaterialInventoryTableList(MaterialInventoryTable materialInventoryTable)
    {
        return materialInventoryTableMapper.selectMaterialInventoryTableList(materialInventoryTable);
    }

    /**
     * 新增供应商库存
     * 
     * @param materialInventoryTable 供应商库存
     * @return 结果
     */
    @Override
    public int insertMaterialInventoryTable(MaterialInventoryTable materialInventoryTable)
    {
        return materialInventoryTableMapper.insertMaterialInventoryTable(materialInventoryTable);
    }

    /**
     * 修改供应商库存
     * 
     * @param materialInventoryTable 供应商库存
     * @return 结果
     */
    @Override
    public int updateMaterialInventoryTable(MaterialInventoryTable materialInventoryTable)
    {
        return materialInventoryTableMapper.updateMaterialInventoryTable(materialInventoryTable);
    }

    /**
     * 删除供应商库存对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInventoryTableByIds(String ids)
    {
        return materialInventoryTableMapper.deleteMaterialInventoryTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商库存信息
     * 
     * @param id 供应商库存ID
     * @return 结果
     */
    @Override
    public int deleteMaterialInventoryTableById(Long id)
    {
        return materialInventoryTableMapper.deleteMaterialInventoryTableById(id);
    }

    @Override
    public String importMaterialsInventory(List<MaterialInventoryTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MaterialInventoryTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                MaterialInventoryTable u = materialInventoryTableMapper.selectByInventoryid(im.getInventoryid());
                System.out.println(im.getInventoryid());
                if (StringUtils.isNull(u))
                {

                    this.insertMaterialInventoryTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、供应商库存 " + im.getInventoryid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.materialInventoryTableMapper.updateInventoryid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、供应商库存 " + im.getInventoryid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、供应商库存 " + im.getInventoryid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、供应商库存 " + im.getInventoryid() + " 导入失败：";
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
