package com.ruoyi.project.system.firmallocationstates.service;

import java.util.List;
import com.ruoyi.project.system.firmallocationstates.domain.Firmallocationstates;

/**
 * 初始分配方案Service接口
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public interface IFirmallocationstatesService 
{
    /**
     * 查询初始分配方案
     * 
     * @param id 初始分配方案ID
     * @return 初始分配方案
     */
    public Firmallocationstates selectFirmallocationstatesById(Long id);

    /**
     * 查询初始分配方案列表
     * 
     * @param firmallocationstates 初始分配方案
     * @return 初始分配方案集合
     */
    public List<Firmallocationstates> selectFirmallocationstatesList(Firmallocationstates firmallocationstates);

    /**
     * 新增初始分配方案
     * 
     * @param firmallocationstates 初始分配方案
     * @return 结果
     */
    public int insertFirmallocationstates(Firmallocationstates firmallocationstates);

    /**
     * 修改初始分配方案
     * 
     * @param firmallocationstates 初始分配方案
     * @return 结果
     */
    public int updateFirmallocationstates(Firmallocationstates firmallocationstates);

    /**
     * 批量删除初始分配方案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmallocationstatesByIds(String ids);

    /**
     * 删除初始分配方案信息
     * 
     * @param id 初始分配方案ID
     * @return 结果
     */
    public int deleteFirmallocationstatesById(Long id);
}
