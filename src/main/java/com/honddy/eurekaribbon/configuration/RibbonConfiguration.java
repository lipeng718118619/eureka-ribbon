package com.honddy.eurekaribbon.configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.RandomRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @program: eureka-ribbon
 * @description:
 * @author: lipeng
 * @create: 2018-04-16 15:52
 **/
@RibbonClient(name = "eureka-client", configuration = com.honddy.eurekaribbon.configuration.RibbonConfiguration.Ribbon.class)
@Configuration
public class RibbonConfiguration
{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Configuration
    public class Ribbon
    {
        @Bean
        public IRule getRule()
        {
            logger.info("ribbon use random rule----------------");
            return new RandomRule();
        }

    }
}
