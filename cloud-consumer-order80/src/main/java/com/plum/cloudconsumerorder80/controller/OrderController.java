package com.plum.cloudconsumerorder80.controller;

import com.plum.cloud.entities.PayDTO;
import com.plum.cloudconsumerorder80.req.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: OrderController
 * Package: com.plum.cloudconsumerorder80.controller
 * description
 * Author: Plum
 * Crete : 2024/3/17 20:10
 * Version 1.0
 */
@RestController
public class OrderController {

    public static final String Temp_URL = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @PostMapping(value = "/consume/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(Temp_URL + "/pay/add", payDTO, ResultData.class);
    }

    @GetMapping(value = "/consume/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(Temp_URL + "/pay/get/" + id, ResultData.class, id);
    }
    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(Temp_URL + "/pay/get/info", String.class);
    }

}
