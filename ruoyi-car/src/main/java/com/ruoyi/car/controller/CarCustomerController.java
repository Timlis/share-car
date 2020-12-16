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
import com.ruoyi.car.domain.CarCustomer;
import com.ruoyi.car.service.ICarCustomerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户管理Controller
 * 
 * @author Timlis
 * @date 2020-11-24
 */
@RestController
@RequestMapping("/car/customer")
public class CarCustomerController extends BaseController
{
    @Autowired
    private ICarCustomerService carCustomerService;

    /**
     * 查询客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarCustomer carCustomer)
    {
        startPage();
        List<CarCustomer> list = carCustomerService.selectCarCustomerList(carCustomer);
        return getDataTable(list);
    }

    /**
     * 导出客户管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:customer:export')")
    @Log(title = "客户管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarCustomer carCustomer)
    {
        List<CarCustomer> list = carCustomerService.selectCarCustomerList(carCustomer);
        ExcelUtil<CarCustomer> util = new ExcelUtil<CarCustomer>(CarCustomer.class);
        return util.exportExcel(list, "customer");
    }

    /**
     * 获取客户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:customer:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carCustomerService.selectCarCustomerById(id));
    }

    /**
     * 获取客户所有详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:customer:query')")
    @GetMapping(value = "/all/{id}")
    public AjaxResult getAllInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carCustomerService.selectCarCustomerAllById(id));
    }

    /**
     * 新增客户管理
     */
    @PreAuthorize("@ss.hasPermi('car:customer:add')")
    @Log(title = "客户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarCustomer carCustomer)
    {
        return toAjax(carCustomerService.insertCarCustomer(carCustomer));
    }

    /**
     * 修改客户管理
     */
    @PreAuthorize("@ss.hasPermi('car:customer:edit')")
    @Log(title = "客户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarCustomer carCustomer)
    {
        return toAjax(carCustomerService.updateCarCustomer(carCustomer));
    }

    /**
     * 删除客户管理
     */
    @PreAuthorize("@ss.hasPermi('car:customer:remove')")
    @Log(title = "客户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carCustomerService.deleteCarCustomerByIds(ids));
    }
}
