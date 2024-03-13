package com.plum.cloud.service.impl;

import com.plum.cloud.entities.Pay;
import com.plum.cloud.mapper.PayMapper;
import com.plum.cloud.service.PayService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: PayServiceImpl
 * Package: com.plum.cloud.setvice.impl
 * description
 * Author: Plum
 * Crete : 2024/3/13 23:09
 * Version 1.0
 */
@Service
public class PayServiceImpl implements PayService {

    private PayMapper payMapper;

    @Override
    public int add(Pay pay) {
        return payMapper.insertSelective(pay);
    }

    @Override
    public int delete(Integer id) {
        return payMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Pay pay) {
        return payMapper.updateByPrimaryKey(pay);
    }

    @Override
    public Pay getById(Integer id) {
        return payMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Pay> getAll() {
        return payMapper.selectAll();
    }
}
