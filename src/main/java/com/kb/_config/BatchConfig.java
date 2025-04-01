package com.kb._config;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
public class BatchConfig {


    private final DataSource dataSource;

    public BatchConfig(DataSource dataSource) {
        this.dataSource = dataSource;

    }


//
//    @Bean
//    public InitializingBean initializeSchema() {
//        return () -> {
//            Resource dropSchema = new ClassPathResource("org/springframework/batch/core/schema-drop-mysql.sql");
//            ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(dropSchema);
//            databasePopulator.execute(dataSource);
//
//            Resource schema = new ClassPathResource("org/springframework/batch/core/schema-mysql.sql");
//            ResourceDatabasePopulator populator = new ResourceDatabasePopulator(schema);
//            populator.execute(dataSource);
//        };
//    }


}
