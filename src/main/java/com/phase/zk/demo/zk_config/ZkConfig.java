package com.phase.zk.demo.zk_config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zkoss.zk.au.http.DHtmlUpdateServlet;
import org.zkoss.zk.ui.http.DHtmlLayoutServlet;

@Configuration
public class ZkConfig {

    @Bean
    public ServletRegistrationBean<DHtmlLayoutServlet> zkLoader() {
        ServletRegistrationBean<DHtmlLayoutServlet> reg = new ServletRegistrationBean<>(new DHtmlLayoutServlet(), "*.zul");
        reg.setLoadOnStartup(1);
        reg.addInitParameter("update-uri", "/zkau");
        return reg;
    }

    @Bean
    public ServletRegistrationBean<DHtmlUpdateServlet> zkAjax() {
        return new ServletRegistrationBean<>(new DHtmlUpdateServlet(), "/zkau/*");
    }

}
