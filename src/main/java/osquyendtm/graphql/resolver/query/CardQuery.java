package osquyendtm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.response.CardResponse;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CardService;
import osquyendtm.graphql.service.CustomerService;

import java.util.List;

@Slf4j
@Component
public class CardQuery implements GraphQLQueryResolver {

    @Autowired
    CardService cardService;

    public List<CardResponse> getAllCard () {
        log.info("Get all data card");
        return cardService.findAll();
    }
}
