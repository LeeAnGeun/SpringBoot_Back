package bit.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "bit.com.a")
public class Sample2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sample2Application.class, args);
	}
}
