package com.ruoyi.project.system.vechicle.service;

import java.util.List;
import com.ruoyi.project.system.vechicle.domain.DsVechicleProdLoc;

/**
 * 生产信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public interface IDsVechicleProdLocService 
{
    /**
     * 查询生产信息
     * 
     * @param id 生产信息ID
     * @return 生产信息
     */
    public DsVechicleProdLoc selectDsVechicleProdLocById(Long id);

    /**
     * 查询生产信息列表
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 生产信息集合
     */
    public List<DsVechicleProdLoc> selectDsVechicleProdLocList(DsVechicleProdLoc dsVechicleProdLoc);

    /**
     * 新增生产信息
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 结果
     */
    public int insertDsVechicleProdLoc(DsVechicleProdLoc dsVechicleProdLoc);

    /**
     * 修改生产信息
     * 
     * @param dsVechicleProdLoc 生产信息
     * @return 结果
     */
    public int updateDsVechicleProdLoc(DsVechicleProdLoc dsVechicleProdLoc);

    /**
     * 批量删除生产信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsVechicleProdLocByIds(String ids);

    /**
     * 删除生产信息信息
     * 
     * @param id 生产信息ID
     * @return 结果
     */
    public int deleteDsVechicleProdLocById(Long id);
}
