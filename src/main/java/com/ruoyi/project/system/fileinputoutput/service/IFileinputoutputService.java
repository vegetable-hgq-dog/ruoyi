package com.ruoyi.project.system.fileinputoutput.service;

import java.util.List;
import com.ruoyi.project.system.fileinputoutput.domain.Fileinputoutput;

/**
 * 文件导入导出测试Service接口
 * 
 * @author ruoyi
 * @date 2023-02-12
 */
public interface IFileinputoutputService 
{
    /**
     * 查询文件导入导出测试
     * 
     * @param fileid 文件导入导出测试ID
     * @return 文件导入导出测试
     */
    public Fileinputoutput selectFileinputoutputById(Long fileid);

    /**
     * 查询文件导入导出测试列表
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 文件导入导出测试集合
     */
    public List<Fileinputoutput> selectFileinputoutputList(Fileinputoutput fileinputoutput);

    /**
     * 新增文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    public int insertFileinputoutput(Fileinputoutput fileinputoutput);

    /**
     * 修改文件导入导出测试
     * 
     * @param fileinputoutput 文件导入导出测试
     * @return 结果
     */
    public int updateFileinputoutput(Fileinputoutput fileinputoutput);

    /**
     * 批量删除文件导入导出测试
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFileinputoutputByIds(String ids);

    /**
     * 删除文件导入导出测试信息
     * 
     * @param fileid 文件导入导出测试ID
     * @return 结果
     */
    public int deleteFileinputoutputById(Long fileid);
}
