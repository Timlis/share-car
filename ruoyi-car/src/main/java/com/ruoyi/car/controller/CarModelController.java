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
import com.ruoyi.car.domain.CarModel;
import com.ruoyi.car.service.ICarModelService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 车型管理Controller
 * 
 * @author timlis
 * @date 2020-12-02
 */
@RestController
@RequestMapping("/car/model")
public class CarModelController extends BaseController
{
    @Autowired
    private ICarModelService carModelService;

    /**
     * 查询车型管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:model:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarModel carModel)
    {
        startPage();
        List<CarModel> list = carModelService.selectCarModelList(carModel);
        return getDataTable(list);
    }

    /**
     * 根据品牌Id查询车型管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:model:list')")
    @GetMapping("/listByBrandId/{brandId}")
    public TableDataInfo listByBrandId(@PathVariable("brandId") Long brandId)
    {
        startPage();
        List<CarModel> list = carModelService.selectCarModelListByBrandId(brandId);
        return getDataTable(list);
    }

    /**
     * 导出车型管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:model:export')")
    @Log(title = "车型管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarModel carModel)
    {
        List<CarModel> list = carModelService.selectCarModelList(carModel);
        ExcelUtil<CarModel> util = new ExcelUtil<CarModel>(CarModel.class);
        return util.exportExcel(list, "model");
    }

    /**
     * 获取车型管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:model:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carModelService.selectCarModelById(id));
    }

    /**
     * 新增车型管理
     */
    @PreAuthorize("@ss.hasPermi('car:model:add')")
    @Log(title = "车型管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarModel carModel)
    {
        return toAjax(carModelService.insertCarModel(carModel));
    }

    /**
     * 修改车型管理
     */
    @PreAuthorize("@ss.hasPermi('car:model:edit')")
    @Log(title = "车型管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarModel carModel)
    {
        return toAjax(carModelService.updateCarModel(carModel));
    }

    /**
     * 删除车型管理
     */
    @PreAuthorize("@ss.hasPermi('car:model:remove')")
    @Log(title = "车型管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carModelService.deleteCarModelByIds(ids));
    }
}
