package com.ruoyi.project.system.mkiinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mkiinfo.mapper.MkiinfoMapper;
import com.ruoyi.project.system.mkiinfo.domain.Mkiinfo;
import com.ruoyi.project.system.mkiinfo.service.IMkiinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 制造知识信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class MkiinfoServiceImpl implements IMkiinfoService 
{
    @Autowired
    private MkiinfoMapper mkiinfoMapper;

    /**
     * 查询制造知识信息
     * 
     * @param mkiid 制造知识信息ID
     * @return 制造知识信息
     */
    @Override
    public Mkiinfo selectMkiinfoById(Long mkiid)
    {
        return mkiinfoMapper.selectMkiinfoById(mkiid);
    }

    /**
     * 查询制造知识信息列表
     * 
     * @param mkiinfo 制造知识信息
     * @return 制造知识信息
     */
    @Override
    public List<Mkiinfo> selectMkiinfoList(Mkiinfo mkiinfo)
    {
        return mkiinfoMapper.selectMkiinfoList(mkiinfo);
    }

    /**
     * 新增制造知识信息
     * 
     * @param mkiinfo 制造知识信息
     * @return 结果
     */
    @Override
    public int insertMkiinfo(Mkiinfo mkiinfo)
    {
        return mkiinfoMapper.insertMkiinfo(mkiinfo);
    }

    /**
     * 修改制造知识信息
     * 
     * @param mkiinfo 制造知识信息
     * @return 结果
     */
    @Override
    public int updateMkiinfo(Mkiinfo mkiinfo)
    {
        return mkiinfoMapper.updateMkiinfo(mkiinfo);
    }

    /**
     * 删除制造知识信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMkiinfoByIds(String ids)
    {
        return mkiinfoMapper.deleteMkiinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除制造知识信息信息
     * 
     * @param mkiid 制造知识信息ID
     * @return 结果
     */
    @Override
    public int deleteMkiinfoById(Long mkiid)
    {
        return mkiinfoMapper.deleteMkiinfoById(mkiid);
    }

    @Override
    public List<Mkiinfo> selectMkiinfo(){
        return mkiinfoMapper.selectMkiinfo();
    }

    @Override
    public List checkKTypeNum(){
        return mkiinfoMapper.checkKTypeNum();
    };
    @Override
    //某工艺数量
    public List checkProcessNum(){
        return mkiinfoMapper.checkProcessNum();
    };

}
