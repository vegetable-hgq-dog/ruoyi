package com.ruoyi.project.system.devicesInfo.mapper;

import java.util.List;
import com.ruoyi.project.system.devicesInfo.domain.DsDevices;

/**
 * 设备信息Mapper接口
 * 
 * @author ruoyi
 * @date 2023-01-09
 */
public interface DsDevicesMapper 
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
     * 删除设备信息
     * 
     * @param deviceid 设备信息ID
     * @return 结果
     */
    public int deleteDsDevicesById(Long deviceid);

    /**
     * 批量删除设备信息
     * 
     * @param deviceids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsDevicesByIds(String[] deviceids);

    public List<DsDevices> selectDeviceID();

    public List<DsDevices> getAllDeviceInfo();
}
