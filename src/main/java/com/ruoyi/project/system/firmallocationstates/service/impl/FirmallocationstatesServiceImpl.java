package com.ruoyi.project.system.firmallocationstates.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmallocationstates.mapper.FirmallocationstatesMapper;
import com.ruoyi.project.system.firmallocationstates.domain.Firmallocationstates;
import com.ruoyi.project.system.firmallocationstates.service.IFirmallocationstatesService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 初始分配方案Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Service
public class FirmallocationstatesServiceImpl implements IFirmallocationstatesService 
{
    @Autowired
    private FirmallocationstatesMapper firmallocationstatesMapper;

    /**
     * 查询初始分配方案
     * 
     * @param id 初始分配方案ID
     * @return 初始分配方案
     */
    @Override
    public Firmallocationstates selectFirmallocationstatesById(Long id)
    {
        return firmallocationstatesMapper.selectFirmallocationstatesById(id);
    }

    /**
     * 查询初始分配方案列表
     * 
     * @param firmallocationstates 初始分配方案
     * @return 初始分配方案
     */
    @Override
    public List<Firmallocationstates> selectFirmallocationstatesList(Firmallocationstates firmallocationstates)
    {
        return firmallocationstatesMapper.selectFirmallocationstatesList(firmallocationstates);
    }

    /**
     * 新增初始分配方案
     * 
     * @param firmallocationstates 初始分配方案
     * @return 结果
     */
    @Override
    public int insertFirmallocationstates(Firmallocationstates firmallocationstates)
    {
        return firmallocationstatesMapper.insertFirmallocationstates(firmallocationstates);
    }

    /**
     * 修改初始分配方案
     * 
     * @param firmallocationstates 初始分配方案
     * @return 结果
     */
    @Override
    public int updateFirmallocationstates(Firmallocationstates firmallocationstates)
    {
        return firmallocationstatesMapper.updateFirmallocationstates(firmallocationstates);
    }

    /**
     * 删除初始分配方案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmallocationstatesByIds(String ids)
    {
        return firmallocationstatesMapper.deleteFirmallocationstatesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除初始分配方案信息
     * 
     * @param id 初始分配方案ID
     * @return 结果
     */
    @Override
    public int deleteFirmallocationstatesById(Long id)
    {
        return firmallocationstatesMapper.deleteFirmallocationstatesById(id);
    }
}
