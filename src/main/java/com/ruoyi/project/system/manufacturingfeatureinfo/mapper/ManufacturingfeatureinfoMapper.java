package com.ruoyi.project.system.manufacturingfeatureinfo.mapper;

import java.util.List;
import com.ruoyi.project.system.manufacturingfeatureinfo.domain.Manufacturingfeatureinfo;

/**
 * 制造特征Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-03
 */
public interface ManufacturingfeatureinfoMapper 
{
    /**
     * 查询制造特征
     * 
     * @param manufacturingfeatureid 制造特征ID
     * @return 制造特征
     */
    public Manufacturingfeatureinfo selectManufacturingfeatureinfoById(Long manufacturingfeatureid);

    /**
     * 查询制造特征列表
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 制造特征集合
     */
    public List<Manufacturingfeatureinfo> selectManufacturingfeatureinfoList(Manufacturingfeatureinfo manufacturingfeatureinfo);

    /**
     * 新增制造特征
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 结果
     */
    public int insertManufacturingfeatureinfo(Manufacturingfeatureinfo manufacturingfeatureinfo);

    /**
     * 修改制造特征
     * 
     * @param manufacturingfeatureinfo 制造特征
     * @return 结果
     */
    public int updateManufacturingfeatureinfo(Manufacturingfeatureinfo manufacturingfeatureinfo);

    /**
     * 删除制造特征
     * 
     * @param manufacturingfeatureid 制造特征ID
     * @return 结果
     */
    public int deleteManufacturingfeatureinfoById(Long manufacturingfeatureid);

    /**
     * 批量删除制造特征
     * 
     * @param manufacturingfeatureids 需要删除的数据ID
     * @return 结果
     */
    public int deleteManufacturingfeatureinfoByIds(String[] manufacturingfeatureids);

    public List<Manufacturingfeatureinfo> selectManufacturingfeatureName();
}
