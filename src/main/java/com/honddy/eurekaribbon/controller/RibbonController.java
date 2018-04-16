package com.honddy.eurekaribbon.controller;

import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class RibbonController
{
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon/name")
    public String ribbonTest(@RequestParam(value = "name") String name)
    {
        UriComponentsBuilder uriBuilder =UriComponentsBuilder.fromUriString("http://eureka-client/name");
        uriBuilder.queryParam("name","lipeng");
        URI uri = uriBuilder.build().toUri();
        return  restTemplate.getForObject(uri,String.class);
    }
}
