package com.lhp.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Amumu
 * @create 2021/3/13 15:33
 */
@Component
public class MyLB implements LoadBalancer {
    //已经访问的次数
    AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        if (CollectionUtils.isEmpty(serviceInstances)) {
            return null;
        }
        int index = getIncrementNum() % serviceInstances.size();
        return serviceInstances.get(index);
    }
    final int getIncrementNum() {
        //当前次数
        int current;
        //下一次数
        int next;
        do {
            current = atomicInteger.get();
            System.out.println("current = " + current);
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 设置新的值成功才会跳出循环
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("next = " + next);
        return next;
    }
}
