package com.ruoyi.project.system.stationsInfo.service;

import java.util.List;
import com.ruoyi.project.system.stationsInfo.domain.DsStations;

/**
 * 工位信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IDsStationsService 
{
    /**
     * 查询工位信息
     * 
     * @param stationid 工位信息ID
     * @return 工位信息
     */
    public DsStations selectDsStationsById(Long stationid);

    /**
     * 查询工位信息列表
     * 
     * @param dsStations 工位信息
     * @return 工位信息集合
     */
    public List<DsStations> selectDsStationsList(DsStations dsStations);

    /**
     * 新增工位信息
     * 
     * @param dsStations 工位信息
     * @return 结果
     */
    public int insertDsStations(DsStations dsStations);

    /**
     * 修改工位信息
     * 
     * @param dsStations 工位信息
     * @return 结果
     */
    public int updateDsStations(DsStations dsStations);

    /**
     * 批量删除工位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsStationsByIds(String ids);

    /**
     * 删除工位信息信息
     * 
     * @param stationid 工位信息ID
     * @return 结果
     */
    public int deleteDsStationsById(Long stationid);

    public List<DsStations> selectStationID();
}
