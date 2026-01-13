package com.ruoyi.project.system.serviceorder.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.serviceorder.mapper.DsServiceorderMapper;
import com.ruoyi.project.system.serviceorder.domain.DsServiceorder;
import com.ruoyi.project.system.serviceorder.service.IDsServiceorderService;
import com.ruoyi.common.utils.text.Convert;

/**
 * serviceorderService业务层处理
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
@Service
public class DsServiceorderServiceImpl implements IDsServiceorderService 
{
    @Autowired
    private DsServiceorderMapper dsServiceorderMapper;

    /**
     * 查询serviceorder
     * 
     * @param serviceorderid serviceorderID
     * @return serviceorder
     */
    @Override
    public DsServiceorder selectDsServiceorderById(Long serviceorderid)
    {
        return dsServiceorderMapper.selectDsServiceorderById(serviceorderid);
    }

    /**
     * 查询serviceorder列表
     * 
     * @param dsServiceorder serviceorder
     * @return serviceorder
     */
    @Override
    public List<DsServiceorder> selectDsServiceorderList(DsServiceorder dsServiceorder)
    {
        return dsServiceorderMapper.selectDsServiceorderList(dsServiceorder);
    }

    /**
     * 新增serviceorder
     * 
     * @param dsServiceorder serviceorder
     * @return 结果
     */
    @Override
    public int insertDsServiceorder(DsServiceorder dsServiceorder)
    {
        return dsServiceorderMapper.insertDsServiceorder(dsServiceorder);
    }

    /**
     * 修改serviceorder
     * 
     * @param dsServiceorder serviceorder
     * @return 结果
     */
    @Override
    public int updateDsServiceorder(DsServiceorder dsServiceorder)
    {
        return dsServiceorderMapper.updateDsServiceorder(dsServiceorder);
    }

    /**
     * 删除serviceorder对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsServiceorderByIds(String ids)
    {
        return dsServiceorderMapper.deleteDsServiceorderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除serviceorder信息
     * 
     * @param serviceorderid serviceorderID
     * @return 结果
     */
    @Override
    public int deleteDsServiceorderById(Long serviceorderid)
    {
        return dsServiceorderMapper.deleteDsServiceorderById(serviceorderid);
    }
}
