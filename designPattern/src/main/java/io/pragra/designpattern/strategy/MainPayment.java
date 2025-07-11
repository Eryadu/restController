package io.pragra.designpattern.strategy;

public class MainPayment {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPayment(new CreditCardPayment());
        shoppingCart.checkout(12.0f);

        shoppingCart.setPayment(new PaypalPayment());
        shoppingCart.checkout(15.0f);

    }
}
