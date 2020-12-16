package com.ruoyi.car.service.impl;

import java.util.List;
import java.util.Optional;

import com.ruoyi.car.domain.CarCustomerExpand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.car.mapper.CarCustomerMapper;
import com.ruoyi.car.domain.CarCustomer;
import com.ruoyi.car.service.ICarCustomerService;

/**
 * 客户管理Service业务层处理
 *
 * @author Timlis
 * @date 2020-11-24
 */
@Service
public class CarCustomerServiceImpl implements ICarCustomerService {
    @Autowired
    private CarCustomerMapper carCustomerMapper;

    /**
     * 查询客户管理
     *
     * @param id 客户管理ID
     * @return 客户管理
     */
    @Override
    public CarCustomer selectCarCustomerById(Long id) {
        return carCustomerMapper.selectCarCustomerById(id);
    }


    /**
     * 查询用户所有信息
     *
     * @param id 客户管理ID
     * @return
     */
    @Override
    public CarCustomerExpand selectCarCustomerAllById(Long id) {
        return  Optional.ofNullable(carCustomerMapper.selectCarCustomerAllById(id)).
                orElseGet(() -> new CarCustomerExpand(carCustomerMapper.selectCarCustomerById(id)));
    }

    /**
     * 查询客户管理列表
     *
     * @param carCustomer 客户管理
     * @return 客户管理
     */
    @Override
    public List<CarCustomer> selectCarCustomerList(CarCustomer carCustomer) {
        return carCustomerMapper.selectCarCustomerList(carCustomer);
    }

    /**
     * 新增客户管理
     *
     * @param carCustomer 客户管理
     * @return 结果
     */
    @Override
    public int insertCarCustomer(CarCustomer carCustomer) {
        return carCustomerMapper.insertCarCustomer(carCustomer);
    }

    /**
     * 修改客户管理
     *
     * @param carCustomer 客户管理
     * @return 结果
     */
    @Override
    public int updateCarCustomer(CarCustomer carCustomer) {
        return carCustomerMapper.updateCarCustomer(carCustomer);
    }

    /**
     * 批量删除客户管理
     *
     * @param ids 需要删除的客户管理ID
     * @return 结果
     */
    @Override
    public int deleteCarCustomerByIds(Long[] ids) {
        return carCustomerMapper.deleteCarCustomerByIds(ids);
    }

    /**
     * 删除客户管理信息
     *
     * @param id 客户管理ID
     * @return 结果
     */
    @Override
    public int deleteCarCustomerById(Long id) {
        return carCustomerMapper.deleteCarCustomerById(id);
    }
}
