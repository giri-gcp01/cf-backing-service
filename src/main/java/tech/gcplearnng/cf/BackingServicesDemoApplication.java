package tech.gcplearnng.cf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, 
	})
public class BackingServicesDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackingServicesDemoApplication.class, args);
	}

}
