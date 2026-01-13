package com.ruoyi.project.system.mrknowledge.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mrknowledge.mapper.DsMrknowledgeMapper;
import com.ruoyi.project.system.mrknowledge.domain.DsMrknowledge;
import com.ruoyi.project.system.mrknowledge.service.IDsMrknowledgeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 制造需求Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-19
 */
@Service
public class DsMrknowledgeServiceImpl implements IDsMrknowledgeService 
{
    @Autowired
    private DsMrknowledgeMapper dsMrknowledgeMapper;

    /**
     * 查询制造需求
     * 
     * @param mritemid 制造需求ID
     * @return 制造需求
     */
    @Override
    public DsMrknowledge selectDsMrknowledgeById(Long mritemid)
    {
        return dsMrknowledgeMapper.selectDsMrknowledgeById(mritemid);
    }

    /**
     * 查询制造需求列表
     * 
     * @param dsMrknowledge 制造需求
     * @return 制造需求
     */
    @Override
    public List<DsMrknowledge> selectDsMrknowledgeList(DsMrknowledge dsMrknowledge)
    {
        return dsMrknowledgeMapper.selectDsMrknowledgeList(dsMrknowledge);
    }

    /**
     * 新增制造需求
     * 
     * @param dsMrknowledge 制造需求
     * @return 结果
     */
    @Override
    public int insertDsMrknowledge(DsMrknowledge dsMrknowledge)
    {
        return dsMrknowledgeMapper.insertDsMrknowledge(dsMrknowledge);
    }

    /**
     * 修改制造需求
     * 
     * @param dsMrknowledge 制造需求
     * @return 结果
     */
    @Override
    public int updateDsMrknowledge(DsMrknowledge dsMrknowledge)
    {
        return dsMrknowledgeMapper.updateDsMrknowledge(dsMrknowledge);
    }

    /**
     * 删除制造需求对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsMrknowledgeByIds(String ids)
    {
        return dsMrknowledgeMapper.deleteDsMrknowledgeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除制造需求信息
     * 
     * @param mritemid 制造需求ID
     * @return 结果
     */
    @Override
    public int deleteDsMrknowledgeById(Long mritemid)
    {
        return dsMrknowledgeMapper.deleteDsMrknowledgeById(mritemid);
    }
}
