package osquyendtm.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.request.CreateTransactionRequest;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.response.TransactionResponse;
import osquyendtm.graphql.service.TransactionService;

@Component
public class TransactionsMutation  implements GraphQLMutationResolver {
    @Autowired
    TransactionService transactionService;

    public TransactionResponse createTransaction(CreateTransactionRequest createTransactionRequest) {
        return transactionService.create(createTransactionRequest);
    }
}
