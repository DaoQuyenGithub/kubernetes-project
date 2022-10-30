package osquyendtm.graphql.service;

import osquyendtm.graphql.request.CreateCardRequest;
import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.response.CardResponse;
import osquyendtm.graphql.response.CustomerResponse;

import java.util.List;

public interface CardService {
    List<CardResponse> findAll();
    CardResponse create(CreateCardRequest createCardRequest);
}
