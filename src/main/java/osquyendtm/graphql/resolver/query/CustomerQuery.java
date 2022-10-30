package osquyendtm.graphql.resolver.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CustomerService;

import java.util.List;

@Slf4j
@Component
public class CustomerQuery implements GraphQLQueryResolver {
	
	@Autowired
	CustomerService customerService;
	
	public List<CustomerResponse> getAllCustomer () {
		log.info("Get all data customer");
		return customerService.findAll();
	}
}
