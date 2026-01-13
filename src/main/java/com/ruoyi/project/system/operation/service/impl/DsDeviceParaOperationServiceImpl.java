package com.ruoyi.project.system.operation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.operation.mapper.DsDeviceParaOperationMapper;
import com.ruoyi.project.system.operation.domain.DsDeviceParaOperation;
import com.ruoyi.project.system.operation.service.IDsDeviceParaOperationService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 实时状态Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
@Service
public class DsDeviceParaOperationServiceImpl implements IDsDeviceParaOperationService 
{
    @Autowired
    private DsDeviceParaOperationMapper dsDeviceParaOperationMapper;

    /**
     * 查询实时状态
     * 
     * @param id 实时状态ID
     * @return 实时状态
     */
    @Override
    public DsDeviceParaOperation selectDsDeviceParaOperationById(Long id)
    {
        return dsDeviceParaOperationMapper.selectDsDeviceParaOperationById(id);
    }

    /**
     * 查询实时状态列表
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 实时状态
     */
    @Override
    public List<DsDeviceParaOperation> selectDsDeviceParaOperationList(DsDeviceParaOperation dsDeviceParaOperation)
    {
        return dsDeviceParaOperationMapper.selectDsDeviceParaOperationList(dsDeviceParaOperation);
    }

    /**
     * 新增实时状态
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 结果
     */
    @Override
    public int insertDsDeviceParaOperation(DsDeviceParaOperation dsDeviceParaOperation)
    {
        return dsDeviceParaOperationMapper.insertDsDeviceParaOperation(dsDeviceParaOperation);
    }

    /**
     * 修改实时状态
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 结果
     */
    @Override
    public int updateDsDeviceParaOperation(DsDeviceParaOperation dsDeviceParaOperation)
    {
        return dsDeviceParaOperationMapper.updateDsDeviceParaOperation(dsDeviceParaOperation);
    }

    /**
     * 删除实时状态对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDsDeviceParaOperationByIds(String ids)
    {
        return dsDeviceParaOperationMapper.deleteDsDeviceParaOperationByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除实时状态信息
     * 
     * @param id 实时状态ID
     * @return 结果
     */
    @Override
    public int deleteDsDeviceParaOperationById(Long id)
    {
        return dsDeviceParaOperationMapper.deleteDsDeviceParaOperationById(id);
    }
}
