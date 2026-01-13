package com.ruoyi.project.system.ktypeinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.ktypeinfo.mapper.KtypeinfoMapper;
import com.ruoyi.project.system.ktypeinfo.domain.Ktypeinfo;
import com.ruoyi.project.system.ktypeinfo.service.IKtypeinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 知识类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class KtypeinfoServiceImpl implements IKtypeinfoService 
{
    @Autowired
    private KtypeinfoMapper ktypeinfoMapper;

    /**
     * 查询知识类型
     * 
     * @param ktypeid 知识类型ID
     * @return 知识类型
     */
    @Override
    public Ktypeinfo selectKtypeinfoById(Long ktypeid)
    {
        return ktypeinfoMapper.selectKtypeinfoById(ktypeid);
    }

    /**
     * 查询知识类型列表
     * 
     * @param ktypeinfo 知识类型
     * @return 知识类型
     */
    @Override
    public List<Ktypeinfo> selectKtypeinfoList(Ktypeinfo ktypeinfo)
    {
        return ktypeinfoMapper.selectKtypeinfoList(ktypeinfo);
    }

    /**
     * 新增知识类型
     * 
     * @param ktypeinfo 知识类型
     * @return 结果
     */
    @Override
    public int insertKtypeinfo(Ktypeinfo ktypeinfo)
    {
        return ktypeinfoMapper.insertKtypeinfo(ktypeinfo);
    }

    /**
     * 修改知识类型
     * 
     * @param ktypeinfo 知识类型
     * @return 结果
     */
    @Override
    public int updateKtypeinfo(Ktypeinfo ktypeinfo)
    {
        return ktypeinfoMapper.updateKtypeinfo(ktypeinfo);
    }

    /**
     * 删除知识类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteKtypeinfoByIds(String ids)
    {
        return ktypeinfoMapper.deleteKtypeinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除知识类型信息
     * 
     * @param ktypeid 知识类型ID
     * @return 结果
     */
    @Override
    public int deleteKtypeinfoById(Long ktypeid)
    {
        return ktypeinfoMapper.deleteKtypeinfoById(ktypeid);
    }

    @Override
    public List<Ktypeinfo> selectKTypeName(){
        return ktypeinfoMapper.selectKTypeName();
    }
}
