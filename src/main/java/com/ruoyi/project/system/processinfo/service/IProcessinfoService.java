package com.ruoyi.project.system.processinfo.service;

import java.util.List;
import com.ruoyi.project.system.processinfo.domain.Processinfo;

/**
 * 工艺信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface IProcessinfoService 
{
    /**
     * 查询工艺信息
     * 
     * @param processid 工艺信息ID
     * @return 工艺信息
     */
    public Processinfo selectProcessinfoById(Long processid);

    /**
     * 查询工艺信息列表
     * 
     * @param processinfo 工艺信息
     * @return 工艺信息集合
     */
    public List<Processinfo> selectProcessinfoList(Processinfo processinfo);

    /**
     * 新增工艺信息
     * 
     * @param processinfo 工艺信息
     * @return 结果
     */
    public int insertProcessinfo(Processinfo processinfo);

    /**
     * 修改工艺信息
     * 
     * @param processinfo 工艺信息
     * @return 结果
     */
    public int updateProcessinfo(Processinfo processinfo);

    /**
     * 批量删除工艺信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProcessinfoByIds(String ids);

    /**
     * 删除工艺信息信息
     * 
     * @param processid 工艺信息ID
     * @return 结果
     */
    public int deleteProcessinfoById(Long processid);

    public List<Processinfo> selectProcessName();
}
