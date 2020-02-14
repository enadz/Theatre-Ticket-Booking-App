package com.tongo.backend.data.models;;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String role;

    public Employee(String firstName, String lastName, String address, String phoneNumber, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }
}
