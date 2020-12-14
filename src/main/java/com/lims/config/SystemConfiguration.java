package com.lims.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class SystemConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MariaDB Connection;
//		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
//		dataSource.setUrl("jdbc:mariadb://localhost:3307/demo_db");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");

		//MySQl connection;
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		return dataSource;
	}

	@Bean
	public JdbcOperations jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(10485760); // 10MB
		multipartResolver.setMaxUploadSizePerFile(10485760); // 1MB
		return multipartResolver;
	}
}
