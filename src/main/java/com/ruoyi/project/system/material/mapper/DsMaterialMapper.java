package com.ruoyi.project.system.material.mapper;

import java.util.List;
import com.ruoyi.project.system.material.domain.DsMaterial;

/**
 * 材料信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsMaterialMapper 
{
    /**
     * 查询材料信息
     * 
     * @param materialid 材料信息ID
     * @return 材料信息
     */
    public DsMaterial selectDsMaterialById(Long materialid);

    /**
     * 查询材料信息列表
     * 
     * @param dsMaterial 材料信息
     * @return 材料信息集合
     */
    public List<DsMaterial> selectDsMaterialList(DsMaterial dsMaterial);

    /**
     * 新增材料信息
     * 
     * @param dsMaterial 材料信息
     * @return 结果
     */
    public int insertDsMaterial(DsMaterial dsMaterial);

    /**
     * 修改材料信息
     * 
     * @param dsMaterial 材料信息
     * @return 结果
     */
    public int updateDsMaterial(DsMaterial dsMaterial);

    /**
     * 删除材料信息
     * 
     * @param materialid 材料信息ID
     * @return 结果
     */
    public int deleteDsMaterialById(Long materialid);

    /**
     * 批量删除材料信息
     * 
     * @param materialids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsMaterialByIds(String[] materialids);
}
