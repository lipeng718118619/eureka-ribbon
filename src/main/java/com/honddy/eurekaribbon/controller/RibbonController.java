package com.honddy.eurekaribbon.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class RibbonController
{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/ribbon/name")
    public String ribbonTest(@RequestParam(value = "name") String name)
    {
        UriComponentsBuilder uriBuilder =UriComponentsBuilder.fromUriString("http://eureka-client/name");
        uriBuilder.queryParam("name","lipeng");
        URI uri = uriBuilder.build().toUri();
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        logger.info("URI is : " +serviceInstance.getHost()+":"+serviceInstance.getPort()+".............");
        return  restTemplate.getForObject(uri,String.class);
    }
}
