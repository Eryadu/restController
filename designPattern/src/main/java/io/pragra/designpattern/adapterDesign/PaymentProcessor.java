package io.pragra.designpattern.adapterDesign;

//Old Payment processor
public interface PaymentProcessor {
    String processPayment(double amount);
}
//Updated Payment Processor
class UpdatedPaymentProcessor{
    String paymentWithUpdated(double amount){
        return String.format("Payment with updated amount %.2f", amount);
    }
}
class PaymentProcessorAdapter implements PaymentProcessor{
    private UpdatedPaymentProcessor updatedPaymentProcessor;

    public PaymentProcessorAdapter() {
        this.updatedPaymentProcessor = new UpdatedPaymentProcessor();
    }
    @Override
    public String processPayment(double amount) {
        return updatedPaymentProcessor.paymentWithUpdated(amount);
    }
}