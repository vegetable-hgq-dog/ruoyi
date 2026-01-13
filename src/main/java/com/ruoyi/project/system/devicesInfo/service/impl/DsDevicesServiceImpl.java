package com.ruoyi.project.system.devicesInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.devicesInfo.mapper.DsDevicesMapper;
import com.ruoyi.project.system.devicesInfo.domain.DsDevices;
import com.ruoyi.project.system.devicesInfo.service.IDsDevicesService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 设备信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
@Service
public class DsDevicesServiceImpl implements IDsDevicesService 
{
    @Autowired
    private DsDevicesMapper dsDevicesMapper;

    /**
     * 查询设备信息
     * 
     * @param deviceid 设备信息ID
     * @return 设备信息
     */
    @Override
    public DsDevices selectDsDevicesById(Long deviceid)
    {
        return dsDevicesMapper.selectDsDevicesById(deviceid);
    }

    /**
     * 查询设备信息列表
     * 
     * @param dsDevices 设备信息
     * @return 设备信息
     */
    @Override
    public List<DsDevices> selectDsDevicesList(DsDevices dsDevices)
    {
        return dsDevicesMapper.selectDsDevicesList(dsDevices);
    }

    /**
     * 新增设备信息
     * 
     * @param dsDevices 设备信息
     * @return 结果
     */
    @Override
    public int insertDsDevices(DsDevices dsDevices)
    {
        return dsDevicesMapper.insertDsDevices(dsDevices);
    }

    /**
     * 修改设备信息
     * 
     * @param dsDevices 设备信息
     * @return 结果
     */
    @Override
    public int updateDsDevices(DsDevices dsDevices)
    {
        return dsDevicesMapper.updateDsDevices(dsDevices);
    }

    /**
     * 删除设备信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsDevicesByIds(String ids)
    {
        return dsDevicesMapper.deleteDsDevicesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息信息
     * 
     * @param deviceid 设备信息ID
     * @return 结果
     */
    @Override
    public int deleteDsDevicesById(Long deviceid)
    {
        return dsDevicesMapper.deleteDsDevicesById(deviceid);
    }

    @Override
    public List<DsDevices> selectDeviceID(){
        return dsDevicesMapper.selectDeviceID();
    }

    @Override
    public List<DsDevices> getAllDeviceInfo(){
        return dsDevicesMapper.getAllDeviceInfo();
    }
}
