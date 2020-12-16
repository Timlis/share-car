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
import com.ruoyi.car.domain.CarBrand;
import com.ruoyi.car.service.ICarBrandService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 品牌管理Controller
 * 
 * @author timlis
 * @date 2020-12-01
 */
@RestController
@RequestMapping("/car/brand")
public class CarBrandController extends BaseController
{
    @Autowired
    private ICarBrandService carBrandService;

    /**
     * 查询品牌管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:brand:list')")
    @GetMapping("/list")
    public TableDataInfo list(CarBrand carBrand)
    {
        startPage();
        List<CarBrand> list = carBrandService.selectCarBrandList(carBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌管理列表
     */
    @PreAuthorize("@ss.hasPermi('car:brand:export')")
    @Log(title = "品牌管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CarBrand carBrand)
    {
        List<CarBrand> list = carBrandService.selectCarBrandList(carBrand);
        ExcelUtil<CarBrand> util = new ExcelUtil<CarBrand>(CarBrand.class);
        return util.exportExcel(list, "brand");
    }

    /**
     * 获取品牌管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('car:brand:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(carBrandService.selectCarBrandById(id));
    }

    /**
     * 新增品牌管理
     */
    @PreAuthorize("@ss.hasPermi('car:brand:add')")
    @Log(title = "品牌管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CarBrand carBrand)
    {
        return toAjax(carBrandService.insertCarBrand(carBrand));
    }

    /**
     * 修改品牌管理
     */
    @PreAuthorize("@ss.hasPermi('car:brand:edit')")
    @Log(title = "品牌管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CarBrand carBrand)
    {
        return toAjax(carBrandService.updateCarBrand(carBrand));
    }

    /**
     * 删除品牌管理
     */
    @PreAuthorize("@ss.hasPermi('car:brand:remove')")
    @Log(title = "品牌管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(carBrandService.deleteCarBrandByIds(ids));
    }
}
