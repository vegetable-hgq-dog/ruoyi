package com.ruoyi.project.system.shapefeatureinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.shapefeatureinfo.domain.Shapefeatureinfo;

/**
 * 设计特征信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface ShapefeatureinfoMapper 
{
    /**
     * 查询设计特征信息
     * 
     * @param shapefeatureid 设计特征信息ID
     * @return 设计特征信息
     */
    public Shapefeatureinfo selectShapefeatureinfoById(Long shapefeatureid);

    /**
     * 查询设计特征信息列表
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 设计特征信息集合
     */
    public List<Shapefeatureinfo> selectShapefeatureinfoList(Shapefeatureinfo shapefeatureinfo);

    /**
     * 新增设计特征信息
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 结果
     */
    public int insertShapefeatureinfo(Shapefeatureinfo shapefeatureinfo);

    /**
     * 修改设计特征信息
     * 
     * @param shapefeatureinfo 设计特征信息
     * @return 结果
     */
    public int updateShapefeatureinfo(Shapefeatureinfo shapefeatureinfo);

    /**
     * 删除设计特征信息
     * 
     * @param shapefeatureid 设计特征信息ID
     * @return 结果
     */
    public int deleteShapefeatureinfoById(Long shapefeatureid);

    /**
     * 批量删除设计特征信息
     * 
     * @param shapefeatureids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShapefeatureinfoByIds(String[] shapefeatureids);

    public List<Shapefeatureinfo> selectShapefeatureName();
}
