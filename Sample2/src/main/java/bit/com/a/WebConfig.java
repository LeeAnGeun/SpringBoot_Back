package bit.com.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	// 보안설정
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
	//	WebMvcConfigurer.super.addCorsMappings(registry);
		
						// 모든것을 허용
		registry.addMapping("/**").allowedOrigins("http://localhost:8090");		// http://localhost:8090의 접속을 허가 해주는 코드
	}	
}
