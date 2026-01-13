package com.ruoyi.project.tool.swagger.firstInterface.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体")
public class distributestaffsDomain {

    @ApiModelProperty("承运商名称")
    private String carriername;

    @ApiModelProperty("联系电话")
    private String telephone;

    @ApiModelProperty("司机姓名")
    private String drivername;

    public distributestaffsDomain() {
    }

    public distributestaffsDomain(String carriername, String telephone, String drivername) {
        this.carriername = carriername;
        this.telephone = telephone;
        this.drivername = drivername;
    }

    public String getCarriername() {
        return carriername;
    }

    public void setCarriername(String carriername) {
        this.carriername = carriername;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }
}
