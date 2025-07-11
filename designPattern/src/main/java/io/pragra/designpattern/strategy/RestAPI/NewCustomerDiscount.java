package io.pragra.designpattern.strategy.RestAPI;

import org.springframework.stereotype.Component;

@Component("newCustomer")
public class NewCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90; // 10% discount
    }
}
@Component("loyalCustomer")
class LoyalCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.80;  // 20% discount
    }
}

@Component("seasonalCustomer")
class SeasonalCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.85;  // 15% discount
    }
}
