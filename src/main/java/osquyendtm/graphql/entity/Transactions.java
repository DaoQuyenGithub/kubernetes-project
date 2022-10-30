package osquyendtm.graphql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "dbo")
public class Transactions extends Auditable<String> {
    @Id
    @Column(nullable = false)
    private String sourceAccount;

    @Column(nullable = false)
    private String totalAmount;
}
