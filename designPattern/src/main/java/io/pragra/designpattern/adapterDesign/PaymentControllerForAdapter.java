package io.pragra.designpattern.adapterDesign;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentControllerForAdapter {
    private final PaymentProcessor paymentProcessor;
    public PaymentControllerForAdapter() {
        this.paymentProcessor = new PaymentProcessorAdapter();
    }

    @PostMapping("/{amount}")
    public ResponseEntity<String> makePayment(@PathVariable double amount) {
        paymentProcessor.processPayment(amount);
        return ResponseEntity.ok("Payment successful");
    }
}
