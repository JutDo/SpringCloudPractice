package com.plum.cloud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * ClassName: PayDTO
 * Package: com.plum.cloud.dto
 * description
 * Author: Plum
 * Crete : 2024/3/13 23:22
 * Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayDTO implements Serializable {

    private Integer id;
    //支付流水号

    private String payNo;
    //订单流水号

    private String orderNo;
    //用户账号ID

    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
