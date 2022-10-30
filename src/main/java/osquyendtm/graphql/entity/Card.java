package osquyendtm.graphql.entity;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Transactional
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "dbo")
public class Card{

    @Id
    private String cardNo;

    @Column(nullable = false)
    private Date expiredDate;

    @Column(nullable = false)
    private String cvv;


    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("cardNo", cardNo)
                .append("expiredDate", expiredDate)
                .append("cvv", cvv)
                .append("customer", customer)
                .toString();
    }
}

