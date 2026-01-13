package com.ruoyi.project.system.hotdata.service;

import java.util.List;
import com.ruoyi.project.system.hotdata.domain.Hotdata;

/**
 * 热门数据Service接口
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
public interface IHotdataService 
{
    /**
     * 查询热门数据
     * 
     * @param id 热门数据ID
     * @return 热门数据
     */
    public Hotdata selectHotdataById(Long id);

    /**
     * 查询热门数据列表
     * 
     * @param hotdata 热门数据
     * @return 热门数据集合
     */
    public List<Hotdata> selectHotdataList(Hotdata hotdata);

    /**
     * 新增热门数据
     * 
     * @param hotdata 热门数据
     * @return 结果
     */
    public int insertHotdata(Hotdata hotdata);

    /**
     * 修改热门数据
     * 
     * @param hotdata 热门数据
     * @return 结果
     */
    public int updateHotdata(Hotdata hotdata);

    /**
     * 批量删除热门数据
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHotdataByIds(String ids);

    /**
     * 删除热门数据信息
     * 
     * @param id 热门数据ID
     * @return 结果
     */
    public int deleteHotdataById(Long id);
}
