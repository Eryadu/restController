package io.pragra.designpattern.factoryDesignByAPI;

@FunctionalInterface
public interface PaymentProcessor {
  PaymentProcessor processPayment();
}

