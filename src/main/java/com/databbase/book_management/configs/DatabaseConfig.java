package com.databbase.book_management.configs;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.java.Log;

@Log
@Configuration
class DatabaseConfig {

  @Bean
  JdbcTemplate jdbcTemplate(final DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  CommandLineRunner CommandLineRunner(final JdbcTemplate jdbcTemplate) {
    return args -> {
       
    };
  }
}
