package osquyendtm.graphql.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String cardNo;
    private Date expiredDate;
    private String cvv;
}
