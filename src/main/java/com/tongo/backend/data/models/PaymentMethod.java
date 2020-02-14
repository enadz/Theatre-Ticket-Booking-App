package com.tongo.backend.data.models;;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
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
@Table(name = "PaymentMethods")
public class PaymentMethod {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int paymentMethodID;
    private String name;

    public PaymentMethod(String name) {
        this.name = name;
    }

}
