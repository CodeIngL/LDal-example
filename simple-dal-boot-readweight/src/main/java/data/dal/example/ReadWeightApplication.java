package data.dal.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author
 * @date
 */
@SpringBootApplication
@PropertySource(value = {"classpath:application-dal.properties"})
@ImportResource(value = {"classpath:datasource.xml"})
public class ReadWeightApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWeightApplication.class, args);
    }
}
