package com.ruoyi.project.system.productline.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.productline.mapper.DsProductlineMapper;
import com.ruoyi.project.system.productline.domain.DsProductline;
import com.ruoyi.project.system.productline.service.IDsProductlineService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 产线信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsProductlineServiceImpl implements IDsProductlineService 
{
    @Autowired
    private DsProductlineMapper dsProductlineMapper;

    /**
     * 查询产线信息
     * 
     * @param productlineid 产线信息ID
     * @return 产线信息
     */
    @Override
    public DsProductline selectDsProductlineById(Long productlineid)
    {
        return dsProductlineMapper.selectDsProductlineById(productlineid);
    }

    /**
     * 查询产线信息列表
     * 
     * @param dsProductline 产线信息
     * @return 产线信息
     */
    @Override
    public List<DsProductline> selectDsProductlineList(DsProductline dsProductline)
    {
        return dsProductlineMapper.selectDsProductlineList(dsProductline);
    }

    /**
     * 新增产线信息
     * 
     * @param dsProductline 产线信息
     * @return 结果
     */
    @Override
    public int insertDsProductline(DsProductline dsProductline)
    {
        return dsProductlineMapper.insertDsProductline(dsProductline);
    }

    /**
     * 修改产线信息
     * 
     * @param dsProductline 产线信息
     * @return 结果
     */
    @Override
    public int updateDsProductline(DsProductline dsProductline)
    {
        return dsProductlineMapper.updateDsProductline(dsProductline);
    }

    /**
     * 删除产线信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsProductlineByIds(String ids)
    {
        return dsProductlineMapper.deleteDsProductlineByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产线信息信息
     * 
     * @param productlineid 产线信息ID
     * @return 结果
     */
    @Override
    public int deleteDsProductlineById(Long productlineid)
    {
        return dsProductlineMapper.deleteDsProductlineById(productlineid);
    }
}
