package com.ss.spring.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEntityLinks
public class SpringApplicationMain extends SpringBootServletInitializer {

    public static void main(String[] args){
        System.out.println ("Testing this on IntelJ Idea");
        SpringApplication.run(SpringApplicationMain.class, args);
    }



    @Bean
    public HttpMessageConverters additionalConverters() {

        List nList=new ArrayList();
        nList.add(new Jaxb2RootElementHttpMessageConverter());
        nList.add(new MappingJackson2HttpMessageConverter());
        HttpMessageConverters converters= new HttpMessageConverters(nList);
        return  converters;
    }

}
