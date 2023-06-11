package com.slycreator.equityedge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
class TestEquityEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.from(EquityEdgeApplication::main).with(TestEquityEdgeApplication.class).run(args);
    }

}
