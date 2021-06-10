package springwebprj.main;

import java.beans.PropertyVetoException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
//@ComponentScan(basePackages = "springwebprj")
public class Config {

	@Bean
	public Test test() {
		return new Test();
	}

	@Bean
	public MemberRegistRequest favoriteOs() {
		return new MemberRegistRequest();
	}

	@Bean
	public ComboPooledDataSource datasource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		try {
			datasource.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		datasource.setJdbcUrl("jdbc:mysql://localhost:3306/yangtihealth");
		datasource.setUser("root");
		datasource.setPassword("yth502100");
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(ComboPooledDataSource datasource) {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
			return jdbcTemplate;
	}
	
	@Bean
	public HealthDAO hd() {
		return new HealthDAO();
	}
	
//	 @Bean 
//	 public HealthDTO healthDTO() 
//	 { return new HealthDTO(); }
//	  
//	 @Bean 
//	 public UserDTO userDTO() 
//	 { return new UserDTO(); }
}
