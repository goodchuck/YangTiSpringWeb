package springwebprj.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
