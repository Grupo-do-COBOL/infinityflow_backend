package site.infinityflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class InfinityflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfinityflowApplication.class, args);
	}

}
