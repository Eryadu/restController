package io.pragra.designpattern.factoryDesignByAPI;

import org.springframework.stereotype.Service;

@Service
public class CreditCardPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessor processPayment() {
        System.out.println("CreditCard Payment was processed successfully");
        return new CreditCardPaymentProcessor();
    }
}

@Service
class  PaypalPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessor processPayment() {
        System.out.println("Paypal Payment was processed successfully");
        return new PaypalPaymentProcessor();
    }
}