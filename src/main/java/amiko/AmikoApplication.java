package amiko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AmikoApplication {
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AmikoApplication.class, args);
    }

}
