package com.ruoyi.project.system.hotdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.hotdata.mapper.HotdataMapper;
import com.ruoyi.project.system.hotdata.domain.Hotdata;
import com.ruoyi.project.system.hotdata.service.IHotdataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 热门数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class HotdataServiceImpl implements IHotdataService 
{
    @Autowired
    private HotdataMapper hotdataMapper;

    /**
     * 查询热门数据
     * 
     * @param id 热门数据ID
     * @return 热门数据
     */
    @Override
    public Hotdata selectHotdataById(Long id)
    {
        return hotdataMapper.selectHotdataById(id);
    }

    /**
     * 查询热门数据列表
     * 
     * @param hotdata 热门数据
     * @return 热门数据
     */
    @Override
    public List<Hotdata> selectHotdataList(Hotdata hotdata)
    {
        return hotdataMapper.selectHotdataList(hotdata);
    }

    /**
     * 新增热门数据
     * 
     * @param hotdata 热门数据
     * @return 结果
     */
    @Override
    public int insertHotdata(Hotdata hotdata)
    {
        return hotdataMapper.insertHotdata(hotdata);
    }

    /**
     * 修改热门数据
     * 
     * @param hotdata 热门数据
     * @return 结果
     */
    @Override
    public int updateHotdata(Hotdata hotdata)
    {
        return hotdataMapper.updateHotdata(hotdata);
    }

    /**
     * 删除热门数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHotdataByIds(String ids)
    {
        return hotdataMapper.deleteHotdataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除热门数据信息
     * 
     * @param id 热门数据ID
     * @return 结果
     */
    @Override
    public int deleteHotdataById(Long id)
    {
        return hotdataMapper.deleteHotdataById(id);
    }
}
