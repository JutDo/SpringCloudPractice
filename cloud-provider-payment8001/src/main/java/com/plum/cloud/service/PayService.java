package com.plum.cloud.service;

import com.plum.cloud.entities.Pay;

import java.util.List;

/**
 * ClassName: PayServi
 * Package: com.plum.cloud.service
 * description
 * Author: Plum
 * Crete : 2024/3/13 23:11
 * Version 1.0
 */
public interface PayService {
    int add (Pay pay);
    int delete(Integer id);
    int update (Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();
}
