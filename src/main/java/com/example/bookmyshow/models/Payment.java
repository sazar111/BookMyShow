package com.example.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    int amount;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;
    long referenceId;
}
