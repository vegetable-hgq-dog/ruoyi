package com.ruoyi.project.system.firmacceptable.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.firmacceptable.mapper.FirmacceptableMapper;
import com.ruoyi.project.system.firmacceptable.domain.Firmacceptable;
import com.ruoyi.project.system.firmacceptable.service.IFirmacceptableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 可接受不可操作的程度Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
@Service
public class FirmacceptableServiceImpl implements IFirmacceptableService 
{
    @Autowired
    private FirmacceptableMapper firmacceptableMapper;

    /**
     * 查询可接受不可操作的程度
     * 
     * @param id 可接受不可操作的程度ID
     * @return 可接受不可操作的程度
     */
    @Override
    public Firmacceptable selectFirmacceptableById(Long id)
    {
        return firmacceptableMapper.selectFirmacceptableById(id);
    }

    /**
     * 查询可接受不可操作的程度列表
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 可接受不可操作的程度
     */
    @Override
    public List<Firmacceptable> selectFirmacceptableList(Firmacceptable firmacceptable)
    {
        return firmacceptableMapper.selectFirmacceptableList(firmacceptable);
    }

    /**
     * 新增可接受不可操作的程度
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 结果
     */
    @Override
    public int insertFirmacceptable(Firmacceptable firmacceptable)
    {
        return firmacceptableMapper.insertFirmacceptable(firmacceptable);
    }

    /**
     * 修改可接受不可操作的程度
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 结果
     */
    @Override
    public int updateFirmacceptable(Firmacceptable firmacceptable)
    {
        return firmacceptableMapper.updateFirmacceptable(firmacceptable);
    }

    /**
     * 删除可接受不可操作的程度对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFirmacceptableByIds(String ids)
    {
        return firmacceptableMapper.deleteFirmacceptableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除可接受不可操作的程度信息
     * 
     * @param id 可接受不可操作的程度ID
     * @return 结果
     */
    @Override
    public int deleteFirmacceptableById(Long id)
    {
        return firmacceptableMapper.deleteFirmacceptableById(id);

    }
    @Override
    public List getAcceptable(){
       return firmacceptableMapper.getAcceptable();
    }
}


