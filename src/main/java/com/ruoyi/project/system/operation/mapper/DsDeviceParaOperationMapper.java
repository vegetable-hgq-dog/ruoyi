package com.ruoyi.project.system.operation.mapper;

import java.util.List;
import com.ruoyi.project.system.operation.domain.DsDeviceParaOperation;

/**
 * 实时状态Mapper接口
 * 
 * @author ruoyi
 * @date 2022-05-20
 */
public interface DsDeviceParaOperationMapper 
{
    /**
     * 查询实时状态
     * 
     * @param id 实时状态ID
     * @return 实时状态
     */
    public DsDeviceParaOperation selectDsDeviceParaOperationById(Long id);

    /**
     * 查询实时状态列表
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 实时状态集合
     */
    public List<DsDeviceParaOperation> selectDsDeviceParaOperationList(DsDeviceParaOperation dsDeviceParaOperation);

    /**
     * 新增实时状态
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 结果
     */
    public int insertDsDeviceParaOperation(DsDeviceParaOperation dsDeviceParaOperation);

    /**
     * 修改实时状态
     * 
     * @param dsDeviceParaOperation 实时状态
     * @return 结果
     */
    public int updateDsDeviceParaOperation(DsDeviceParaOperation dsDeviceParaOperation);

    /**
     * 删除实时状态
     * 
     * @param id 实时状态ID
     * @return 结果
     */
    public int deleteDsDeviceParaOperationById(Long id);

    /**
     * 批量删除实时状态
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDsDeviceParaOperationByIds(String[] ids);
}
