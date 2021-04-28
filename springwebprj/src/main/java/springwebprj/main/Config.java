package springwebprj.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springwebprj.controller.HealthDAO;

@Configuration
public class Config {

	@Bean
	public Test test() {
		return new Test();
	}

	@Bean
	public MemberRegistRequest favoriteOs() {
		return new MemberRegistRequest();
	}

//	 @Bean 
//	 public HealthDTO healthDTO() 
//	 { return new HealthDTO(); }
//	  
//	 @Bean 
//	 public UserDTO userDTO() 
//	 { return new UserDTO(); }
//	  
//	 @Bean 
//	 public HealthDAO healthDAO() 
//	 { return new HealthDAO(); }

}
