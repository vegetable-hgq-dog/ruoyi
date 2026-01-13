package com.ruoyi.project.system.aftersalecenter.mapper;

import java.util.List;
import com.ruoyi.project.system.aftersalecenter.domain.DsAftersalecenter;

/**
 * aftersalecenterMapper接口
 * 
 * @author ruoyi
 * @date 2023-09-17
 */
public interface DsAftersalecenterMapper 
{
    /**
     * 查询aftersalecenter
     * 
     * @param centerid aftersalecenterID
     * @return aftersalecenter
     */
    public DsAftersalecenter selectDsAftersalecenterById(Long centerid);

    /**
     * 查询aftersalecenter列表
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return aftersalecenter集合
     */
    public List<DsAftersalecenter> selectDsAftersalecenterList(DsAftersalecenter dsAftersalecenter);

    /**
     * 新增aftersalecenter
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return 结果
     */
    public int insertDsAftersalecenter(DsAftersalecenter dsAftersalecenter);

    /**
     * 修改aftersalecenter
     * 
     * @param dsAftersalecenter aftersalecenter
     * @return 结果
     */
    public int updateDsAftersalecenter(DsAftersalecenter dsAftersalecenter);

    /**
     * 删除aftersalecenter
     * 
     * @param centerid aftersalecenterID
     * @return 结果
     */
    public int deleteDsAftersalecenterById(Long centerid);

    /**
     * 批量删除aftersalecenter
     * 
     * @param centerids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsAftersalecenterByIds(String[] centerids);

    public List selectCenterID();
}
