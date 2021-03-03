package com.lhp.springcloud.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Amumu
 * @create 2021/3/1 21:28
 */
@Data
@TableName("payment")
public class Payment {
    @TableId
    private Long id;
    private String serial;
}
