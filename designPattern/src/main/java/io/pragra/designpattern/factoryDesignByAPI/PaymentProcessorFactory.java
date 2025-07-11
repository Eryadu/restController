package io.pragra.designpattern.factoryDesignByAPI;

import org.springframework.stereotype.Component;

@Component
public class PaymentProcessorFactory {
    public CreditCardPaymentProcessor creditCardPaymentProcessor;
    public PaypalPaymentProcessor paypalPaymentProcessor;

    public PaymentProcessorFactory(CreditCardPaymentProcessor creditCardPaymentProcessor
            , PaypalPaymentProcessor paypalPaymentProcessor) {
        this.creditCardPaymentProcessor = creditCardPaymentProcessor;
        this.paypalPaymentProcessor = paypalPaymentProcessor;
    }

    public PaymentProcessor createPaymentProcessor(String paymentType) {
        if(paymentType.equalsIgnoreCase("CreditCard")) {
            return creditCardPaymentProcessor.processPayment();
        }
        else if(paymentType.equalsIgnoreCase("Paypal")) {
            return paypalPaymentProcessor;
        }
        throw  new IllegalArgumentException("Invalid payment type" + paymentType);

    }
}
