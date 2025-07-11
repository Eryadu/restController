package io.pragra.designpattern.strategy.RestAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @GetMapping
    public String discountCalculator(@RequestParam String type, @RequestParam double originalAmount) {
        double discountedPrice = discountService.calculateDiscount(type, originalAmount);
        return "Discounted price for " + type + " is: $" + discountedPrice;
    }
}
