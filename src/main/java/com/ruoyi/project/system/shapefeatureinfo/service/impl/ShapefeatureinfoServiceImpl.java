package com.ruoyi.project.system.shapefeatureinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.shapefeatureinfo.mapper.ShapefeatureinfoMapper;
import com.ruoyi.project.system.shapefeatureinfo.domain.Shapefeatureinfo;
import com.ruoyi.project.system.shapefeatureinfo.service.IShapefeatureinfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 设计特征信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
@Service
public class ShapefeatureinfoServiceImpl implements IShapefeatureinfoService 
{
    @Autowired
    private ShapefeatureinfoMapper shapefeatureinfoMapper;

    /**
     * 查询设计特征信息
     * 
     * @param shapefeatureid 设计特征信息ID
     * @return 设计特征信息
     */
    @Override
    public Shapefeatureinfo selectShapefeatureinfoById(Long shapefeatureid)
    {
        return shapefeatureinfoMapper.selectShapefeatureinfoById(shapefeatureid);
    }

    /**
     * 查询设计特征信息列表
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 设计特征信息
     */
    @Override
    public List<Shapefeatureinfo> selectShapefeatureinfoList(Shapefeatureinfo shapefeatureinfo)
    {
        return shapefeatureinfoMapper.selectShapefeatureinfoList(shapefeatureinfo);
    }

    /**
     * 新增设计特征信息
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 结果
     */
    @Override
    public int insertShapefeatureinfo(Shapefeatureinfo shapefeatureinfo)
    {
        return shapefeatureinfoMapper.insertShapefeatureinfo(shapefeatureinfo);
    }

    /**
     * 修改设计特征信息
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 结果
     */
    @Override
    public int updateShapefeatureinfo(Shapefeatureinfo shapefeatureinfo)
    {
        return shapefeatureinfoMapper.updateShapefeatureinfo(shapefeatureinfo);
    }

    /**
     * 删除设计特征信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteShapefeatureinfoByIds(String ids)
    {
        return shapefeatureinfoMapper.deleteShapefeatureinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设计特征信息信息
     * 
     * @param shapefeatureid 设计特征信息ID
     * @return 结果
     */
    @Override
    public int deleteShapefeatureinfoById(Long shapefeatureid)
    {
        return shapefeatureinfoMapper.deleteShapefeatureinfoById(shapefeatureid);
    }

    @Override
    public List<Shapefeatureinfo> selectShapefeatureName(){
        return shapefeatureinfoMapper.selectShapefeatureName();
    }
}
