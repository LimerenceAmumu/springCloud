package com.lhp.springcloud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Amumu
 * @create 2021/3/1 21:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult {
    private int code;
    private String message;
    private Object result;
    public CommonResult(int code,String message){
        this(code,message,null);
    }

}
