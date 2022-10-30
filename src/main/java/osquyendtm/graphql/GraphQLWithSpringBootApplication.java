package osquyendtm.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"osquyendtm.graphql.*"})
@EnableJpaRepositories(basePackages = { "osquyendtm.graphql.repository" })
public class GraphQLWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQLWithSpringBootApplication.class, args);
    }
}
