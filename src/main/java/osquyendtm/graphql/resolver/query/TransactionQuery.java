package osquyendtm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.response.TransactionResponse;
import osquyendtm.graphql.service.CustomerService;
import osquyendtm.graphql.service.TransactionService;

import java.util.List;

@Slf4j
@Component
public class TransactionQuery  implements GraphQLQueryResolver {

    @Autowired
    TransactionService transactionService;

    public List<TransactionResponse> getAllTransaction () {
        log.info("Get all data customer");
        return transactionService.findAll();
    }
}