package xin.ucode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动程序
 *
 * @author ucode
 */

@SpringBootApplication
public class DemoCodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoCodeApplication.class, args);
    }
}
