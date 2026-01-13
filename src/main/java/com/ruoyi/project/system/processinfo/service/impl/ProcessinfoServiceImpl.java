package com.ruoyi.project.system.processinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.processinfo.mapper.ProcessinfoMapper;
import com.ruoyi.project.system.processinfo.domain.Processinfo;
import com.ruoyi.project.system.processinfo.service.IProcessinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工艺信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class ProcessinfoServiceImpl implements IProcessinfoService 
{
    @Autowired
    private ProcessinfoMapper processinfoMapper;

    /**
     * 查询工艺信息
     * 
     * @param processid 工艺信息ID
     * @return 工艺信息
     */
    @Override
    public Processinfo selectProcessinfoById(Long processid)
    {
        return processinfoMapper.selectProcessinfoById(processid);
    }

    /**
     * 查询工艺信息列表
     * 
     * @param processinfo 工艺信息
     * @return 工艺信息
     */
    @Override
    public List<Processinfo> selectProcessinfoList(Processinfo processinfo)
    {
        return processinfoMapper.selectProcessinfoList(processinfo);
    }

    /**
     * 新增工艺信息
     * 
     * @param processinfo 工艺信息
     * @return 结果
     */
    @Override
    public int insertProcessinfo(Processinfo processinfo)
    {
        return processinfoMapper.insertProcessinfo(processinfo);
    }

    /**
     * 修改工艺信息
     * 
     * @param processinfo 工艺信息
     * @return 结果
     */
    @Override
    public int updateProcessinfo(Processinfo processinfo)
    {
        return processinfoMapper.updateProcessinfo(processinfo);
    }

    /**
     * 删除工艺信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProcessinfoByIds(String ids)
    {
        return processinfoMapper.deleteProcessinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工艺信息信息
     * 
     * @param processid 工艺信息ID
     * @return 结果
     */
    @Override
    public int deleteProcessinfoById(Long processid)
    {
        return processinfoMapper.deleteProcessinfoById(processid);
    }

    public List<Processinfo> selectProcessName(){
        return processinfoMapper.selectProcessName();
    }
}
