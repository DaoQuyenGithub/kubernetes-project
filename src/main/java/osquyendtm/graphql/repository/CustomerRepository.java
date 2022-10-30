package osquyendtm.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osquyendtm.graphql.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
