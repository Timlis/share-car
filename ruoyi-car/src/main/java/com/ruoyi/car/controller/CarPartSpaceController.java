package com.ruoyi.car.controller;

import java.util.List;

import com.ruoyi.car.domain.CarBaseInfo;
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
import com.ruoyi.car.domain.CarPartSpace;
import com.ruoyi.car.service.ICarPartSpaceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 停车位信息Controller
 * 
 * @author timlis
 * @date 2021-01-08
 */
@RestController
@RequestMapping("/car/space")
public class CarPartSpaceController extends BaseController
{
    @Autowired
    private ICarPartSpaceService carPartSpaceService;

    /**
     * 查询停车位信息列表
     */
    @PreAuthorize("@ss.hasPermi('car:space:list')")
    @GetMapping("/listCarByPartId/{partId}")
    public TableDataInfo listCarByPartId(@PathVariable(value = "partId") Long partId)
    {

        List<CarBaseInfo> list = carPartSpaceService.selectCarByPartId(partId);
        return getDataTable(list);
    }


    @PreAuthorize("@ss.hasPermi('car:space:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarPartSpace carPartSpace)
    {
        startPage();
        List<CarPartSpace> list = carPartSpaceService.selectCarPartSpaceList(carPartSpace);
        return getDataTable(list);
    }


    @GetMapping(value = "/listByPart/{partId}")
    public AjaxResult listSpaceById(@PathVariable("partId") Long partId)
    {
        return AjaxResult.success(carPartSpaceService.selectCarPartSpaceByPartId(partId));
    }

    @GetMapping(value = "/getFreeCount/{partId}")
    public Integer getFreeSpaceCount(@PathVariable("partId") Long partId){
        return carPartSpaceService.getFreeSpaceCount(partId);
    }

    @PreAuthorize("@ss.hasPermi('car:space:replace')")
    @Log(title = "停车位信息", businessType = BusinessType.REPLACE)
    @PostMapping
    public AjaxResult replace(@RequestBody CarPartSpace carPartSpace)
    {
        return toAjax(carPartSpaceService.replaceCarPartSpace(carPartSpace));
    }

}
