package com.nenu.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：lichuankang
 * @date ：2021/10/25 14:45
 * @description ：ignite控制器
 */
@RestController
@Slf4j
public class IgniteController {

    @Resource
    private Ignite ignite;

    @GetMapping(value = "/igniteWrite")
    public String testIgniteWrite(String name) {
        IgniteCache<String, String> cache = ignite.getOrCreateCache("myCache");
        cache.put("name", name);
        cache.put("age", "24");
        return "success";
    }

    @GetMapping(value = "/igniteRead")
    public String igniteRead() {
        IgniteCache<String, String> cache = ignite.cache("myCache");
        return cache.get("name");
    }


}
