package com.ruoyi.project.manufacture.robotinfo.service;

import java.util.List;
import com.ruoyi.project.manufacture.robotinfo.domain.OdsAbbRobotInfoDi;

/**
 * robot_infoService接口
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public interface IOdsAbbRobotInfoDiService 
{
    /**
     * 查询robot_info
     * 
     * @param autoid robot_infoID
     * @return robot_info
     */
    public OdsAbbRobotInfoDi selectOdsAbbRobotInfoDiById(Long autoid);

    /**
     * 查询robot_info列表
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return robot_info集合
     */
    public List<OdsAbbRobotInfoDi> selectOdsAbbRobotInfoDiList(OdsAbbRobotInfoDi odsAbbRobotInfoDi);

    /**
     * 新增robot_info
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return 结果
     */
    public int insertOdsAbbRobotInfoDi(OdsAbbRobotInfoDi odsAbbRobotInfoDi);

    /**
     * 修改robot_info
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return 结果
     */
    public int updateOdsAbbRobotInfoDi(OdsAbbRobotInfoDi odsAbbRobotInfoDi);

    /**
     * 批量删除robot_info
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOdsAbbRobotInfoDiByIds(String ids);

    /**
     * 删除robot_info信息
     * 
     * @param autoid robot_infoID
     * @return 结果
     */
    public int deleteOdsAbbRobotInfoDiById(Long autoid);
}
