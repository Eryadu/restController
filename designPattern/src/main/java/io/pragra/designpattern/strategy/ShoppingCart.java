package io.pragra.designpattern.strategy;

public class ShoppingCart {
    private Payment payMethod;

    public void setPayment(Payment payMethod) {
        this.payMethod = payMethod;
    }
    public void checkout(float amount) {
        if (this.payMethod == null) {
            throw new RuntimeException("payment is null");
        }
        payMethod.pay(amount);

    }
}
