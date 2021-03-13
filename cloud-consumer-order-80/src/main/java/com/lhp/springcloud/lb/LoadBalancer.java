package com.lhp.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Amumu
 * @create 2021/3/13 15:32
 */
public interface LoadBalancer {
     ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
