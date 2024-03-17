package com.plum.cloud.controller;

import com.plum.cloud.entities.Pay;
import com.plum.cloud.entities.PayDTO;
import com.plum.cloud.req.ResultData;
import com.plum.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: PayController
 * Package: com.plum.cloud.controller
 * description
 * Author: Plum
 * Crete : 2024/3/13 23:09
 * Version 1.0
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Value("${server.port}")
    private String port;
    @Resource
    private PayService payService;
    @PostMapping("pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json串参数")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值" + i);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        return ResultData.success(payService.getById(id));
    }

    @PutMapping("pay/update")
    public ResultData<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);

        return ResultData.success("修改记录成功，修改条数为" + update);


    }

    @DeleteMapping("pay/delete/{id}")
    public ResultData<Integer> delete(@PathVariable("id") Integer id) {
        int delete = payService.delete(id);
        return ResultData.success(delete);
    }

    @GetMapping("/pay/get/all")
    public ResultData<List<Pay>> getALl() {
        return ResultData.success(payService.getAll());
    }
    @GetMapping(value = "/pay/get/info")
    private String getInfoByConsul(@Value("${plum.zhuzhu}") String zhuzhu) {
        return "zhuzhu: " + zhuzhu + "\t" + "port: " + port ;
    }


}
