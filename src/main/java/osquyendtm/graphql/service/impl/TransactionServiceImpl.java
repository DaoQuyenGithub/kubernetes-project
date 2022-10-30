package osquyendtm.graphql.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osquyendtm.graphql.entity.Transactions;
import osquyendtm.graphql.repository.TransactionRepository;
import osquyendtm.graphql.request.CreateTransactionRequest;
import osquyendtm.graphql.response.TransactionResponse;
import osquyendtm.graphql.service.TransactionService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public TransactionResponse create(CreateTransactionRequest createTransactionRequest) {
        Transactions transactions = modelMapper.map(createTransactionRequest, Transactions.class);
        transactions.setCreationDate(new Timestamp(new Date().getTime()));
        return modelMapper.map(transactionRepository.save(transactions), TransactionResponse.class);
    }

    @Override
    public List<TransactionResponse> findAll() {
        return null;
    }
}
