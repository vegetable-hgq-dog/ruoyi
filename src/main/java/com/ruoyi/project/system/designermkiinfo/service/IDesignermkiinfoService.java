package com.ruoyi.project.system.designermkiinfo.service;

import java.util.List;
import com.ruoyi.project.system.designermkiinfo.domain.Designermkiinfo;

/**
 * 研发人员知识交互信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface IDesignermkiinfoService 
{
    /**
     * 查询研发人员知识交互信息
     * 
     * @param mkiid 研发人员知识交互信息ID
     * @return 研发人员知识交互信息
     */
    public Designermkiinfo selectDesignermkiinfoById(Long mkiid);

    /**
     * 查询研发人员知识交互信息列表
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 研发人员知识交互信息集合
     */
    public List<Designermkiinfo> selectDesignermkiinfoList(Designermkiinfo designermkiinfo);

    /**
     * 新增研发人员知识交互信息
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 结果
     */
    public int insertDesignermkiinfo(Designermkiinfo designermkiinfo);

    /**
     * 修改研发人员知识交互信息
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 结果
     */
    public int updateDesignermkiinfo(Designermkiinfo designermkiinfo);

    /**
     * 批量删除研发人员知识交互信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDesignermkiinfoByIds(String ids);

    /**
     * 删除研发人员知识交互信息信息
     * 
     * @param mkiid 研发人员知识交互信息ID
     * @return 结果
     */
    public int deleteDesignermkiinfoById(Long mkiid);

    public List<Designermkiinfo> selectDesignermkiinfo();
}
