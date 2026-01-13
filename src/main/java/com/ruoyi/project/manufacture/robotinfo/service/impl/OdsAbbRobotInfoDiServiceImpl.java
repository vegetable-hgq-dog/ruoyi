package com.ruoyi.project.manufacture.robotinfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.manufacture.robotinfo.mapper.OdsAbbRobotInfoDiMapper;
import com.ruoyi.project.manufacture.robotinfo.domain.OdsAbbRobotInfoDi;
import com.ruoyi.project.manufacture.robotinfo.service.IOdsAbbRobotInfoDiService;
import com.ruoyi.common.utils.text.Convert;

/**
 * robot_infoService业务层处理
 * 
 * @author xjtu
 * @date 2023-08-07
 */
@Service
public class OdsAbbRobotInfoDiServiceImpl implements IOdsAbbRobotInfoDiService 
{
    @Autowired
    private OdsAbbRobotInfoDiMapper odsAbbRobotInfoDiMapper;

    /**
     * 查询robot_info
     * 
     * @param autoid robot_infoID
     * @return robot_info
     */
    @Override
    public OdsAbbRobotInfoDi selectOdsAbbRobotInfoDiById(Long autoid)
    {
        return odsAbbRobotInfoDiMapper.selectOdsAbbRobotInfoDiById(autoid);
    }

    /**
     * 查询robot_info列表
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return robot_info
     */
    @Override
    public List<OdsAbbRobotInfoDi> selectOdsAbbRobotInfoDiList(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        return odsAbbRobotInfoDiMapper.selectOdsAbbRobotInfoDiList(odsAbbRobotInfoDi);
    }

    /**
     * 新增robot_info
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return 结果
     */
    @Override
    public int insertOdsAbbRobotInfoDi(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        return odsAbbRobotInfoDiMapper.insertOdsAbbRobotInfoDi(odsAbbRobotInfoDi);
    }

    /**
     * 修改robot_info
     * 
     * @param odsAbbRobotInfoDi robot_info
     * @return 结果
     */
    @Override
    public int updateOdsAbbRobotInfoDi(OdsAbbRobotInfoDi odsAbbRobotInfoDi)
    {
        return odsAbbRobotInfoDiMapper.updateOdsAbbRobotInfoDi(odsAbbRobotInfoDi);
    }

    /**
     * 删除robot_info对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOdsAbbRobotInfoDiByIds(String ids)
    {
        return odsAbbRobotInfoDiMapper.deleteOdsAbbRobotInfoDiByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除robot_info信息
     * 
     * @param autoid robot_infoID
     * @return 结果
     */
    @Override
    public int deleteOdsAbbRobotInfoDiById(Long autoid)
    {
        return odsAbbRobotInfoDiMapper.deleteOdsAbbRobotInfoDiById(autoid);
    }
}
