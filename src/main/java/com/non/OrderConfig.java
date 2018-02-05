package com.non;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "productEntityManagerFactory", 
				transactionManagerRef = "productTransactionManager", basePackages = {"com.non.repo.order"})
public class OrderConfig {

	@Bean(name = "productDataSource")
	@ConfigurationProperties(prefix = "spring.product.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "productEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("productDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.non.entity.order").build();
	}

	@Bean(name = "productTransactionManager")
	public PlatformTransactionManager barTransactionManager(
			@Qualifier("productEntityManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
	
}
