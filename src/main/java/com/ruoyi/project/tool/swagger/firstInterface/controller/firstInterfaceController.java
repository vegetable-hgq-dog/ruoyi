package com.ruoyi.project.tool.swagger.firstInterface.controller;


import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.system.carrierInf.domain.CarriersTable;
import com.ruoyi.project.system.carrierInf.service.impl.CarriersTableServiceImpl;
import com.ruoyi.project.system.distributeStaffInf.service.impl.DistributestaffsTableServiceImpl;
import com.ruoyi.project.system.orderInf.domain.OrderTable;
import com.ruoyi.project.system.orderInf.service.impl.OrderTableServiceImpl;
import com.ruoyi.project.tool.swagger.firstInterface.domain.OrderDomain;
import com.ruoyi.project.tool.swagger.firstInterface.domain.distributestaffsDomain;
import com.ruoyi.project.tool.swagger.firstInterface.service.impl.DistributestaffDomain;
import com.ruoyi.project.tool.swagger.firstInterface.service.impl.OrderDomainService;
import io.swagger.annotations.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * swagger 第一个接口测试
 *
 * @author lpc
 */
@Api(value = "第一个接口测试",tags = "接口测试一")
@RestController
@RequestMapping("/first")
public class firstInterfaceController extends BaseController {

    @Autowired
    private OrderTableServiceImpl orderTableService;

    @Autowired
    private DistributestaffDomain distributestaffDomain1;

    @Autowired
    private OrderDomainService orderDomain1;




    @ApiOperation("添加配送人员信息")
//    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name = "carriername", value = "承运商名称", dataType = "String",paramType = "query")
//    }
//    )
    @GetMapping("/addDistributestaff")
    public AjaxResult addOrder(distributestaffsDomain distributestaffsDomain){
        if (StringUtils.isNull(distributestaffsDomain)){
            return error("未填写任何信息");
        }else if (StringUtils.isNull(distributestaffsDomain.getCarriername())){
            return error("承运商名称不能为空");
        }
//        else if (!StringUtils.isNull(distributestaffsDomain.getCarriername())){
//            List<OrderTable> orderList = orderTableService.getData();
//            String mess = "承运商名称只能为:";
//            for (int i = 0;i < orderList.size();i++){
//                mess += orderList.get(i).getOrderid() + "/";
//            }
//            return error(mess);
//        }
        else if (StringUtils.isNull(distributestaffsDomain.getTelephone())){
            return error("联系电话不能为空");
        }else if (StringUtils.isNull(distributestaffsDomain.getDrivername())){
            return error("司机姓名不能为空");
        }else {

//            System.out.println(distributestaffDomain1.insertDistributestaffsDomain(distributestaffsDomain));
            return AjaxResult.success(distributestaffsDomain);
        }
    }

    @ApiOperation("获取order列表")
    @GetMapping("/orderList")
    public AjaxResult orderList()
    {
        List<OrderTable> orderList = orderTableService.getData();
        return AjaxResult.success(orderList);
    }

    @ApiOperation("获取某一订单信息")
    @ApiImplicitParam(name = "deliverydate", value = "交货时间", required = true, dataType = "Date", paramType = "path",example = "2022-05-11")
    @GetMapping("/{deliverydate}")
    public AjaxResult getOrder(@PathVariable Date deliverydate){
        List<OrderTable> orderList = orderTableService.getData();
        if (!orderList.isEmpty())
        {
            for (int i = 0;i < orderList.size();i++){
                if (orderList.get(i).getDeliverydate().equals(deliverydate)){
                    return AjaxResult.success(orderList.get(i));
                }
            }
            return  error("订单deliverydate不存在");
        }
        else
        {
            return error("订单编号不存在");
        }
    }

    @ApiOperation("删除配送人员信息")
    @ApiImplicitParam(name = "carriername", value = "承运商名称", dataType = "String",paramType = "query",required = true)
    @DeleteMapping("/deleteDistributestaff")
    public AjaxResult deleteStaff(distributestaffsDomain distributestaffsDomain){
        //注：还应该判断三种属性存在，否则删除操作多余的
        if (StringUtils.isNull(distributestaffsDomain)){
            return error("未填写任何信息");
        }else if (StringUtils.isNull(distributestaffsDomain.getCarriername())){
            return error("承运商名称不能为空");
        }else if (StringUtils.isNull(distributestaffsDomain.getTelephone())){
            return error("联系电话不能为空");
        }else if (StringUtils.isNull(distributestaffsDomain.getDrivername())){
            return error("司机姓名不能为空");
        }else {
//            distributestaffDomain1.deleteCarriersDomainByCondition(distributestaffsDomain);
            return AjaxResult.success("删除成功！");
        }
    }

    @ApiOperation("添加订单信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "ordertype", value = "订单类型（1：PO单）", dataType = "String", paramType = "query", required = true,allowableValues = "1"),
            @ApiImplicitParam(name = "settlementstatus", value = "结算状态（1：已结算；2：未结算）", dataType = "String", paramType = "query", required = true,allowableValues = "1,2"),
            @ApiImplicitParam(name = "deliverydate", value = "交货时间", dataType = "Date", paramType = "query", required = true,example = "2020-05-05 12:02:02")
    }
            )
    @PostMapping("/addOrderInfo")
    public AjaxResult addOrderInfo(OrderDomain orderDomain){
        if (StringUtils.isNull(orderDomain)){
            return error("未填写任何信息");
        }else if (StringUtils.isNull(orderDomain.getFactoryid())){
            return error("工厂编号不能为空");
        }
        else if (StringUtils.isNull(orderDomain.getMaterialid())){
            return error("物料编号不能为空");
        }else if (StringUtils.isNull(orderDomain.getSupplierid())){
            return error("供应商编号不能为空");
        }else if (StringUtils.isNull(orderDomain.getSettlementstatus())){
            return error("结算状态不能为空");
        }else if (StringUtils.isNull(orderDomain.getOrderdeliverystate())){
            return error("下发状态不能为空");
        }else if (StringUtils.isNull(orderDomain.getDeliverydate())){
            return error("交货时间不能为空");
        }else if (StringUtils.isNull(orderDomain.getDateofordermake())){
            return error("创建时间不能为空");
        }else if (StringUtils.isNull(orderDomain.getLeftuseamount())){
            return error("剩余数量不能为空");
        }else if (StringUtils.isNull(orderDomain.getHasusedamount())){
            return error("已用数量不能为空");
        }else if (StringUtils.isNull(orderDomain.getPlanuseamount())){
            return error("计划数量不能为空");
        }else if (StringUtils.isNull(orderDomain.getOrdertype())){
            return error("订单类型不能为空");
        }else if (StringUtils.isNull(orderDomain.getOrderid())){
            return error("订单编号不能为空");
        }else {

//            System.out.println(orderDomain1.insertOrderDomain(orderDomain));
            return AjaxResult.success(orderDomain);
        }
    }

}
