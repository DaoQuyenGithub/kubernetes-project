package osquyendtm.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import osquyendtm.graphql.entity.Card;
import osquyendtm.graphql.entity.Customer;
import osquyendtm.graphql.repository.CustomerRepository;
import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.response.CardResponse;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CustomerService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @Transactional
    public List<CustomerResponse> findAll() {
        modelMapper.typeMap(Customer.class, CustomerResponse.class).addMappings(mapper -> {
            mapper.skip(CustomerResponse::setCards);
        });

        List<Customer> customersEntity = customerRepository.findAll();
        log.info("Get all data customer successful");

        Type listType = new TypeToken<List<CustomerResponse>>(){}.getType();
        List<CustomerResponse> customerResponses = modelMapper.map(customersEntity, listType);

        for (int i=0; i<customerResponses.size(); i++) {
            customerResponses.get(i).setCards(( mapOne(customersEntity.get(i)).getCards()));
        }
        return customerResponses;
    }

    public CustomerResponse findOne(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(!customerOptional.isPresent()){
            return null;
        }
        Customer customer = customerOptional.get();
        return null;
    }

    public CustomerResponse mapOne(Customer customer){
        modelMapper.typeMap(Customer.class, CustomerResponse.class).addMappings(mapper -> {
            mapper.skip(CustomerResponse::setCards);
        });
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);
        Type listType = new TypeToken<List<CardResponse>>(){}.getType();
        customerResponse.setCards(modelMapper.map(customer.getCards(),listType));
        return customerResponse;
    }

    @Override
    public CustomerResponse create(CreateCustomerRequest createCustomerRequest) {
        Customer customer = modelMapper.map(createCustomerRequest, Customer.class);
        return modelMapper.map(customerRepository.save(customer), CustomerResponse.class);
    }
}
