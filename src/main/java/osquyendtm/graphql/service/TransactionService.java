package osquyendtm.graphql.service;

import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.request.CreateTransactionRequest;
import osquyendtm.graphql.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse create(CreateTransactionRequest createTransactionRequest);
    List<TransactionResponse> findAll();
}
