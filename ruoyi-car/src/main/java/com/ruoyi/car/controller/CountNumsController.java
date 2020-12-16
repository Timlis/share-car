package com.ruoyi.car.controller;

import com.ruoyi.car.domain.CountNums;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用来统计一些报表的Controller
 */
@RestController
@RequestMapping("/car/count")
public class CountNumsController {

    @GetMapping("/indexNums")
    public AjaxResult countIndexNums(){
        return AjaxResult.success(new CountNums(12300,23400,34560,7541));
    }
}
