package com.ruoyi.project.system.mkiinfo.service;

import java.util.List;
import com.ruoyi.project.system.mkiinfo.domain.Mkiinfo;

/**
 * 制造知识信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface IMkiinfoService 
{
    /**
     * 查询制造知识信息
     * 
     * @param mkiid 制造知识信息ID
     * @return 制造知识信息
     */
    public Mkiinfo selectMkiinfoById(Long mkiid);

    /**
     * 查询制造知识信息列表
     * 
     * @param mkiinfo 制造知识信息
     * @return 制造知识信息集合
     */
    public List<Mkiinfo> selectMkiinfoList(Mkiinfo mkiinfo);

    /**
     * 新增制造知识信息
     * 
     * @param mkiinfo 制造知识信息
     * @return 结果
     */
    public int insertMkiinfo(Mkiinfo mkiinfo);

    /**
     * 修改制造知识信息
     * 
     * @param mkiinfo 制造知识信息
     * @return 结果
     */
    public int updateMkiinfo(Mkiinfo mkiinfo);

    /**
     * 批量删除制造知识信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMkiinfoByIds(String ids);

    /**
     * 删除制造知识信息信息
     * 
     * @param mkiid 制造知识信息ID
     * @return 结果
     */
    public int deleteMkiinfoById(Long mkiid);

    public List<Mkiinfo> selectMkiinfo();
    //某类型数量
    public List checkKTypeNum();
    //某工艺数量
    public List checkProcessNum();
}
