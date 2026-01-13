package com.ruoyi.project.system.designerinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.designerinfo.mapper.DesignerinfoMapper;
import com.ruoyi.project.system.designerinfo.domain.Designerinfo;
import com.ruoyi.project.system.designerinfo.service.IDesignerinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 研发人员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class DesignerinfoServiceImpl implements IDesignerinfoService 
{
    @Autowired
    private DesignerinfoMapper designerinfoMapper;

    /**
     * 查询研发人员信息
     * 
     * @param designerid 研发人员信息ID
     * @return 研发人员信息
     */
    @Override
    public Designerinfo selectDesignerinfoById(Long designerid)
    {
        return designerinfoMapper.selectDesignerinfoById(designerid);
    }

    /**
     * 查询研发人员信息列表
     * 
     * @param designerinfo 研发人员信息
     * @return 研发人员信息
     */
    @Override
    public List<Designerinfo> selectDesignerinfoList(Designerinfo designerinfo)
    {
        return designerinfoMapper.selectDesignerinfoList(designerinfo);
    }

    /**
     * 新增研发人员信息
     * 
     * @param designerinfo 研发人员信息
     * @return 结果
     */
    @Override
    public int insertDesignerinfo(Designerinfo designerinfo)
    {
        return designerinfoMapper.insertDesignerinfo(designerinfo);
    }

    /**
     * 修改研发人员信息
     * 
     * @param designerinfo 研发人员信息
     * @return 结果
     */
    @Override
    public int updateDesignerinfo(Designerinfo designerinfo)
    {
        return designerinfoMapper.updateDesignerinfo(designerinfo);
    }

    /**
     * 删除研发人员信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDesignerinfoByIds(String ids)
    {
        return designerinfoMapper.deleteDesignerinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除研发人员信息信息
     * 
     * @param designerid 研发人员信息ID
     * @return 结果
     */
    @Override
    public int deleteDesignerinfoById(Long designerid)
    {
        return designerinfoMapper.deleteDesignerinfoById(designerid);
    }

    @Override
    public List<Designerinfo> selectDesignerinfo(){
        return designerinfoMapper.selectDesignerinfo();
    }
}
