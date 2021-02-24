package com.kh.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author han.ke
 */
@SpringBootApplication
@EnableEurekaClient
@CrossOrigin
public class GatewayApplication {
    private static final Logger LOG = LoggerFactory.getLogger(GatewayApplication.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GatewayApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("GateWay地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));
    }
}
