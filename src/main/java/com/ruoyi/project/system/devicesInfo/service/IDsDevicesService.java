package com.ruoyi.project.system.devicesInfo.service;

import java.util.List;
import com.ruoyi.project.system.devicesInfo.domain.DsDevices;

/**
 * 设备信息Service接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface IDsDevicesService 
{
    /**
     * 查询设备信息
     * 
     * @param deviceid 设备信息ID
     * @return 设备信息
     */
    public DsDevices selectDsDevicesById(Long deviceid);

    /**
     * 查询设备信息列表
     * 
     * @param dsDevices 设备信息
     * @return 设备信息集合
     */
    public List<DsDevices> selectDsDevicesList(DsDevices dsDevices);

    /**
     * 新增设备信息
     * 
     * @param dsDevices 设备信息
     * @return 结果
     */
    public int insertDsDevices(DsDevices dsDevices);

    /**
     * 修改设备信息
     * 
     * @param dsDevices 设备信息
     * @return 结果
     */
    public int updateDsDevices(DsDevices dsDevices);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsDevicesByIds(String ids);

    /**
     * 删除设备信息信息
     * 
     * @param deviceid 设备信息ID
     * @return 结果
     */
    public int deleteDsDevicesById(Long deviceid);

    public List<DsDevices> selectDeviceID();

    public List<DsDevices> getAllDeviceInfo();
}
