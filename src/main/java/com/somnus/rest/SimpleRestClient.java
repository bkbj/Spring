package com.somnus.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
 
import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:     基于jdk的spring的RestTemplate
 * @Description:   TODO
 * @author         Somnus
 * @version        V1.0  
 * @Date           2016年10月11日 下午4:23:33
 */
@Component
@Lazy(false)
public class SimpleRestClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleRestClient.class);
	 
    private static RestTemplate restTemplate;
 
    static {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
 
        // 添加转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
 
        restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
 
        LOGGER.info("SimpleRestClient初始化完成");
    }
 
    private SimpleRestClient() {
    	
    }
 
    @PostConstruct
    public static RestTemplate getClient() {
        return restTemplate;
    }
}
