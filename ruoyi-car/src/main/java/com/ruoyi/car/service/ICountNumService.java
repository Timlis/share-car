package com.ruoyi.car.service;

import com.ruoyi.car.domain.*;

/**
 * @author timlis
 * @date 2021/02/18
 */
public interface ICountNumService {
    CountNums countFirstPageNums();

    CountLineNum countLineNums();

    CountPieNums countPieNums();

    BarValue[] countBarNums();
}
