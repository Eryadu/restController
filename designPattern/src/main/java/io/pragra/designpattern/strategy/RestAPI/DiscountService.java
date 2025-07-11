package io.pragra.designpattern.strategy.RestAPI;

import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class DiscountService {
    // Map<String, DiscountStrategy> discountStrategies
    //
    //This is a map of all available discount strategies, where:
    //The key is the name of the strategy (like "newCustomer", "loyalCustomer")
    //The value is a DiscountStrategy implementation.
    //Spring automatically fills this map using all @Component-annotated classes that implement the DiscountStrategy interface.
    private Map<String, DiscountStrategy> discountStrategies;

    public DiscountService(Map<String, DiscountStrategy> discountStrategies) {
        this.discountStrategies = discountStrategies;
    }

    public double calculateDiscount(String type, double originalAmount) {
        DiscountStrategy discountStrategy = discountStrategies.get(type);
        if(discountStrategy == null) {
            throw new IllegalArgumentException("No DiscountStrategy found for type " + type);
        }
        return discountStrategy.applyDiscount(originalAmount);
    }
}
