package com.ruoyi.project.system.feature.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.feature.mapper.DsFeatureMapper;
import com.ruoyi.project.system.feature.domain.DsFeature;
import com.ruoyi.project.system.feature.service.IDsFeatureService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 特征信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsFeatureServiceImpl implements IDsFeatureService 
{
    @Autowired
    private DsFeatureMapper dsFeatureMapper;

    /**
     * 查询特征信息
     * 
     * @param featureid 特征信息ID
     * @return 特征信息
     */
    @Override
    public DsFeature selectDsFeatureById(Long featureid)
    {
        return dsFeatureMapper.selectDsFeatureById(featureid);
    }

    /**
     * 查询特征信息列表
     * 
     * @param dsFeature 特征信息
     * @return 特征信息
     */
    @Override
    public List<DsFeature> selectDsFeatureList(DsFeature dsFeature)
    {
        return dsFeatureMapper.selectDsFeatureList(dsFeature);
    }

    /**
     * 新增特征信息
     * 
     * @param dsFeature 特征信息
     * @return 结果
     */
    @Override
    public int insertDsFeature(DsFeature dsFeature)
    {
        return dsFeatureMapper.insertDsFeature(dsFeature);
    }

    /**
     * 修改特征信息
     * 
     * @param dsFeature 特征信息
     * @return 结果
     */
    @Override
    public int updateDsFeature(DsFeature dsFeature)
    {
        return dsFeatureMapper.updateDsFeature(dsFeature);
    }

    /**
     * 删除特征信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsFeatureByIds(String ids)
    {
        return dsFeatureMapper.deleteDsFeatureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除特征信息信息
     * 
     * @param featureid 特征信息ID
     * @return 结果
     */
    @Override
    public int deleteDsFeatureById(Long featureid)
    {
        return dsFeatureMapper.deleteDsFeatureById(featureid);
    }
}
