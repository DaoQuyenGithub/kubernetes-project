package osquyendtm.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CustomerService;

@Component
public class CustomerMutation implements GraphQLMutationResolver {
    @Autowired
    CustomerService customerService;

    public CustomerResponse createCustomer (CreateCustomerRequest createCustomerRequest) {
        return customerService.create(createCustomerRequest);
    }
}