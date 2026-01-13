package com.ruoyi.project.system.material.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.material.mapper.DsMaterialMapper;
import com.ruoyi.project.system.material.domain.DsMaterial;
import com.ruoyi.project.system.material.service.IDsMaterialService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 材料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsMaterialServiceImpl implements IDsMaterialService 
{
    @Autowired
    private DsMaterialMapper dsMaterialMapper;

    /**
     * 查询材料信息
     * 
     * @param materialid 材料信息ID
     * @return 材料信息
     */
    @Override
    public DsMaterial selectDsMaterialById(Long materialid)
    {
        return dsMaterialMapper.selectDsMaterialById(materialid);
    }

    /**
     * 查询材料信息列表
     * 
     * @param dsMaterial 材料信息
     * @return 材料信息
     */
    @Override
    public List<DsMaterial> selectDsMaterialList(DsMaterial dsMaterial)
    {
        return dsMaterialMapper.selectDsMaterialList(dsMaterial);
    }

    /**
     * 新增材料信息
     * 
     * @param dsMaterial 材料信息
     * @return 结果
     */
    @Override
    public int insertDsMaterial(DsMaterial dsMaterial)
    {
        return dsMaterialMapper.insertDsMaterial(dsMaterial);
    }

    /**
     * 修改材料信息
     * 
     * @param dsMaterial 材料信息
     * @return 结果
     */
    @Override
    public int updateDsMaterial(DsMaterial dsMaterial)
    {
        return dsMaterialMapper.updateDsMaterial(dsMaterial);
    }

    /**
     * 删除材料信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsMaterialByIds(String ids)
    {
        return dsMaterialMapper.deleteDsMaterialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料信息信息
     * 
     * @param materialid 材料信息ID
     * @return 结果
     */
    @Override
    public int deleteDsMaterialById(Long materialid)
    {
        return dsMaterialMapper.deleteDsMaterialById(materialid);
    }
}
