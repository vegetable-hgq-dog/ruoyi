package com.ruoyi.project.system.firmalgorithmparameter.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmalgorithmparameter.mapper.FirmalgorithmparameterMapper;
import com.ruoyi.project.system.firmalgorithmparameter.domain.Firmalgorithmparameter;
import com.ruoyi.project.system.firmalgorithmparameter.service.IFirmalgorithmparameterService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 需求数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-16
 */
@Service
public class FirmalgorithmparameterServiceImpl implements IFirmalgorithmparameterService 
{
    @Autowired
    private FirmalgorithmparameterMapper firmalgorithmparameterMapper;

    /**
     * 查询需求数据
     * 
     * @param id 需求数据ID
     * @return 需求数据
     */
    @Override
    public Firmalgorithmparameter selectFirmalgorithmparameterById(Long id)
    {
        return firmalgorithmparameterMapper.selectFirmalgorithmparameterById(id);
    }

    /**
     * 查询需求数据列表
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 需求数据
     */
    @Override
    public List<Firmalgorithmparameter> selectFirmalgorithmparameterList(Firmalgorithmparameter firmalgorithmparameter)
    {
        return firmalgorithmparameterMapper.selectFirmalgorithmparameterList(firmalgorithmparameter);
    }

    /**
     * 新增需求数据
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 结果
     */
    @Override
    public int insertFirmalgorithmparameter(Firmalgorithmparameter firmalgorithmparameter)
    {
        return firmalgorithmparameterMapper.insertFirmalgorithmparameter(firmalgorithmparameter);
    }

    /**
     * 修改需求数据
     * 
     * @param firmalgorithmparameter 需求数据
     * @return 结果
     */
    @Override
    public int updateFirmalgorithmparameter(Firmalgorithmparameter firmalgorithmparameter)
    {
        return firmalgorithmparameterMapper.updateFirmalgorithmparameter(firmalgorithmparameter);
    }

    /**
     * 删除需求数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmalgorithmparameterByIds(String ids)
    {
        return firmalgorithmparameterMapper.deleteFirmalgorithmparameterByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除需求数据信息
     * 
     * @param id 需求数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmalgorithmparameterById(Long id)
    {
        return firmalgorithmparameterMapper.deleteFirmalgorithmparameterById(id);
    }
}
