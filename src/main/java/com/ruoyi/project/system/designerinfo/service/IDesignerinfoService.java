package com.ruoyi.project.system.designerinfo.service;

import java.util.List;
import com.ruoyi.project.system.designerinfo.domain.Designerinfo;

/**
 * 研发人员信息Service接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface IDesignerinfoService 
{
    /**
     * 查询研发人员信息
     * 
     * @param designerid 研发人员信息ID
     * @return 研发人员信息
     */
    public Designerinfo selectDesignerinfoById(Long designerid);

    /**
     * 查询研发人员信息列表
     * 
     * @param designerinfo 研发人员信息
     * @return 研发人员信息集合
     */
    public List<Designerinfo> selectDesignerinfoList(Designerinfo designerinfo);

    /**
     * 新增研发人员信息
     * 
     * @param designerinfo 研发人员信息
     * @return 结果
     */
    public int insertDesignerinfo(Designerinfo designerinfo);

    /**
     * 修改研发人员信息
     * 
     * @param designerinfo 研发人员信息
     * @return 结果
     */
    public int updateDesignerinfo(Designerinfo designerinfo);

    /**
     * 批量删除研发人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDesignerinfoByIds(String ids);

    /**
     * 删除研发人员信息信息
     * 
     * @param designerid 研发人员信息ID
     * @return 结果
     */
    public int deleteDesignerinfoById(Long designerid);

    public List<Designerinfo> selectDesignerinfo();
}
