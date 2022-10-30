package osquyendtm.graphql.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osquyendtm.graphql.entity.Card;
import osquyendtm.graphql.entity.Customer;
import osquyendtm.graphql.repository.CardRepository;
import osquyendtm.graphql.repository.CustomerRepository;
import osquyendtm.graphql.request.CreateCardRequest;
import osquyendtm.graphql.response.CardResponse;
import osquyendtm.graphql.response.CustomerResponse;
import osquyendtm.graphql.service.CardService;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<CardResponse> findAll() {
//        modelMapper.typeMap(Card.class, CardResponse.class).addMappings(mapper -> {
//            mapper.skip(CustomerResponse::setCards);
//        });
        Type listType = new TypeToken<List<CardResponse>>(){}.getType();
        return modelMapper.map(cardRepository.findAll(),listType);
    }

    @Override
    public CardResponse create(CreateCardRequest createCardRequest) {
        try{
            modelMapper.typeMap(CardResponse.class, Card.class).addMappings(mapper -> {
                mapper.skip(Card::setCustomer);
            });
            Card card = modelMapper.map(createCardRequest, Card.class);
            return modelMapper.map(cardRepository.save(card), CardResponse.class);
        }catch (Exception e){
            log.error("Error when create card {}", e.getMessage() );
        }
      return null;
    }
}
