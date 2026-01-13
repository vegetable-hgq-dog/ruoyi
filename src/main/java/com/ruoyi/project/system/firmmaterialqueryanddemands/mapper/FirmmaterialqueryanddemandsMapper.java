package com.ruoyi.project.system.firmmaterialqueryanddemands.mapper;

import java.util.List;
import com.ruoyi.project.system.firmmaterialqueryanddemands.domain.Firmmaterialqueryanddemands;

/**
 * 需求数据Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public interface FirmmaterialqueryanddemandsMapper 
{
    /**
     * 查询需求数据
     * 
     * @param id 需求数据ID
     * @return 需求数据
     */
    public Firmmaterialqueryanddemands selectFirmmaterialqueryanddemandsById(Long id);

    /**
     * 查询需求数据列表
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 需求数据集合
     */
    public List<Firmmaterialqueryanddemands> selectFirmmaterialqueryanddemandsList(Firmmaterialqueryanddemands firmmaterialqueryanddemands);

    /**
     * 新增需求数据
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 结果
     */
    public int insertFirmmaterialqueryanddemands(Firmmaterialqueryanddemands firmmaterialqueryanddemands);

    /**
     * 修改需求数据
     * 
     * @param firmmaterialqueryanddemands 需求数据
     * @return 结果
     */
    public int updateFirmmaterialqueryanddemands(Firmmaterialqueryanddemands firmmaterialqueryanddemands);

    /**
     * 删除需求数据
     * 
     * @param id 需求数据ID
     * @return 结果
     */
    public int deleteFirmmaterialqueryanddemandsById(Long id);

    /**
     * 批量删除需求数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmmaterialqueryanddemandsByIds(String[] ids);
}
