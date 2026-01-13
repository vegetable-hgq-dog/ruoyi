package com.ruoyi.project.system.materialInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.materialInf.mapper.MaterialsTableMapper;
import com.ruoyi.project.system.materialInf.domain.MaterialsTable;
import com.ruoyi.project.system.materialInf.service.IMaterialsTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 物料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class MaterialsTableServiceImpl implements IMaterialsTableService 
{
    @Autowired
    private MaterialsTableMapper materialsTableMapper;

    /**
     * 查询物料信息
     * 
     * @param id 物料信息ID
     * @return 物料信息
     */
    @Override
    public MaterialsTable selectMaterialsTableById(Long id)
    {
        return materialsTableMapper.selectMaterialsTableById(id);
    }

    /**
     * 查询物料信息列表
     * 
     * @param materialsTable 物料信息
     * @return 物料信息
     */
    @Override
    public List<MaterialsTable> selectMaterialsTableList(MaterialsTable materialsTable)
    {
        return materialsTableMapper.selectMaterialsTableList(materialsTable);
    }

    /**
     * 新增物料信息
     * 
     * @param materialsTable 物料信息
     * @return 结果
     */
    @Override
    public int insertMaterialsTable(MaterialsTable materialsTable)
    {
        return materialsTableMapper.insertMaterialsTable(materialsTable);
    }

    /**
     * 修改物料信息
     * 
     * @param materialsTable 物料信息
     * @return 结果
     */
    @Override
    public int updateMaterialsTable(MaterialsTable materialsTable)
    {
        return materialsTableMapper.updateMaterialsTable(materialsTable);
    }

    /**
     * 删除物料信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialsTableByIds(String ids)
    {
        return materialsTableMapper.deleteMaterialsTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除物料信息信息
     * 
     * @param id 物料信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialsTableById(Long id)
    {
        return materialsTableMapper.deleteMaterialsTableById(id);
    }

    @Override
    public String importMaterials(List<MaterialsTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (MaterialsTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                MaterialsTable u = materialsTableMapper.selectBymaterialid(im.getMaterialid());
                System.out.println(im.getMaterialid());
                if (StringUtils.isNull(u))
                {

                    this.insertMaterialsTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料 " + im.getMaterialid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.materialsTableMapper.updateMaterialid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、物料 " + im.getMaterialid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、物料 " + im.getMaterialid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、物料 " + im.getMaterialid() + " 导入失败：";
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
    public List getAllMaterialData(){
        return materialsTableMapper.getAllMaterialData();
    }
}
