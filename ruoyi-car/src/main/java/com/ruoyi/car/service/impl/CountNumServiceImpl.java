package com.ruoyi.car.service.impl;

import com.ruoyi.car.domain.*;
import com.ruoyi.car.mapper.CarOrderMapper;
import com.ruoyi.car.mapper.CarPartBaseMapper;
import com.ruoyi.car.mapper.CountNumMapper;
import com.ruoyi.car.service.ICarOrderService;
import com.ruoyi.car.service.ICarPartBaseService;
import com.ruoyi.car.service.ICountNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CountNumServiceImpl implements ICountNumService {

    @Resource
    private CountNumMapper countNumMapper;

    @Autowired
    private ICarPartBaseService carPartBaseService;

    @Autowired
    private ICarOrderService carOrderService;

    @Override
    public CountNums countFirstPageNums() {
        return countNumMapper.countFirstPageNum();
    }

    @Override
    public CountLineNum countLineNums() {
        CountLineNum countLineNum = new CountLineNum();
        List<CarPartBase> carPartBases = carPartBaseService.selectCarPartBaseList(null);
        String[] partName = new String[carPartBases.size()];
        Integer[] inNum = new Integer[carPartBases.size()];
        Integer[] outNum = new Integer[carPartBases.size()];
        for (int i = 0; i < carPartBases.size(); i++) {
            inNum[i] = carOrderService.countInAndOutByPartId(carPartBases.get(i).getId(),0);
            outNum[i] = carOrderService.countInAndOutByPartId(carPartBases.get(i).getId(),1);
            partName[i] = carPartBases.get(i).getName();
        }

        countLineNum.setExpectedData(inNum);
        countLineNum.setActualData(outNum);
        countLineNum.setxData(partName);
        return countLineNum;
    }

    @Override
    public CountPieNums countPieNums() {
        CountPieNums countPieNums = new CountPieNums();
        List<PieValue> pieValueList = countNumMapper.countPieNums();
        PieValue[] pieValues = new PieValue[pieValueList.size()];
        String[] data = new String[pieValueList.size()];
        for (int i = 0; i < pieValueList.size(); i++) {
            data[i] = pieValueList.get(i).getName();
            pieValues[i] = new PieValue(pieValueList.get(i).getValue(),pieValueList.get(i).getName());
        }
        countPieNums.setData(data);
        countPieNums.setPieValues(pieValues);
        return countPieNums;
    }

    @Override
    public BarValue[] countBarNums() {
        List<BarValueSql> barValueSqls = countNumMapper.countBarNums();
        Float[] nums = new Float[7];
        Float[] costs = new Float[7];
        for (int i = 0; i < barValueSqls.size(); i++) {
            nums[i] = Float.valueOf(barValueSqls.get(i).getNum());
            costs[i] = barValueSqls.get(i).getCost();
        }
        return new BarValue[]{new BarValue("订单量",nums),new BarValue("流水",costs)};
    }
}
