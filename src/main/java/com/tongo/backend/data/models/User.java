package pozoriste;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="tongoUsers")
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private double balance;
    private int loyaltypoints;
    private Date dob;
    private String phonenum;

    public User(String firstName, String lastName, double balance, int loyaltypoints, Date dob, String phonenum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.loyaltypoints = loyaltypoints;
        this.dob = dob;
        this.phonenum = phonenum;
    }
}
