package com.ruoyi.project.system.materialinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.materialinfo.domain.Materialinfo;

/**
 * 材料信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface MaterialinfoMapper 
{
    /**
     * 查询材料信息
     * 
     * @param materialid 材料信息ID
     * @return 材料信息
     */
    public Materialinfo selectMaterialinfoById(Long materialid);

    /**
     * 查询材料信息列表
     * 
     * @param materialinfo 材料信息
     * @return 材料信息集合
     */
    public List<Materialinfo> selectMaterialinfoList(Materialinfo materialinfo);

    /**
     * 新增材料信息
     * 
     * @param materialinfo 材料信息
     * @return 结果
     */
    public int insertMaterialinfo(Materialinfo materialinfo);

    /**
     * 修改材料信息
     * 
     * @param materialinfo 材料信息
     * @return 结果
     */
    public int updateMaterialinfo(Materialinfo materialinfo);

    /**
     * 删除材料信息
     * 
     * @param materialid 材料信息ID
     * @return 结果
     */
    public int deleteMaterialinfoById(Long materialid);

    /**
     * 批量删除材料信息
     * 
     * @param materialids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialinfoByIds(String[] materialids);

    public List<Materialinfo> selectMaterialName();

}
