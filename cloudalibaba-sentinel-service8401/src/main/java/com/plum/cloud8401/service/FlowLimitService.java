package com.plum.cloud8401.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ClassName: FlowLimitService
 * Package: com.plum.cloud8401.service
 * description
 * Author: Plum
 * Crete : 2024/4/6 17:34
 * Version 1.0
 */
@Service
public class FlowLimitService
{
    @SentinelResource(value = "common")
    public void common()
    {
        System.out.println("------FlowLimitService come in");
    }
}


