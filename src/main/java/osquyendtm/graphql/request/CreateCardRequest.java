package osquyendtm.graphql.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardRequest {
    private String cardNo;
    private Date expiredDate;
    private String cvv;
}
