package com.ruoyi.project.system.station.service;

import java.util.List;
import com.ruoyi.project.system.station.domain.DsStation;

/**
 * 工位信息Service接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface IDsStationService 
{
    /**
     * 查询工位信息
     * 
     * @param stationid 工位信息ID
     * @return 工位信息
     */
    public DsStation selectDsStationById(Long stationid);

    /**
     * 查询工位信息列表
     * 
     * @param dsStation 工位信息
     * @return 工位信息集合
     */
    public List<DsStation> selectDsStationList(DsStation dsStation);

    /**
     * 新增工位信息
     * 
     * @param dsStation 工位信息
     * @return 结果
     */
    public int insertDsStation(DsStation dsStation);

    /**
     * 修改工位信息
     * 
     * @param dsStation 工位信息
     * @return 结果
     */
    public int updateDsStation(DsStation dsStation);

    /**
     * 批量删除工位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsStationByIds(String ids);

    /**
     * 删除工位信息信息
     * 
     * @param stationid 工位信息ID
     * @return 结果
     */
    public int deleteDsStationById(Long stationid);
}
