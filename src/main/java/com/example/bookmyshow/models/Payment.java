package com.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    int amount;
    @Enumerated(EnumType.ORDINAL)
    PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    PaymentStatus paymentStatus;
    long referenceId;
}
