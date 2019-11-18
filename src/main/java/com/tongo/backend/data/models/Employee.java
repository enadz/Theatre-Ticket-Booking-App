package com.pozoriste.pozoristebackend.data.models;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pozoriste.Role;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@Table(name="employee")
public class Employee {
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
