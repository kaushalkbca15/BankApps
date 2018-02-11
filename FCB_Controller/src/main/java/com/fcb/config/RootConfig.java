package com.fcb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.fcb.integration.config.FCBIntegrationConfig;
import com.fcb.persistence.config.FCBDataSource;
import com.fcb.persistence.config.FCBSessionFactory;
import com.fcb.security.config.FCBSecurityConfig;
import com.fcb.service.config.FCBServiceConfig;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import(value= {FCBDataSource.class,FCBSessionFactory.class,FCBIntegrationConfig.class,FCBServiceConfig.class})
public class RootConfig {

	
}
 