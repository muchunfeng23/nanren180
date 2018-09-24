package com.mcf;

import java.beans.PropertyVetoException;

import javax.sql.DataSource; 

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.mcf.mybatis.mapper")
public class Nanren180ServerApplication {
	private Logger logger = LoggerFactory.getLogger(Nanren180ServerApplication.class);
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
//		return new org.apache.tomcat.jdbc.pool.DataSource();
		com.mchange.v2.c3p0.ComboPooledDataSource dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/nanren180");
			dataSource.setUser("yanglu");
			dataSource.setPassword("jordan23");
			dataSource.setMinPoolSize(10);
			dataSource.setMaxPoolSize(200);
			dataSource.setMaxIdleTime(30);
			dataSource.setAcquireIncrement(5);
			dataSource.setIdleConnectionTestPeriod(60);
			dataSource.setAcquireRetryAttempts(30);
			dataSource.setBreakAfterAcquireFailure(false);
			dataSource.setNumHelperThreads(5);
			dataSource.setAcquireRetryDelay(500);
			dataSource.setAutoCommitOnClose(true);
			dataSource.setPropertyCycle(300);
			dataSource.setCheckoutTimeout(5000);
			return dataSource;
		} catch (PropertyVetoException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/*.xml"));

		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Nanren180ServerApplication.class, args);
		
	}
}
