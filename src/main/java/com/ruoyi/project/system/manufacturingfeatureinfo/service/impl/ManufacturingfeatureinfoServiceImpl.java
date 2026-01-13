package com.ruoyi.project.system.manufacturingfeatureinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.manufacturingfeatureinfo.mapper.ManufacturingfeatureinfoMapper;
import com.ruoyi.project.system.manufacturingfeatureinfo.domain.Manufacturingfeatureinfo;
import com.ruoyi.project.system.manufacturingfeatureinfo.service.IManufacturingfeatureinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 制造特征Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class ManufacturingfeatureinfoServiceImpl implements IManufacturingfeatureinfoService 
{
    @Autowired
    private ManufacturingfeatureinfoMapper manufacturingfeatureinfoMapper;

    /**
     * 查询制造特征
     * 
     * @param manufacturingfeatureid 制造特征ID
     * @return 制造特征
     */
    @Override
    public Manufacturingfeatureinfo selectManufacturingfeatureinfoById(Long manufacturingfeatureid)
    {
        return manufacturingfeatureinfoMapper.selectManufacturingfeatureinfoById(manufacturingfeatureid);
    }

    /**
     * 查询制造特征列表
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 制造特征
     */
    @Override
    public List<Manufacturingfeatureinfo> selectManufacturingfeatureinfoList(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        return manufacturingfeatureinfoMapper.selectManufacturingfeatureinfoList(manufacturingfeatureinfo);
    }

    /**
     * 新增制造特征
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 结果
     */
    @Override
    public int insertManufacturingfeatureinfo(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        return manufacturingfeatureinfoMapper.insertManufacturingfeatureinfo(manufacturingfeatureinfo);
    }

    /**
     * 修改制造特征
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 结果
     */
    @Override
    public int updateManufacturingfeatureinfo(Manufacturingfeatureinfo manufacturingfeatureinfo)
    {
        return manufacturingfeatureinfoMapper.updateManufacturingfeatureinfo(manufacturingfeatureinfo);
    }

    /**
     * 删除制造特征对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteManufacturingfeatureinfoByIds(String ids)
    {
        return manufacturingfeatureinfoMapper.deleteManufacturingfeatureinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除制造特征信息
     * 
     * @param manufacturingfeatureid 制造特征ID
     * @return 结果
     */
    @Override
    public int deleteManufacturingfeatureinfoById(Long manufacturingfeatureid)
    {
        return manufacturingfeatureinfoMapper.deleteManufacturingfeatureinfoById(manufacturingfeatureid);
    }

    @Override
    public List<Manufacturingfeatureinfo> selectManufacturingfeatureName(){
        return manufacturingfeatureinfoMapper.selectManufacturingfeatureName();
    }
}
