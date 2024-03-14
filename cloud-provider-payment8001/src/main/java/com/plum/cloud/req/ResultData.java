package com.plum.cloud.req;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: ResultData
 * Package: com.plum.cloud.req
 * description
 * Author: Plum
 * Crete : 2024/3/14 23:38
 * Version 1.0
 */
@Data
@Accessors(chain = true)
public class ResultData<T> {

 private  String code;
 private  String message;
 private  T data;
 private long timeStamp;

 ResultData(){
     this.timeStamp = System.currentTimeMillis();
 }
 public static <T> ResultData<T>   success(T data){
     ResultData<T> resultData = new ResultData<>();
     resultData.setCode(ReturnCodeEnum.RC200.getCode());
     resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
     resultData.setData(data);
     return resultData;
 }

    public static <T> ResultData<T>   fail(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
        return resultData;
    }


}


