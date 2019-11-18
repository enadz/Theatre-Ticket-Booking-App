package pozoriste;

import liquibase.change.DatabaseChange;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Payments")
public class Payments {

    private int paymentID;
    private int paymentMethodID;
    private int userID;
    private double amount;
    private Date date;

    public Payments(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }
}
