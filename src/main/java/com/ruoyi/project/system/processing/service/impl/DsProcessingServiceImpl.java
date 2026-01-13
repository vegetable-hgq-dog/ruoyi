package com.ruoyi.project.system.processing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.processing.mapper.DsProcessingMapper;
import com.ruoyi.project.system.processing.domain.DsProcessing;
import com.ruoyi.project.system.processing.service.IDsProcessingService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工艺信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsProcessingServiceImpl implements IDsProcessingService 
{
    @Autowired
    private DsProcessingMapper dsProcessingMapper;

    /**
     * 查询工艺信息
     * 
     * @param processingid 工艺信息ID
     * @return 工艺信息
     */
    @Override
    public DsProcessing selectDsProcessingById(Long processingid)
    {
        return dsProcessingMapper.selectDsProcessingById(processingid);
    }

    /**
     * 查询工艺信息列表
     * 
     * @param dsProcessing 工艺信息
     * @return 工艺信息
     */
    @Override
    public List<DsProcessing> selectDsProcessingList(DsProcessing dsProcessing)
    {
        return dsProcessingMapper.selectDsProcessingList(dsProcessing);
    }

    /**
     * 新增工艺信息
     * 
     * @param dsProcessing 工艺信息
     * @return 结果
     */
    @Override
    public int insertDsProcessing(DsProcessing dsProcessing)
    {
        return dsProcessingMapper.insertDsProcessing(dsProcessing);
    }

    /**
     * 修改工艺信息
     * 
     * @param dsProcessing 工艺信息
     * @return 结果
     */
    @Override
    public int updateDsProcessing(DsProcessing dsProcessing)
    {
        return dsProcessingMapper.updateDsProcessing(dsProcessing);
    }

    /**
     * 删除工艺信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsProcessingByIds(String ids)
    {
        return dsProcessingMapper.deleteDsProcessingByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工艺信息信息
     * 
     * @param processingid 工艺信息ID
     * @return 结果
     */
    @Override
    public int deleteDsProcessingById(Long processingid)
    {
        return dsProcessingMapper.deleteDsProcessingById(processingid);
    }
}
