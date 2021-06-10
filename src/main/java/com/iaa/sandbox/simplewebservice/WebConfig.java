package com.iaa.sandbox.simplewebservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.iaa.sandbox.simplewebservice.controller")
public class WebConfig {

}
