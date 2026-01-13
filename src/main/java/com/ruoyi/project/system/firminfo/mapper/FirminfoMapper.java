package com.ruoyi.project.system.firminfo.mapper;

import java.util.List;

import com.ruoyi.project.system.designermkiinfo.domain.Designermkiinfo;
import com.ruoyi.project.system.firminfo.domain.Firminfo;

/**
 * 供应链企业信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-04-09
 */
public interface FirminfoMapper 
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
     * 删除供应链企业信息
     * 
     * @param firmId 供应链企业信息ID
     * @return 结果
     */
    public int deleteFirminfoById(Long firmId);

    /**
     * 批量删除供应链企业信息
     * 
     * @param firmIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFirminfoByIds(String[] firmIds);

    /**
     *
     * @return MySQL中全部数据
     */
    public List selectFirmInfos();

    /**
     *
     * @return 返回全部层级
     */
    public List getLayers();
}
