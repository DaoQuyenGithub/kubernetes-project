package osquyendtm.graphql.service;

import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> findAll();
    CustomerResponse create(CreateCustomerRequest createCustomerRequest);
}
