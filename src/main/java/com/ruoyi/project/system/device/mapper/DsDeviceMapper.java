package com.ruoyi.project.system.device.mapper;

import java.util.List;
import com.ruoyi.project.system.device.domain.DsDevice;

/**
 * 设备管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
public interface DsDeviceMapper 
{
    /**
     * 查询设备管理
     * 
     * @param deviceid 设备管理ID
     * @return 设备管理
     */
    public DsDevice selectDsDeviceById(Long deviceid);

    /**
     * 查询设备管理列表
     * 
     * @param dsDevice 设备管理
     * @return 设备管理集合
     */
    public List<DsDevice> selectDsDeviceList(DsDevice dsDevice);

    /**
     * 新增设备管理
     * 
     * @param dsDevice 设备管理
     * @return 结果
     */
    public int insertDsDevice(DsDevice dsDevice);

    /**
     * 修改设备管理
     * 
     * @param dsDevice 设备管理
     * @return 结果
     */
    public int updateDsDevice(DsDevice dsDevice);

    /**
     * 删除设备管理
     * 
     * @param deviceid 设备管理ID
     * @return 结果
     */
    public int deleteDsDeviceById(Long deviceid);

    /**
     * 批量删除设备管理
     * 
     * @param deviceids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsDeviceByIds(String[] deviceids);
}
