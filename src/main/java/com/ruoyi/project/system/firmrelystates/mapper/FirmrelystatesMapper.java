package com.ruoyi.project.system.firmrelystates.mapper;

import java.util.List;
import com.ruoyi.project.system.firmrelystates.domain.Firmrelystates;

/**
 * 企业群数据管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-15
 */
public interface FirmrelystatesMapper 
{
    /**
     * 查询企业群数据管理
     * 
     * @param id 企业群数据管理ID
     * @return 企业群数据管理
     */
    public Firmrelystates selectFirmrelystatesById(Long id);

    /**
     * 查询企业群数据管理列表
     * 
     * @param firmrelystates 企业群数据管理
     * @return 企业群数据管理集合
     */
    public List<Firmrelystates> selectFirmrelystatesList(Firmrelystates firmrelystates);

    /**
     * 新增企业群数据管理
     * 
     * @param firmrelystates 企业群数据管理
     * @return 结果
     */
    public int insertFirmrelystates(Firmrelystates firmrelystates);

    /**
     * 修改企业群数据管理
     * 
     * @param firmrelystates 企业群数据管理
     * @return 结果
     */
    public int updateFirmrelystates(Firmrelystates firmrelystates);

    /**
     * 删除企业群数据管理
     * 
     * @param id 企业群数据管理ID
     * @return 结果
     */
    public int deleteFirmrelystatesById(Long id);

    /**
     * 批量删除企业群数据管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirmrelystatesByIds(String[] ids);

    public List getRelyState();
}
