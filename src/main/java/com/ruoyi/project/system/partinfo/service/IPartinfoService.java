package com.ruoyi.project.system.partinfo.service;

import java.util.List;
import com.ruoyi.project.system.partinfo.domain.Partinfo;

/**
 * 零部件信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface IPartinfoService 
{
    /**
     * 查询零部件信息
     * 
     * @param partid 零部件信息ID
     * @return 零部件信息
     */
    public Partinfo selectPartinfoById(Long partid);

    /**
     * 查询零部件信息列表
     * 
     * @param partinfo 零部件信息
     * @return 零部件信息集合
     */
    public List<Partinfo> selectPartinfoList(Partinfo partinfo);

    /**
     * 新增零部件信息
     * 
     * @param partinfo 零部件信息
     * @return 结果
     */
    public int insertPartinfo(Partinfo partinfo);

    /**
     * 修改零部件信息
     * 
     * @param partinfo 零部件信息
     * @return 结果
     */
    public int updatePartinfo(Partinfo partinfo);

    /**
     * 批量删除零部件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePartinfoByIds(String ids);

    /**
     * 删除零部件信息信息
     * 
     * @param partid 零部件信息ID
     * @return 结果
     */
    public int deletePartinfoById(Long partid);

    public List<Partinfo> selectPartName();
}
