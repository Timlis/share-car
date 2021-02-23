package com.ruoyi.car.mapper;

import com.ruoyi.car.domain.BarValueSql;
import com.ruoyi.car.domain.CountNums;
import com.ruoyi.car.domain.PieValue;

import java.util.List;

public interface CountNumMapper {
    CountNums countFirstPageNum();
    List<PieValue> countPieNums();
    List<BarValueSql> countBarNums();
}
