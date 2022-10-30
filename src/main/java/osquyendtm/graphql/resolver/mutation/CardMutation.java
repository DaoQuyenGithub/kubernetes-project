package osquyendtm.graphql.resolver.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import osquyendtm.graphql.request.CreateCardRequest;
import osquyendtm.graphql.request.CreateCustomerRequest;
import osquyendtm.graphql.response.CardResponse;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CardService;
import osquyendtm.graphql.service.CustomerService;

@Component
public class CardMutation implements GraphQLMutationResolver {
    @Autowired
    CardService cardService;

    public CardResponse createCard (CreateCardRequest createCardRequest) {
        return cardService.create(createCardRequest);
    }
}
