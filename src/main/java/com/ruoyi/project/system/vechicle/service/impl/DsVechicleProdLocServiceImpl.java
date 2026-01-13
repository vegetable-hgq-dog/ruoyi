package com.ruoyi.project.system.vechicle.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.vechicle.mapper.DsVechicleProdLocMapper;
import com.ruoyi.project.system.vechicle.domain.DsVechicleProdLoc;
import com.ruoyi.project.system.vechicle.service.IDsVechicleProdLocService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 生产信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class DsVechicleProdLocServiceImpl implements IDsVechicleProdLocService 
{
    @Autowired
    private DsVechicleProdLocMapper dsVechicleProdLocMapper;

    /**
     * 查询生产信息
     * 
     * @param id 生产信息ID
     * @return 生产信息
     */
    @Override
    public DsVechicleProdLoc selectDsVechicleProdLocById(Long id)
    {
        return dsVechicleProdLocMapper.selectDsVechicleProdLocById(id);
    }

    /**
     * 查询生产信息列表
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 生产信息
     */
    @Override
    public List<DsVechicleProdLoc> selectDsVechicleProdLocList(DsVechicleProdLoc dsVechicleProdLoc)
    {
        return dsVechicleProdLocMapper.selectDsVechicleProdLocList(dsVechicleProdLoc);
    }

    /**
     * 新增生产信息
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 结果
     */
    @Override
    public int insertDsVechicleProdLoc(DsVechicleProdLoc dsVechicleProdLoc)
    {
        return dsVechicleProdLocMapper.insertDsVechicleProdLoc(dsVechicleProdLoc);
    }

    /**
     * 修改生产信息
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 结果
     */
    @Override
    public int updateDsVechicleProdLoc(DsVechicleProdLoc dsVechicleProdLoc)
    {
        return dsVechicleProdLocMapper.updateDsVechicleProdLoc(dsVechicleProdLoc);
    }

    /**
     * 删除生产信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsVechicleProdLocByIds(String ids)
    {
        return dsVechicleProdLocMapper.deleteDsVechicleProdLocByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除生产信息信息
     * 
     * @param id 生产信息ID
     * @return 结果
     */
    @Override
    public int deleteDsVechicleProdLocById(Long id)
    {
        return dsVechicleProdLocMapper.deleteDsVechicleProdLocById(id);
    }
}
