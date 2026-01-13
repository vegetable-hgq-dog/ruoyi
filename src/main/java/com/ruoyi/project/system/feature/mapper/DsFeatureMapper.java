package com.ruoyi.project.system.feature.mapper;

import java.util.List;
import com.ruoyi.project.system.feature.domain.DsFeature;

/**
 * 特征信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsFeatureMapper 
{
    /**
     * 查询特征信息
     * 
     * @param featureid 特征信息ID
     * @return 特征信息
     */
    public DsFeature selectDsFeatureById(Long featureid);

    /**
     * 查询特征信息列表
     * 
     * @param dsFeature 特征信息
     * @return 特征信息集合
     */
    public List<DsFeature> selectDsFeatureList(DsFeature dsFeature);

    /**
     * 新增特征信息
     * 
     * @param dsFeature 特征信息
     * @return 结果
     */
    public int insertDsFeature(DsFeature dsFeature);

    /**
     * 修改特征信息
     * 
     * @param dsFeature 特征信息
     * @return 结果
     */
    public int updateDsFeature(DsFeature dsFeature);

    /**
     * 删除特征信息
     * 
     * @param featureid 特征信息ID
     * @return 结果
     */
    public int deleteDsFeatureById(Long featureid);

    /**
     * 批量删除特征信息
     * 
     * @param featureids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsFeatureByIds(String[] featureids);
}
