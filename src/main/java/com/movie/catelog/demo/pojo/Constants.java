package com.movie.catelog.demo.pojo;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Constants {

    @Value("${rating-url}")
    public String  RATING_URL;

    @Value("${info-service-url}")
    public String  INFOSERVICE_URL;


}
