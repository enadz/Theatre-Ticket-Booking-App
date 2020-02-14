package com.tongo.backend.data.models;;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int paymentID;
    private int paymentMethodID;
    private int userID;
    private double amount;
    private Date date;

    public Payment(double amount, Date date) {
        this.amount = amount;
        this.date = date;
    }
}
