package osquyendtm.graphql.response;

import lombok.*;
import osquyendtm.graphql.entity.Card;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private long id;
    private String firstName;
    private String lastName;
    private List<CardResponse> cards;
}
