package com.ruoyi.project.system.processing.service;

import java.util.List;
import com.ruoyi.project.system.processing.domain.DsProcessing;

/**
 * 工艺信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsProcessingService 
{
    /**
     * 查询工艺信息
     * 
     * @param processingid 工艺信息ID
     * @return 工艺信息
     */
    public DsProcessing selectDsProcessingById(Long processingid);

    /**
     * 查询工艺信息列表
     * 
     * @param dsProcessing 工艺信息
     * @return 工艺信息集合
     */
    public List<DsProcessing> selectDsProcessingList(DsProcessing dsProcessing);

    /**
     * 新增工艺信息
     * 
     * @param dsProcessing 工艺信息
     * @return 结果
     */
    public int insertDsProcessing(DsProcessing dsProcessing);

    /**
     * 修改工艺信息
     * 
     * @param dsProcessing 工艺信息
     * @return 结果
     */
    public int updateDsProcessing(DsProcessing dsProcessing);

    /**
     * 批量删除工艺信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsProcessingByIds(String ids);

    /**
     * 删除工艺信息信息
     * 
     * @param processingid 工艺信息ID
     * @return 结果
     */
    public int deleteDsProcessingById(Long processingid);
}
