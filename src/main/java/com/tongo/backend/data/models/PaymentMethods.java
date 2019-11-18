package pozoriste;

import liquibase.change.DatabaseChange;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "PaymentMethods")
public class PaymentMethods {

    private int paymentMethodID;
    private String name;

    public PaymentMethods(String name) {
        this.name = name;
    }

}
