package com.ruoyi.project.system.mkiinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.mkiinfo.domain.Mkiinfo;

/**
 * 制造知识信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface MkiinfoMapper 
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
     * 删除制造知识信息
     * 
     * @param mkiid 制造知识信息ID
     * @return 结果
     */
    public int deleteMkiinfoById(Long mkiid);

    /**
     * 批量删除制造知识信息
     * 
     * @param mkiids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMkiinfoByIds(String[] mkiids);

    public List<Mkiinfo> selectMkiinfo();

    public List checkKTypeNum();

    public List checkProcessNum();
}
