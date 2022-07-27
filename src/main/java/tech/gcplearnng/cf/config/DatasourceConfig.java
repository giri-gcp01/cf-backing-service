package tech.gcplearnng.cf.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile("noncloud")
public class DatasourceConfig {

	@Bean
	public DataSource primaryDataSource() {
		System.out.println("*******************************************************************************");
		System.out.println("Non Cloud Datsource");
		System.out.println("*******************************************************************************");
		Properties dsProps = new Properties();
		dsProps.put("jdbcUrl", "jdbc:mysql://SG-cf-sql-6472-mysql-master.servers.mongodirector.com:3306/spring-music");
		dsProps.put("user", "test");
		dsProps.put("password", "Spring-Music1");
		dsProps.put("prepStmtCacheSize", 250);
		dsProps.put("prepStmtCacheSqlLimit", 2048);
		dsProps.put("cachePrepStmts", Boolean.TRUE);
		dsProps.put("useServerPrepStmts", Boolean.TRUE);

		Properties configProps = new Properties();
//		configProps.put("dataSourceClassName", "com.mysql.cj.jdbc.MysqlDataSource");
		configProps.put("jdbcUrl", "jdbc:mysql://SG-cf-sql-6472-mysql-master.servers.mongodirector.com:3306/spring-music");
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
