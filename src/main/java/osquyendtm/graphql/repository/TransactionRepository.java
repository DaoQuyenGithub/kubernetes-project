package osquyendtm.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osquyendtm.graphql.entity.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
