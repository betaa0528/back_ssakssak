package com.kb._config;

import jakarta.servlet.MultipartConfigElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


@Slf4j
@Configuration
public class WebConfig {
    @Value("${os.type}")
    private String osType;

    @Value("${file_save_location_win}")
    private String fileSaveLocationWin;

    @Value("${file_save_location_other}")
    private String fileSaveLocationOther;

    private String getUploadDirectory() {
        return "win".equalsIgnoreCase(osType) ? fileSaveLocationWin : fileSaveLocationOther;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(getUploadDirectory());
        factory.setMaxFileSize(DataSize.ofMegabytes(10));
        factory.setMaxRequestSize(DataSize.ofMegabytes(20));
        return factory.createMultipartConfig();
    }


}
