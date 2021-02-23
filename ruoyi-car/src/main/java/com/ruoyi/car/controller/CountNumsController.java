package com.ruoyi.car.controller;

import com.ruoyi.car.domain.BarValue;
import com.ruoyi.car.domain.CountPieNums;
import com.ruoyi.car.domain.CountLineNum;
import com.ruoyi.car.domain.PieValue;
import com.ruoyi.car.service.ICountNumService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来统计一些报表的Controller
 *
 * @author timlis
 * @date 2021/02/18
 */
@RestController
@RequestMapping("/car/count")
public class CountNumsController {

    @Autowired
    private ICountNumService  countNumService;

    @GetMapping("/indexNums")
    public AjaxResult countIndexNums() {
        return AjaxResult.success(countNumService.countFirstPageNums());
    }

    @GetMapping("/lineNums")
    public AjaxResult countLineNums() {
        return AjaxResult.success(countNumService.countLineNums());
    }

    @GetMapping("/pieNums")
    public AjaxResult countPieNums() {
        return AjaxResult.success(countNumService.countPieNums());
    }

    @GetMapping("/barNums")
    public AjaxResult countBarNums() {
        return AjaxResult.success(countNumService.countBarNums());
    }

}
