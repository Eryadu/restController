package io.pragra.designpattern.factoryDesignByAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paymentProcessor")
public class PaymentController {
    @Autowired
    PaymentProcessorFactory paymentProcessorFactory;
    @GetMapping("/{paymentType}")
    public PaymentProcessor payment(@PathVariable String paymentType) {
       return paymentProcessorFactory.createPaymentProcessor(paymentType);
    }
}
