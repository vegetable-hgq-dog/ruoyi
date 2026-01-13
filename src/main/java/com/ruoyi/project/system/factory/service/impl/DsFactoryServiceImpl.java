package com.ruoyi.project.system.factory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.factory.mapper.DsFactoryMapper;
import com.ruoyi.project.system.factory.domain.DsFactory;
import com.ruoyi.project.system.factory.service.IDsFactoryService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工厂信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsFactoryServiceImpl implements IDsFactoryService 
{
    @Autowired
    private DsFactoryMapper dsFactoryMapper;

    /**
     * 查询工厂信息
     * 
     * @param factoryid 工厂信息ID
     * @return 工厂信息
     */
    @Override
    public DsFactory selectDsFactoryById(Long factoryid)
    {
        return dsFactoryMapper.selectDsFactoryById(factoryid);
    }

    /**
     * 查询工厂信息列表
     * 
     * @param dsFactory 工厂信息
     * @return 工厂信息
     */
    @Override
    public List<DsFactory> selectDsFactoryList(DsFactory dsFactory)
    {
        return dsFactoryMapper.selectDsFactoryList(dsFactory);
    }

    /**
     * 新增工厂信息
     * 
     * @param dsFactory 工厂信息
     * @return 结果
     */
    @Override
    public int insertDsFactory(DsFactory dsFactory)
    {
        return dsFactoryMapper.insertDsFactory(dsFactory);
    }

    /**
     * 修改工厂信息
     * 
     * @param dsFactory 工厂信息
     * @return 结果
     */
    @Override
    public int updateDsFactory(DsFactory dsFactory)
    {
        return dsFactoryMapper.updateDsFactory(dsFactory);
    }

    /**
     * 删除工厂信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsFactoryByIds(String ids)
    {
        return dsFactoryMapper.deleteDsFactoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工厂信息信息
     * 
     * @param factoryid 工厂信息ID
     * @return 结果
     */
    @Override
    public int deleteDsFactoryById(Long factoryid)
    {
        return dsFactoryMapper.deleteDsFactoryById(factoryid);
    }
}
