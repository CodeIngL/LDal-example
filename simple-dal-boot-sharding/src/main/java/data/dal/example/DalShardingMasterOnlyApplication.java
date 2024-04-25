package data.dal.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DalShardingMasterOnlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DalShardingMasterOnlyApplication.class, args);
    }
}
