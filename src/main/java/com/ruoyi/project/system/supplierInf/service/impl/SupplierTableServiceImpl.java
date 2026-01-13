package com.ruoyi.project.system.supplierInf.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.supplierInf.mapper.SupplierTableMapper;
import com.ruoyi.project.system.supplierInf.domain.SupplierTable;
import com.ruoyi.project.system.supplierInf.service.ISupplierTableService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 供应商信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-14
 */
@Service
public class SupplierTableServiceImpl implements ISupplierTableService 
{
    @Autowired
    private SupplierTableMapper supplierTableMapper;

    /**
     * 查询供应商信息
     * 
     * @param id 供应商信息ID
     * @return 供应商信息
     */
    @Override
    public SupplierTable selectSupplierTableById(Long id)
    {
        return supplierTableMapper.selectSupplierTableById(id);
    }

    /**
     * 查询供应商信息列表
     * 
     * @param supplierTable 供应商信息
     * @return 供应商信息
     */
    @Override
    public List<SupplierTable> selectSupplierTableList(SupplierTable supplierTable)
    {
        return supplierTableMapper.selectSupplierTableList(supplierTable);
    }

    /**
     * 新增供应商信息
     * 
     * @param supplierTable 供应商信息
     * @return 结果
     */
    @Override
    public int insertSupplierTable(SupplierTable supplierTable)
    {
        return supplierTableMapper.insertSupplierTable(supplierTable);
    }

    /**
     * 修改供应商信息
     * 
     * @param supplierTable 供应商信息
     * @return 结果
     */
    @Override
    public int updateSupplierTable(SupplierTable supplierTable)
    {
        return supplierTableMapper.updateSupplierTable(supplierTable);
    }

    /**
     * 删除供应商信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSupplierTableByIds(String ids)
    {
        return supplierTableMapper.deleteSupplierTableByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除供应商信息信息
     * 
     * @param id 供应商信息ID
     * @return 结果
     */
    @Override
    public int deleteSupplierTableById(Long id)
    {
        return supplierTableMapper.deleteSupplierTableById(id);
    }

    @Override
    public String importSupplier(List<SupplierTable> imList, boolean updateSupport, String operName) {

        if (StringUtils.isNull(imList) || imList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SupplierTable im : imList)
        {
            try
            {
                // 验证是否存在这个唯一性字段
                SupplierTable u = supplierTableMapper.selectBySupplierid(im.getSupplierid());
                System.out.println(im.getSupplierid());
                if (StringUtils.isNull(u))
                {

                    this.insertSupplierTable(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、供应商 " + im.getSupplierid() + " 导入成功");
                }
                else if (updateSupport)
                {
                    im.setUpdateBy(operName);
                    this.supplierTableMapper.updateSupplierid(im);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、供应商 " + im.getSupplierid() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、供应商 " + im.getSupplierid() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、供应商 " + im.getSupplierid() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    @Override
    public List getAllSupplierData(){
        return supplierTableMapper.getAllSupplierData();
    }
}
