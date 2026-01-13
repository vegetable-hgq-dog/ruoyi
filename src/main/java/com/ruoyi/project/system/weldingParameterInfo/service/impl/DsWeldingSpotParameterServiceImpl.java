package com.ruoyi.project.system.weldingParameterInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.weldingParameterInfo.mapper.DsWeldingSpotParameterMapper;
import com.ruoyi.project.system.weldingParameterInfo.domain.DsWeldingSpotParameter;
import com.ruoyi.project.system.weldingParameterInfo.service.IDsWeldingSpotParameterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 焊点参数Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class DsWeldingSpotParameterServiceImpl implements IDsWeldingSpotParameterService 
{
    @Autowired
    private DsWeldingSpotParameterMapper dsWeldingSpotParameterMapper;

    /**
     * 查询焊点参数
     * 
     * @param dsweldingid 焊点参数ID
     * @return 焊点参数
     */
    @Override
    public DsWeldingSpotParameter selectDsWeldingSpotParameterById(Long dsweldingid)
    {
        return dsWeldingSpotParameterMapper.selectDsWeldingSpotParameterById(dsweldingid);
    }

    /**
     * 查询焊点参数列表
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 焊点参数
     */
    @Override
    public List<DsWeldingSpotParameter> selectDsWeldingSpotParameterList(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        return dsWeldingSpotParameterMapper.selectDsWeldingSpotParameterList(dsWeldingSpotParameter);
    }

    /**
     * 新增焊点参数
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 结果
     */
    @Override
    public int insertDsWeldingSpotParameter(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        return dsWeldingSpotParameterMapper.insertDsWeldingSpotParameter(dsWeldingSpotParameter);
    }

    /**
     * 修改焊点参数
     * 
     * @param dsWeldingSpotParameter 焊点参数
     * @return 结果
     */
    @Override
    public int updateDsWeldingSpotParameter(DsWeldingSpotParameter dsWeldingSpotParameter)
    {
        return dsWeldingSpotParameterMapper.updateDsWeldingSpotParameter(dsWeldingSpotParameter);
    }

    /**
     * 删除焊点参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingSpotParameterByIds(String ids)
    {
        return dsWeldingSpotParameterMapper.deleteDsWeldingSpotParameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除焊点参数信息
     * 
     * @param dsweldingid 焊点参数ID
     * @return 结果
     */
    @Override
    public int deleteDsWeldingSpotParameterById(Long dsweldingid)
    {
        return dsWeldingSpotParameterMapper.deleteDsWeldingSpotParameterById(dsweldingid);
    }

    @Override
    public List<DsWeldingSpotParameter> getAllWeldingSpotPara(){
        return dsWeldingSpotParameterMapper.getAllWeldingSpotPara();
    }
}
