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
import com.ruoyi.car.domain.CarPartBase;
import com.ruoyi.car.service.ICarPartBaseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 停车场的基本信息Controller
 * 
 * @author timlis
 * @date 2020-12-19
 */
@RestController
@RequestMapping("/car/part")
public class CarPartBaseController extends BaseController
{
    @Autowired
    private ICarPartBaseService carPartBaseService;

    @PreAuthorize("@ss.hasPermi('car:part:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarPartBase carPartBase)
    {
        startPage();
        List<CarPartBase> list = carPartBaseService.selectCarPartBaseList(carPartBase);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public TableDataInfo listAll()
    {
        List<CarPartBase> list = carPartBaseService.selectCarPartBaseList(null);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('car:part:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(carPartBaseService.selectCarPartBaseById(id));
    }

    @PreAuthorize("@ss.hasPermi('car:part:replace')")
    @Log(title = "停车场的基本信息", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult replace(@RequestBody CarPartBase carPartBase)
    {
        return toAjax(carPartBaseService.replaceCarPartBase(carPartBase));
    }

    @PreAuthorize("@ss.hasPermi('car:part:remove')")
    @Log(title = "停车场的基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(carPartBaseService.deleteCarPartBaseByIds(ids));
    }
}
