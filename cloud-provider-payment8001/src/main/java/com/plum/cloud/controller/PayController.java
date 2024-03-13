package com.plum.cloud.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.plum.cloud.dto.PayDTO;
import com.plum.cloud.entities.Pay;
import com.plum.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    @Resource

    private PayService payService;

    @PostMapping("pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json串参数")
    public String addPay(@RequestBody Pay pay) {
        log.info(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值" + i;
    }

    @GetMapping("/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    @PutMapping("pay/update")
    public String update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int update = payService.update(pay);
        return "修改记录成功，修改条数为" + update;


    }

    @DeleteMapping("pay/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        int delete = payService.delete(id);

        return "删除成功，记录为" + delete;
    }

    @GetMapping("/pay/get/all")
    public List<Pay> getALl() {
        return payService.getAll();
    }


}
