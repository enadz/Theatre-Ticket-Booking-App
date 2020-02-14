package com.tongo.backend.data.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
@Table(name="tongoUsers")
public class User {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
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
