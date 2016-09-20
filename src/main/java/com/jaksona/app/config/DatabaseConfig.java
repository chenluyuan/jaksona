package com.jaksona.app.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 数据库配置
 * @author jaksona
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.jaksona.app.dao")
public class DatabaseConfig {

	@Bean
	public DataSource dataSource() {
		String URL = "jdbc:mysql://localhost:3306/jaksona?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true";
		String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		String USERNAME = "root";
		String PASSWORD = "123";
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		dataSource.setMaxActive(150);
		dataSource.setMinIdle(5);
		dataSource.setMaxIdle(20);
		dataSource.setInitialSize(30);
		dataSource.setLogAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(10);
		dataSource.setMaxWait(1000);
		dataSource.setTimeBetweenEvictionRunsMillis(10000);
		dataSource.setNumTestsPerEvictionRun(10);
		dataSource.setMinEvictableIdleTimeMillis(10000);
		dataSource.setValidationQuery("SELECT NOW() FROM DUAL");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory.getObject();
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();
		txManager.setDataSource(dataSource());
		return txManager;
	}
}
