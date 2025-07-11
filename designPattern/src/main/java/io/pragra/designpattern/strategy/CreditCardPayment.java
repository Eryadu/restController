package io.pragra.designpattern.strategy;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(float amount) {
        System.out.println("Paying with credit card : " + amount);
    }
}
class PaypalPayment implements Payment {
    @Override
    public void pay(float amount) {
        System.out.println("Paying with Paypal : " + amount);
    }
}
