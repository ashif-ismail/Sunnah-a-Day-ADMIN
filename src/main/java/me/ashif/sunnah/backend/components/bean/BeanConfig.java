package me.ashif.sunnah.backend.components.bean;

import me.ashif.sunnah.backend.network.RequestInterceptor;
import org.omg.PortableInterceptor.ClientRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
@Configuration
public class BeanConfig {
    @Bean
    public org.springframework.web.client.RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public List<ClientRequestInterceptor> clientRequestInterceptorList(){
        return new ArrayList<>();
    }

    @Bean
    public RequestInterceptor requestInterceptor(String headerName,String headerValue){
        return new RequestInterceptor(headerName,headerValue);
    }
}
