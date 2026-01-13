package com.ruoyi.project.system.firminfo.service;

import java.util.List;
import com.ruoyi.project.system.firminfo.domain.Firminfo;

/**
 * 供应链企业信息Service接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface IFirminfoService 
{
    /**
     * 查询供应链企业信息
     * 
     * @param firmId 供应链企业信息ID
     * @return 供应链企业信息
     */
    public Firminfo selectFirminfoById(Long firmId);

    /**
     * 查询供应链企业信息列表
     * 
     * @param firminfo 供应链企业信息
     * @return 供应链企业信息集合
     */
    public List<Firminfo> selectFirminfoList(Firminfo firminfo);

    /**
     * 新增供应链企业信息
     * 
     * @param firminfo 供应链企业信息
     * @return 结果
     */
    public int insertFirminfo(Firminfo firminfo);

    /**
     * 修改供应链企业信息
     * 
     * @param firminfo 供应链企业信息
     * @return 结果
     */
    public int updateFirminfo(Firminfo firminfo);

    /**
     * 批量删除供应链企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirminfoByIds(String ids);

    /**
     * 删除供应链企业信息信息
     * 
     * @param firmId 供应链企业信息ID
     * @return 结果
     */
    public int deleteFirminfoById(Long firmId);

    public List selectFirmInfos();

    public List getLayers();
}
