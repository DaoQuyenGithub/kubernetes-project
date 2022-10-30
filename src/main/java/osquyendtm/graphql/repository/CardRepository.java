package osquyendtm.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import osquyendtm.graphql.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
