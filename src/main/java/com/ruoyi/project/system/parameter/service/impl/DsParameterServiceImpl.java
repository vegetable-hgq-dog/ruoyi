package com.ruoyi.project.system.parameter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.parameter.mapper.DsParameterMapper;
import com.ruoyi.project.system.parameter.domain.DsParameter;
import com.ruoyi.project.system.parameter.service.IDsParameterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 参数信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsParameterServiceImpl implements IDsParameterService 
{
    @Autowired
    private DsParameterMapper dsParameterMapper;

    /**
     * 查询参数信息
     * 
     * @param parameterid 参数信息ID
     * @return 参数信息
     */
    @Override
    public DsParameter selectDsParameterById(Long parameterid)
    {
        return dsParameterMapper.selectDsParameterById(parameterid);
    }

    /**
     * 查询参数信息列表
     * 
     * @param dsParameter 参数信息
     * @return 参数信息
     */
    @Override
    public List<DsParameter> selectDsParameterList(DsParameter dsParameter)
    {
        return dsParameterMapper.selectDsParameterList(dsParameter);
    }

    /**
     * 新增参数信息
     * 
     * @param dsParameter 参数信息
     * @return 结果
     */
    @Override
    public int insertDsParameter(DsParameter dsParameter)
    {
        return dsParameterMapper.insertDsParameter(dsParameter);
    }

    /**
     * 修改参数信息
     * 
     * @param dsParameter 参数信息
     * @return 结果
     */
    @Override
    public int updateDsParameter(DsParameter dsParameter)
    {
        return dsParameterMapper.updateDsParameter(dsParameter);
    }

    /**
     * 删除参数信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsParameterByIds(String ids)
    {
        return dsParameterMapper.deleteDsParameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除参数信息信息
     * 
     * @param parameterid 参数信息ID
     * @return 结果
     */
    @Override
    public int deleteDsParameterById(Long parameterid)
    {
        return dsParameterMapper.deleteDsParameterById(parameterid);
    }
}
