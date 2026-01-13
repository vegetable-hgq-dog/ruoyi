package com.ruoyi.project.system.stationsInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.stationsInfo.mapper.DsStationsMapper;
import com.ruoyi.project.system.stationsInfo.domain.DsStations;
import com.ruoyi.project.system.stationsInfo.service.IDsStationsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工位信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class DsStationsServiceImpl implements IDsStationsService 
{
    @Autowired
    private DsStationsMapper dsStationsMapper;

    /**
     * 查询工位信息
     * 
     * @param stationid 工位信息ID
     * @return 工位信息
     */
    @Override
    public DsStations selectDsStationsById(Long stationid)
    {
        return dsStationsMapper.selectDsStationsById(stationid);
    }

    /**
     * 查询工位信息列表
     * 
     * @param dsStations 工位信息
     * @return 工位信息
     */
    @Override
    public List<DsStations> selectDsStationsList(DsStations dsStations)
    {
        return dsStationsMapper.selectDsStationsList(dsStations);
    }

    /**
     * 新增工位信息
     * 
     * @param dsStations 工位信息
     * @return 结果
     */
    @Override
    public int insertDsStations(DsStations dsStations)
    {
        return dsStationsMapper.insertDsStations(dsStations);
    }

    /**
     * 修改工位信息
     * 
     * @param dsStations 工位信息
     * @return 结果
     */
    @Override
    public int updateDsStations(DsStations dsStations)
    {
        return dsStationsMapper.updateDsStations(dsStations);
    }

    /**
     * 删除工位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsStationsByIds(String ids)
    {
        return dsStationsMapper.deleteDsStationsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工位信息信息
     * 
     * @param stationid 工位信息ID
     * @return 结果
     */
    @Override
    public int deleteDsStationsById(Long stationid)
    {
        return dsStationsMapper.deleteDsStationsById(stationid);
    }

    @Override
    public List<DsStations> selectStationID(){
        return dsStationsMapper.selectStationID();
    }
}
