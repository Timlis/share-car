package com.ruoyi.car.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.car.domain.CarOrder;
import com.ruoyi.car.service.ICarOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车辆订单Controller
 * 
 * @author timlis
 * @date 2021-01-29
 */
@RestController
@RequestMapping("/car/order")
public class CarOrderController extends BaseController
{
    @Autowired
    private ICarOrderService carOrderService;

    /**
     * 查询车辆订单列表
     */
    @PreAuthorize("@ss.hasPermi('car:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarOrder carOrder)
    {
        startPage();
        List<CarOrder> list = carOrderService.selectCarOrderList(carOrder);
        return getDataTable(list);
    }

    /**
     * 导出车辆订单列表
     */
    @PreAuthorize("@ss.hasPermi('car:order:export')")
    @Log(title = "车辆订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarOrder carOrder)
    {
        List<CarOrder> list = carOrderService.selectCarOrderList(carOrder);
        ExcelUtil<CarOrder> util = new ExcelUtil<CarOrder>(CarOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取车辆订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:order:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(carOrderService.selectCarOrderById(orderId));
    }

    /**
     * 新增或修改车辆订单
     */
    @PreAuthorize("@ss.hasPermi('car:order:replace')")
    @Log(title = "车辆订单", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult replace(@RequestBody CarOrder carOrder)
    {
        return toAjax(carOrderService.replaceCarOrder(carOrder));
    }

    /**
     * 租车接口
     */
    @PreAuthorize("@ss.hasPermi('car:order:replace')")
    @Log(title = "租车接口", businessType = BusinessType.REPLACE)
    @PostMapping("/rentCar")
    public AjaxResult rentCar(@RequestBody CarOrder carOrder)
    {
        return toAjax(carOrderService.rentCar(carOrder));
    }

    /**
     * 还车接口
     */
    @PreAuthorize("@ss.hasPermi('car:order:replace')")
    @Log(title = "还车接口", businessType = BusinessType.REPLACE)
    @PostMapping("/returnCar")
    public AjaxResult returnCar(@RequestBody CarOrder carOrder)
    {
        return toAjax(carOrderService.returnCar(carOrder));
    }

    /**
     * 删除车辆订单
     */
    @PreAuthorize("@ss.hasPermi('car:order:remove')")
    @Log(title = "车辆订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(carOrderService.deleteCarOrderByIds(orderIds));
    }
}
