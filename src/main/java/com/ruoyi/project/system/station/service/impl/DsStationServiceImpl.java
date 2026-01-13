package com.ruoyi.project.system.station.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.station.mapper.DsStationMapper;
import com.ruoyi.project.system.station.domain.DsStation;
import com.ruoyi.project.system.station.service.IDsStationService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工位信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsStationServiceImpl implements IDsStationService 
{
    @Autowired
    private DsStationMapper dsStationMapper;

    /**
     * 查询工位信息
     * 
     * @param stationid 工位信息ID
     * @return 工位信息
     */
    @Override
    public DsStation selectDsStationById(Long stationid)
    {
        return dsStationMapper.selectDsStationById(stationid);
    }

    /**
     * 查询工位信息列表
     * 
     * @param dsStation 工位信息
     * @return 工位信息
     */
    @Override
    public List<DsStation> selectDsStationList(DsStation dsStation)
    {
        return dsStationMapper.selectDsStationList(dsStation);
    }

    /**
     * 新增工位信息
     * 
     * @param dsStation 工位信息
     * @return 结果
     */
    @Override
    public int insertDsStation(DsStation dsStation)
    {
        return dsStationMapper.insertDsStation(dsStation);
    }

    /**
     * 修改工位信息
     * 
     * @param dsStation 工位信息
     * @return 结果
     */
    @Override
    public int updateDsStation(DsStation dsStation)
    {
        return dsStationMapper.updateDsStation(dsStation);
    }

    /**
     * 删除工位信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsStationByIds(String ids)
    {
        return dsStationMapper.deleteDsStationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工位信息信息
     * 
     * @param stationid 工位信息ID
     * @return 结果
     */
    @Override
    public int deleteDsStationById(Long stationid)
    {
        return dsStationMapper.deleteDsStationById(stationid);
    }
}
