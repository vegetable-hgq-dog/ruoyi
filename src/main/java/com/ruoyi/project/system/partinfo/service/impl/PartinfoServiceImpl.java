package com.ruoyi.project.system.partinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.partinfo.mapper.PartinfoMapper;
import com.ruoyi.project.system.partinfo.domain.Partinfo;
import com.ruoyi.project.system.partinfo.service.IPartinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 零部件信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class PartinfoServiceImpl implements IPartinfoService 
{
    @Autowired
    private PartinfoMapper partinfoMapper;

    /**
     * 查询零部件信息
     * 
     * @param partid 零部件信息ID
     * @return 零部件信息
     */
    @Override
    public Partinfo selectPartinfoById(Long partid)
    {
        return partinfoMapper.selectPartinfoById(partid);
    }

    /**
     * 查询零部件信息列表
     * 
     * @param partinfo 零部件信息
     * @return 零部件信息
     */
    @Override
    public List<Partinfo> selectPartinfoList(Partinfo partinfo)
    {
        return partinfoMapper.selectPartinfoList(partinfo);
    }

    /**
     * 新增零部件信息
     * 
     * @param partinfo 零部件信息
     * @return 结果
     */
    @Override
    public int insertPartinfo(Partinfo partinfo)
    {
        return partinfoMapper.insertPartinfo(partinfo);
    }

    /**
     * 修改零部件信息
     * 
     * @param partinfo 零部件信息
     * @return 结果
     */
    @Override
    public int updatePartinfo(Partinfo partinfo)
    {
        return partinfoMapper.updatePartinfo(partinfo);
    }

    /**
     * 删除零部件信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePartinfoByIds(String ids)
    {
        return partinfoMapper.deletePartinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除零部件信息信息
     * 
     * @param partid 零部件信息ID
     * @return 结果
     */
    @Override
    public int deletePartinfoById(Long partid)
    {
        return partinfoMapper.deletePartinfoById(partid);
    }

    @Override
    public List<Partinfo> selectPartName(){
        return partinfoMapper.selectPartName();
    }
}
