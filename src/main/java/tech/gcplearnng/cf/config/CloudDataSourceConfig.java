package tech.gcplearnng.cf.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig {
	
	@Value("${vcap.services.mysql-db.credentials.url}")
	private String jdbcURL;
	
	@Value("${vcap.services.mysql-db.credentials.username}")
	private String username;
	
	@Value("${vcap.services.mysql-db.credentials.password}")
	private String pass;
	
	
	@Bean
	public DataSource primaryDataSource() {
		System.out.println("*******************************************************************************");
		System.out.println("Cloud Datsource");
		System.out.println("*******************************************************************************");
		
		Properties dsProps = new Properties();
		dsProps.put("jdbcUrl", jdbcURL);
		dsProps.put("user", username);
		dsProps.put("password", pass);
		
		
		dsProps.put("prepStmtCacheSize", 250);
		dsProps.put("prepStmtCacheSqlLimit", 2048);
		dsProps.put("cachePrepStmts", Boolean.TRUE);
		dsProps.put("useServerPrepStmts", Boolean.TRUE);

		Properties configProps = new Properties();
		configProps.put("jdbcUrl", jdbcURL);
		configProps.put("poolName", "spring-music1");
		configProps.put("maximumPoolSize", 10);
		configProps.put("minimumIdle", 4);
		configProps.put("connectionTimeout", 30000);
		configProps.put("idleTimeout", 30000);
		configProps.put("dataSourceProperties", dsProps);

		HikariConfig hc = new HikariConfig(configProps);
		HikariDataSource ds = new HikariDataSource(hc);
		return ds;
	}

}
