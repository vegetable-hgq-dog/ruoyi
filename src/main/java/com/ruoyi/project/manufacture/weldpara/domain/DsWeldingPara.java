package com.ruoyi.project.manufacture.weldpara.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * weld_para对象 ds_welding_para
 * 
 * @author xjtu
 * @date 2023-08-07
 */
public class DsWeldingPara extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 保持时间/ms */
    @Excel(name = "保持时间/ms")
    private Long paraBackfireHoldtime;

    /** 回火时间/ms */
    @Excel(name = "回火时间/ms")
    private Long paraBackfireTime;

    /** 回火电流/kA */
    @Excel(name = "回火电流/kA")
    private Long paraBackfireElec;

    /** 脉冲冷却时间/ms */
    @Excel(name = "脉冲冷却时间/ms")
    private Long paraPluseCoolTime;

    /** 脉冲间冷却时间/ms */
    @Excel(name = "脉冲间冷却时间/ms")
    private Long paraPluseBetwCoolTime;

    /** 脉冲次数 */
    @Excel(name = "脉冲次数")
    private Long paraPulseNum;

    /** 焊接时间/ms */
    @Excel(name = "焊接时间/ms")
    private Long paraWeldTime;

    /** 焊接电流/kA */
    @Excel(name = "焊接电流/kA")
    private Long paraWeldElec;

    /** 冷却时间/ms */
    @Excel(name = "冷却时间/ms")
    private Long paraCoolTime;

    /** 预热时间/ms */
    @Excel(name = "预热时间/ms")
    private Long paraPretempTime;

    /** 预热电流/kA */
    @Excel(name = "预热电流/kA")
    private Long paraPretempElec;

    /** 预压时间/ms */
    @Excel(name = "预压时间/ms")
    private Long paraPreloadTime;

    /** 电极压力/kN */
    @Excel(name = "电极压力/kN")
    private Long paraElecPress;

    /** 电极帽规格/mm */
    @Excel(name = "电极帽规格/mm")
    private String paraElecCapType;

    /** 焊接程序号 */
    @Excel(name = "焊接程序号")
    private Long weldProgramid;

    /** 焊枪最大压力/kN */
    @Excel(name = "焊枪最大压力/kN")
    private Long weldGunMaxpress;

    /** 熔核直径/mm */
    @Excel(name = "熔核直径/mm")
    private Long weldDiameter;

    /** 总板厚/mm */
    @Excel(name = "总板厚/mm")
    private Long totalThick;

    /** 焊件3厚度/mm */
    @Excel(name = "焊件3厚度/mm")
    private Long weldThick3;

    /** 焊件3材质 */
    @Excel(name = "焊件3材质")
    private String weldMaterial3;

    /** 焊件2-3涂胶 */
    @Excel(name = "焊件2-3涂胶")
    private String hasWeldGlue2;

    /** 焊件2厚度/mm */
    @Excel(name = "焊件2厚度/mm")
    private Long weldThick2;

    /** 焊件2材质 */
    @Excel(name = "焊件2材质")
    private String weldMaterial2;

    /** 焊件1-2涂胶 */
    @Excel(name = "焊件1-2涂胶")
    private String hasWeldGlue1;

    /** 焊件1厚度/mm */
    @Excel(name = "焊件1厚度/mm")
    private Long weldThick1;

    /** 焊件1材质 */
    @Excel(name = "焊件1材质")
    private String weldMaterial1;

    /** 焊点号 */
    @Excel(name = "焊点号")
    private String weldSpotId;

    /** 焊枪型号 */
    @Excel(name = "焊枪型号")
    private String gunType;

    /** 工位机器人 */
    @Excel(name = "工位机器人")
    private String robotId;

    /** ID */
    private Long autoId;

    public void setParaBackfireHoldtime(Long paraBackfireHoldtime) 
    {
        this.paraBackfireHoldtime = paraBackfireHoldtime;
    }

    public Long getParaBackfireHoldtime() 
    {
        return paraBackfireHoldtime;
    }
    public void setParaBackfireTime(Long paraBackfireTime) 
    {
        this.paraBackfireTime = paraBackfireTime;
    }

    public Long getParaBackfireTime() 
    {
        return paraBackfireTime;
    }
    public void setParaBackfireElec(Long paraBackfireElec) 
    {
        this.paraBackfireElec = paraBackfireElec;
    }

    public Long getParaBackfireElec() 
    {
        return paraBackfireElec;
    }
    public void setParaPluseCoolTime(Long paraPluseCoolTime) 
    {
        this.paraPluseCoolTime = paraPluseCoolTime;
    }

    public Long getParaPluseCoolTime() 
    {
        return paraPluseCoolTime;
    }
    public void setParaPluseBetwCoolTime(Long paraPluseBetwCoolTime) 
    {
        this.paraPluseBetwCoolTime = paraPluseBetwCoolTime;
    }

    public Long getParaPluseBetwCoolTime() 
    {
        return paraPluseBetwCoolTime;
    }
    public void setParaPulseNum(Long paraPulseNum) 
    {
        this.paraPulseNum = paraPulseNum;
    }

    public Long getParaPulseNum() 
    {
        return paraPulseNum;
    }
    public void setParaWeldTime(Long paraWeldTime) 
    {
        this.paraWeldTime = paraWeldTime;
    }

    public Long getParaWeldTime() 
    {
        return paraWeldTime;
    }
    public void setParaWeldElec(Long paraWeldElec) 
    {
        this.paraWeldElec = paraWeldElec;
    }

    public Long getParaWeldElec() 
    {
        return paraWeldElec;
    }
    public void setParaCoolTime(Long paraCoolTime) 
    {
        this.paraCoolTime = paraCoolTime;
    }

    public Long getParaCoolTime() 
    {
        return paraCoolTime;
    }
    public void setParaPretempTime(Long paraPretempTime) 
    {
        this.paraPretempTime = paraPretempTime;
    }

    public Long getParaPretempTime() 
    {
        return paraPretempTime;
    }
    public void setParaPretempElec(Long paraPretempElec) 
    {
        this.paraPretempElec = paraPretempElec;
    }

    public Long getParaPretempElec() 
    {
        return paraPretempElec;
    }
    public void setParaPreloadTime(Long paraPreloadTime) 
    {
        this.paraPreloadTime = paraPreloadTime;
    }

    public Long getParaPreloadTime() 
    {
        return paraPreloadTime;
    }
    public void setParaElecPress(Long paraElecPress) 
    {
        this.paraElecPress = paraElecPress;
    }

    public Long getParaElecPress() 
    {
        return paraElecPress;
    }
    public void setParaElecCapType(String paraElecCapType) 
    {
        this.paraElecCapType = paraElecCapType;
    }

    public String getParaElecCapType() 
    {
        return paraElecCapType;
    }
    public void setWeldProgramid(Long weldProgramid) 
    {
        this.weldProgramid = weldProgramid;
    }

    public Long getWeldProgramid() 
    {
        return weldProgramid;
    }
    public void setWeldGunMaxpress(Long weldGunMaxpress) 
    {
        this.weldGunMaxpress = weldGunMaxpress;
    }

    public Long getWeldGunMaxpress() 
    {
        return weldGunMaxpress;
    }
    public void setWeldDiameter(Long weldDiameter) 
    {
        this.weldDiameter = weldDiameter;
    }

    public Long getWeldDiameter() 
    {
        return weldDiameter;
    }
    public void setTotalThick(Long totalThick) 
    {
        this.totalThick = totalThick;
    }

    public Long getTotalThick() 
    {
        return totalThick;
    }
    public void setWeldThick3(Long weldThick3) 
    {
        this.weldThick3 = weldThick3;
    }

    public Long getWeldThick3() 
    {
        return weldThick3;
    }
    public void setWeldMaterial3(String weldMaterial3) 
    {
        this.weldMaterial3 = weldMaterial3;
    }

    public String getWeldMaterial3() 
    {
        return weldMaterial3;
    }
    public void setHasWeldGlue2(String hasWeldGlue2) 
    {
        this.hasWeldGlue2 = hasWeldGlue2;
    }

    public String getHasWeldGlue2() 
    {
        return hasWeldGlue2;
    }
    public void setWeldThick2(Long weldThick2) 
    {
        this.weldThick2 = weldThick2;
    }

    public Long getWeldThick2() 
    {
        return weldThick2;
    }
    public void setWeldMaterial2(String weldMaterial2) 
    {
        this.weldMaterial2 = weldMaterial2;
    }

    public String getWeldMaterial2() 
    {
        return weldMaterial2;
    }
    public void setHasWeldGlue1(String hasWeldGlue1) 
    {
        this.hasWeldGlue1 = hasWeldGlue1;
    }

    public String getHasWeldGlue1() 
    {
        return hasWeldGlue1;
    }
    public void setWeldThick1(Long weldThick1) 
    {
        this.weldThick1 = weldThick1;
    }

    public Long getWeldThick1() 
    {
        return weldThick1;
    }
    public void setWeldMaterial1(String weldMaterial1) 
    {
        this.weldMaterial1 = weldMaterial1;
    }

    public String getWeldMaterial1() 
    {
        return weldMaterial1;
    }
    public void setWeldSpotId(String weldSpotId) 
    {
        this.weldSpotId = weldSpotId;
    }

    public String getWeldSpotId() 
    {
        return weldSpotId;
    }
    public void setGunType(String gunType) 
    {
        this.gunType = gunType;
    }

    public String getGunType() 
    {
        return gunType;
    }
    public void setRobotId(String robotId) 
    {
        this.robotId = robotId;
    }

    public String getRobotId() 
    {
        return robotId;
    }
    public void setAutoId(Long autoId) 
    {
        this.autoId = autoId;
    }

    public Long getAutoId() 
    {
        return autoId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("paraBackfireHoldtime", getParaBackfireHoldtime())
            .append("paraBackfireTime", getParaBackfireTime())
            .append("paraBackfireElec", getParaBackfireElec())
            .append("paraPluseCoolTime", getParaPluseCoolTime())
            .append("paraPluseBetwCoolTime", getParaPluseBetwCoolTime())
            .append("paraPulseNum", getParaPulseNum())
            .append("paraWeldTime", getParaWeldTime())
            .append("paraWeldElec", getParaWeldElec())
            .append("paraCoolTime", getParaCoolTime())
            .append("paraPretempTime", getParaPretempTime())
            .append("paraPretempElec", getParaPretempElec())
            .append("paraPreloadTime", getParaPreloadTime())
            .append("paraElecPress", getParaElecPress())
            .append("paraElecCapType", getParaElecCapType())
            .append("weldProgramid", getWeldProgramid())
            .append("weldGunMaxpress", getWeldGunMaxpress())
            .append("weldDiameter", getWeldDiameter())
            .append("totalThick", getTotalThick())
            .append("weldThick3", getWeldThick3())
            .append("weldMaterial3", getWeldMaterial3())
            .append("hasWeldGlue2", getHasWeldGlue2())
            .append("weldThick2", getWeldThick2())
            .append("weldMaterial2", getWeldMaterial2())
            .append("hasWeldGlue1", getHasWeldGlue1())
            .append("weldThick1", getWeldThick1())
            .append("weldMaterial1", getWeldMaterial1())
            .append("weldSpotId", getWeldSpotId())
            .append("gunType", getGunType())
            .append("robotId", getRobotId())
            .append("autoId", getAutoId())
            .toString();
    }
}
