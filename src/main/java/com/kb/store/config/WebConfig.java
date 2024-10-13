package com.kb.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 프로퍼티에서 파일 경로 불러오기
        String uploadPath = env.getProperty("file_save_location");
        if (uploadPath != null) {
            registry.addResourceHandler("/images/**")
                    .addResourceLocations("file:" + uploadPath);
        }
    }
}
