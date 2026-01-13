package com.ruoyi.project.system.parameter.service;

import java.util.List;
import com.ruoyi.project.system.parameter.domain.DsParameter;

/**
 * 参数信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsParameterService 
{
    /**
     * 查询参数信息
     * 
     * @param parameterid 参数信息ID
     * @return 参数信息
     */
    public DsParameter selectDsParameterById(Long parameterid);

    /**
     * 查询参数信息列表
     * 
     * @param dsParameter 参数信息
     * @return 参数信息集合
     */
    public List<DsParameter> selectDsParameterList(DsParameter dsParameter);

    /**
     * 新增参数信息
     * 
     * @param dsParameter 参数信息
     * @return 结果
     */
    public int insertDsParameter(DsParameter dsParameter);

    /**
     * 修改参数信息
     * 
     * @param dsParameter 参数信息
     * @return 结果
     */
    public int updateDsParameter(DsParameter dsParameter);

    /**
     * 批量删除参数信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsParameterByIds(String ids);

    /**
     * 删除参数信息信息
     * 
     * @param parameterid 参数信息ID
     * @return 结果
     */
    public int deleteDsParameterById(Long parameterid);
}
