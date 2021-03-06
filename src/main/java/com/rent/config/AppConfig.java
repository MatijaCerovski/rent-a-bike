package com.rent.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by Matija on 24.5.2017..
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rent")
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {


}

