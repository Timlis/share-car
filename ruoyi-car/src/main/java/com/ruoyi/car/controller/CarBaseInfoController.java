package com.ruoyi.car.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.car.domain.CarBaseInfo;
import com.ruoyi.car.service.ICarBaseInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 基本信息Controller
 * 
 * @author timlis
 * @date 2020-12-02
 */
@RestController
@RequestMapping("/car/carBaseInfo")
public class CarBaseInfoController extends BaseController
{
    @Autowired
    private ICarBaseInfoService carBaseInfoService;

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarBaseInfo carBaseInfo)
    {
        startPage();
        List<CarBaseInfo> list = carBaseInfoService.selectCarBaseInfoList(carBaseInfo);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:export')")
    @Log(title = "基本信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarBaseInfo carBaseInfo)
    {
        List<CarBaseInfo> list = carBaseInfoService.selectCarBaseInfoList(carBaseInfo);
        ExcelUtil<CarBaseInfo> util = new ExcelUtil<CarBaseInfo>(CarBaseInfo.class);
        return util.exportExcel(list, "carBaseInfo");
    }

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carBaseInfoService.selectCarBaseInfoById(id));
    }

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:query')")
    @GetMapping(value = "/getByCarNumber/{carNumber}")
    public AjaxResult getInfoByCarNumber(@PathVariable("carNumber") String carNumber)
    {
        return AjaxResult.success(carBaseInfoService.selectCarBaseInfoByCarNumber(carNumber));
    }

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:replace')")
    @Log(title = "基本信息", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult replace(@RequestBody CarBaseInfo carBaseInfo)
    {
        return toAjax(carBaseInfoService.replaceCarBaseInfo(carBaseInfo));
    }

    @PreAuthorize("@ss.hasPermi('car:carBaseInfo:remove')")
    @Log(title = "基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carBaseInfoService.deleteCarBaseInfoByIds(ids));
    }
}
