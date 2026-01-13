package com.ruoyi.project.system.newdata.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.newdata.mapper.NewdataMapper;
import com.ruoyi.project.system.newdata.domain.Newdata;
import com.ruoyi.project.system.newdata.service.INewdataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 最新数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-25
 */
@Service
public class NewdataServiceImpl implements INewdataService 
{
    @Autowired
    private NewdataMapper newdataMapper;

    /**
     * 查询最新数据
     * 
     * @param id 最新数据ID
     * @return 最新数据
     */
    @Override
    public Newdata selectNewdataById(Long id)
    {
        return newdataMapper.selectNewdataById(id);
    }

    /**
     * 查询最新数据列表
     * 
     * @param newdata 最新数据
     * @return 最新数据
     */
    @Override
    public List<Newdata> selectNewdataList(Newdata newdata)
    {
        return newdataMapper.selectNewdataList(newdata);
    }

    /**
     * 新增最新数据
     * 
     * @param newdata 最新数据
     * @return 结果
     */
    @Override
    public int insertNewdata(Newdata newdata)
    {
        return newdataMapper.insertNewdata(newdata);
    }

    /**
     * 修改最新数据
     * 
     * @param newdata 最新数据
     * @return 结果
     */
    @Override
    public int updateNewdata(Newdata newdata)
    {
        return newdataMapper.updateNewdata(newdata);
    }

    /**
     * 删除最新数据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewdataByIds(String ids)
    {
        return newdataMapper.deleteNewdataByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除最新数据信息
     * 
     * @param id 最新数据ID
     * @return 结果
     */
    @Override
    public int deleteNewdataById(Long id)
    {
        return newdataMapper.deleteNewdataById(id);
    }
}
