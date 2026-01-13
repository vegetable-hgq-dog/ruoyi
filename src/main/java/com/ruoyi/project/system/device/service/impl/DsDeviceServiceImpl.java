package com.ruoyi.project.system.device.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.device.mapper.DsDeviceMapper;
import com.ruoyi.project.system.device.domain.DsDevice;
import com.ruoyi.project.system.device.service.IDsDeviceService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 设备管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsDeviceServiceImpl implements IDsDeviceService 
{
    @Autowired
    private DsDeviceMapper dsDeviceMapper;

    /**
     * 查询设备管理
     * 
     * @param deviceid 设备管理ID
     * @return 设备管理
     */
    @Override
    public DsDevice selectDsDeviceById(Long deviceid)
    {
        return dsDeviceMapper.selectDsDeviceById(deviceid);
    }

    /**
     * 查询设备管理列表
     * 
     * @param dsDevice 设备管理
     * @return 设备管理
     */
    @Override
    public List<DsDevice> selectDsDeviceList(DsDevice dsDevice)
    {
        return dsDeviceMapper.selectDsDeviceList(dsDevice);
    }

    /**
     * 新增设备管理
     * 
     * @param dsDevice 设备管理
     * @return 结果
     */
    @Override
    public int insertDsDevice(DsDevice dsDevice)
    {
        return dsDeviceMapper.insertDsDevice(dsDevice);
    }

    /**
     * 修改设备管理
     * 
     * @param dsDevice 设备管理
     * @return 结果
     */
    @Override
    public int updateDsDevice(DsDevice dsDevice)
    {
        return dsDeviceMapper.updateDsDevice(dsDevice);
    }

    /**
     * 删除设备管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsDeviceByIds(String ids)
    {
        return dsDeviceMapper.deleteDsDeviceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备管理信息
     * 
     * @param deviceid 设备管理ID
     * @return 结果
     */
    @Override
    public int deleteDsDeviceById(Long deviceid)
    {
        return dsDeviceMapper.deleteDsDeviceById(deviceid);
    }
}
