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
import com.ruoyi.car.domain.CarBilling;
import com.ruoyi.car.service.ICarBillingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 计费管理Controller
 * 
 * @author timlis
 * @date 2021-01-29
 */
@RestController
@RequestMapping("/car/billing")
public class CarBillingController extends BaseController
{
    @Autowired
    private ICarBillingService carBillingService;

    /**
     * 查询计费管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:billing:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarBilling carBilling)
    {
        startPage();
        List<CarBilling> list = carBillingService.selectCarBillingList(carBilling);
        return getDataTable(list);
    }

    /**
     * 导出计费管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:billing:export')")
    @Log(title = "计费管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarBilling carBilling)
    {
        List<CarBilling> list = carBillingService.selectCarBillingList(carBilling);
        ExcelUtil<CarBilling> util = new ExcelUtil<CarBilling>(CarBilling.class);
        return util.exportExcel(list, "billing");
    }

    /**
     * 获取计费管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:billing:query')")
    @GetMapping(value = "/{modelId}")
    public AjaxResult getInfo(@PathVariable("modelId") Long modelId)
    {
        return AjaxResult.success(carBillingService.selectCarBillingById(modelId));
    }



    @PreAuthorize("@ss.hasPermi('car:billing:replace')")
    @Log(title = "计费管理", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult replace(@RequestBody CarBilling carBilling)
    {
        return toAjax(carBillingService.replaceCarBilling(carBilling));
    }


    /**
     * 删除计费管理
     */
    @PreAuthorize("@ss.hasPermi('car:billing:remove')")
    @Log(title = "计费管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{modelIds}")
    public AjaxResult remove(@PathVariable Long[] modelIds)
    {
        return toAjax(carBillingService.deleteCarBillingByIds(modelIds));
    }
}
