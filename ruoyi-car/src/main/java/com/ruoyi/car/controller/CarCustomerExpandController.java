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
import com.ruoyi.car.domain.CarCustomerExpand;
import com.ruoyi.car.service.ICarCustomerExpandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户扩展信息Controller
 * 
 * @author timlis
 * @date 2020-11-28
 */
@RestController
@RequestMapping("/car/customerExpand")
public class CarCustomerExpandController extends BaseController
{
    @Autowired
    private ICarCustomerExpandService carCustomerExpandService;

    @PreAuthorize("@ss.hasPermi('car:customerExpand:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarCustomerExpand carCustomerExpand)
    {
        startPage();
        List<CarCustomerExpand> list = carCustomerExpandService.selectCarCustomerExpandList(carCustomerExpand);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('car:customerExpand:export')")
    @Log(title = "用户扩展信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarCustomerExpand carCustomerExpand)
    {
        List<CarCustomerExpand> list = carCustomerExpandService.selectCarCustomerExpandList(carCustomerExpand);
        ExcelUtil<CarCustomerExpand> util = new ExcelUtil<CarCustomerExpand>(CarCustomerExpand.class);
        return util.exportExcel(list, "customerExpand");
    }

    @PreAuthorize("@ss.hasPermi('car:customerExpand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carCustomerExpandService.selectCarCustomerExpandById(id));
    }

    @PreAuthorize("@ss.hasPermi('car:customerExpand:replace')")
    @Log(title = "用户扩展信息", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult add(@RequestBody CarCustomerExpand carCustomerExpand)
    {
        return toAjax(carCustomerExpandService.replaceCarCustomerExpand(carCustomerExpand));
    }

    @PreAuthorize("@ss.hasPermi('car:customerExpand:remove')")
    @Log(title = "用户扩展信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carCustomerExpandService.deleteCarCustomerExpandByIds(ids));
    }
}
