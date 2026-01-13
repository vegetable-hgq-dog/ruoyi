package com.ruoyi.project.system.materialinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.materialinfo.mapper.MaterialinfoMapper;
import com.ruoyi.project.system.materialinfo.domain.Materialinfo;
import com.ruoyi.project.system.materialinfo.service.IMaterialinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 材料信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class MaterialinfoServiceImpl implements IMaterialinfoService 
{
    @Autowired
    private MaterialinfoMapper materialinfoMapper;

    /**
     * 查询材料信息
     * 
     * @param materialid 材料信息ID
     * @return 材料信息
     */
    @Override
    public Materialinfo selectMaterialinfoById(Long materialid)
    {
        return materialinfoMapper.selectMaterialinfoById(materialid);
    }

    /**
     * 查询材料信息列表
     * 
     * @param materialinfo 材料信息
     * @return 材料信息
     */
    @Override
    public List<Materialinfo> selectMaterialinfoList(Materialinfo materialinfo)
    {
        return materialinfoMapper.selectMaterialinfoList(materialinfo);
    }

    /**
     * 新增材料信息
     * 
     * @param materialinfo 材料信息
     * @return 结果
     */
    @Override
    public int insertMaterialinfo(Materialinfo materialinfo)
    {
        return materialinfoMapper.insertMaterialinfo(materialinfo);
    }

    /**
     * 修改材料信息
     * 
     * @param materialinfo 材料信息
     * @return 结果
     */
    @Override
    public int updateMaterialinfo(Materialinfo materialinfo)
    {
        return materialinfoMapper.updateMaterialinfo(materialinfo);
    }

    /**
     * 删除材料信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMaterialinfoByIds(String ids)
    {
        return materialinfoMapper.deleteMaterialinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材料信息信息
     * 
     * @param materialid 材料信息ID
     * @return 结果
     */
    @Override
    public int deleteMaterialinfoById(Long materialid)
    {
        return materialinfoMapper.deleteMaterialinfoById(materialid);
    }

    @Override
    public List<Materialinfo> selectMaterialName(){
        return materialinfoMapper.selectMaterialName();
    }
}
