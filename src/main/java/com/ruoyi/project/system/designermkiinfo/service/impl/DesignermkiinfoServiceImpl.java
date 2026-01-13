package com.ruoyi.project.system.designermkiinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.designermkiinfo.mapper.DesignermkiinfoMapper;
import com.ruoyi.project.system.designermkiinfo.domain.Designermkiinfo;
import com.ruoyi.project.system.designermkiinfo.service.IDesignermkiinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 研发人员知识交互信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class DesignermkiinfoServiceImpl implements IDesignermkiinfoService 
{
    @Autowired
    private DesignermkiinfoMapper designermkiinfoMapper;

    /**
     * 查询研发人员知识交互信息
     * 
     * @param mkiid 研发人员知识交互信息ID
     * @return 研发人员知识交互信息
     */
    @Override
    public Designermkiinfo selectDesignermkiinfoById(Long mkiid)
    {
        return designermkiinfoMapper.selectDesignermkiinfoById(mkiid);
    }

    /**
     * 查询研发人员知识交互信息列表
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 研发人员知识交互信息
     */
    @Override
    public List<Designermkiinfo> selectDesignermkiinfoList(Designermkiinfo designermkiinfo)
    {
        return designermkiinfoMapper.selectDesignermkiinfoList(designermkiinfo);
    }

    /**
     * 新增研发人员知识交互信息
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 结果
     */
    @Override
    public int insertDesignermkiinfo(Designermkiinfo designermkiinfo)
    {
        return designermkiinfoMapper.insertDesignermkiinfo(designermkiinfo);
    }

    /**
     * 修改研发人员知识交互信息
     * 
     * @param designermkiinfo 研发人员知识交互信息
     * @return 结果
     */
    @Override
    public int updateDesignermkiinfo(Designermkiinfo designermkiinfo)
    {
        return designermkiinfoMapper.updateDesignermkiinfo(designermkiinfo);
    }

    /**
     * 删除研发人员知识交互信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDesignermkiinfoByIds(String ids)
    {
        return designermkiinfoMapper.deleteDesignermkiinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除研发人员知识交互信息信息
     * 
     * @param mkiid 研发人员知识交互信息ID
     * @return 结果
     */
    @Override
    public int deleteDesignermkiinfoById(Long mkiid)
    {
        return designermkiinfoMapper.deleteDesignermkiinfoById(mkiid);
    }

    @Override
    public List<Designermkiinfo> selectDesignermkiinfo(){
        return designermkiinfoMapper.selectDesignermkiinfo();
    }
}
