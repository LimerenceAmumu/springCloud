package com.lhp.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lhp.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Amumu
 * @create 2021/3/2 21:26
 */
@Mapper
public interface PaymentDao extends BaseMapper<Payment> {

}
