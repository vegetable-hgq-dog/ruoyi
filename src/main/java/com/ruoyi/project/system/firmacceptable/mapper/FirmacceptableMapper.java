package com.ruoyi.project.system.firmacceptable.mapper;

import java.util.List;
import com.ruoyi.project.system.firmacceptable.domain.Firmacceptable;

/**
 * 可接受不可操作的程度Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public interface FirmacceptableMapper 
{
    /**
     * 查询可接受不可操作的程度
     * 
     * @param id 可接受不可操作的程度ID
     * @return 可接受不可操作的程度
     */
    public Firmacceptable selectFirmacceptableById(Long id);

    /**
     * 查询可接受不可操作的程度列表
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 可接受不可操作的程度集合
     */
    public List<Firmacceptable> selectFirmacceptableList(Firmacceptable firmacceptable);

    /**
     * 新增可接受不可操作的程度
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 结果
     */
    public int insertFirmacceptable(Firmacceptable firmacceptable);

    /**
     * 修改可接受不可操作的程度
     * 
     * @param firmacceptable 可接受不可操作的程度
     * @return 结果
     */
    public int updateFirmacceptable(Firmacceptable firmacceptable);

    /**
     * 删除可接受不可操作的程度
     * 
     * @param id 可接受不可操作的程度ID
     * @return 结果
     */
    public int deleteFirmacceptableById(Long id);

    /**
     * 批量删除可接受不可操作的程度
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmacceptableByIds(String[] ids);

    public List getAcceptable();
}
