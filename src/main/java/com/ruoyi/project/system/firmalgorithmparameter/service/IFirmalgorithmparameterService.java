package com.ruoyi.project.system.firmalgorithmparameter.service;

import java.util.List;
import com.ruoyi.project.system.firmalgorithmparameter.domain.Firmalgorithmparameter;

/**
 * 需求数据Service接口
 * 
 * @author ruoyi
 * @date 2024-04-16
 */
public interface IFirmalgorithmparameterService 
{
    /**
     * 查询需求数据
     * 
     * @param id 需求数据ID
     * @return 需求数据
     */
    public Firmalgorithmparameter selectFirmalgorithmparameterById(Long id);

    /**
     * 查询需求数据列表
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 需求数据集合
     */
    public List<Firmalgorithmparameter> selectFirmalgorithmparameterList(Firmalgorithmparameter firmalgorithmparameter);

    /**
     * 新增需求数据
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 结果
     */
    public int insertFirmalgorithmparameter(Firmalgorithmparameter firmalgorithmparameter);

    /**
     * 修改需求数据
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 结果
     */
    public int updateFirmalgorithmparameter(Firmalgorithmparameter firmalgorithmparameter);

    /**
     * 批量删除需求数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmalgorithmparameterByIds(String ids);

    /**
     * 删除需求数据信息
     * 
     * @param id 需求数据ID
     * @return 结果
     */
    public int deleteFirmalgorithmparameterById(Long id);
}
