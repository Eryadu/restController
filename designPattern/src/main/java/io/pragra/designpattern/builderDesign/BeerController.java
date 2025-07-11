package io.pragra.designpattern.builderDesign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.fasterxml.jackson.databind.util.ClassUtil.name;

@RestController
@RequestMapping("/bear")
public class BeerController {
    @GetMapping("/basic")
    public String createStandardBeer() {
        Beer beer = Beer.builder()
                .name("Standard Beer")
                .drinkSize(500)
                .alcoholPercentage(5.0)
                .price(5.99)
                .build();
        return "Created beer: " + beer.getName() +
                ", Drink Size: " + beer.getDrinkSize() +
                ", Alcohol Percentage: " + beer.getAlcoholPercentage() +
                ", Price: " + beer.getPrice();
    }

    @GetMapping("/premium")
    public String createPremiumBeer() {
       Beer beer = Beer.builder()
                .name("Sample Beer")
                .drinkSize(330)
                .alcoholPercentage(5.0)
                .price(10.99)
                .brewery("Crafty Brews")
                .countryOfOrigin("United States")
                .description("A refreshing lager with a smooth taste.")
                .packaging("Bottle")
                .servingTemperature("4-6°C")
                .foodPairing("Pairs well with grilled chicken and salads.")
                .build();

        return "Created beer: " + beer.getName() +
                ", Drink Size: " + beer.getDrinkSize() +
                ", Alcohol Percentage: " + beer.getAlcoholPercentage() +
                ", Price: " + beer.getPrice() +
                ", Brewery: " + beer.getBrewery() +
                ", Country of Origin: " + beer.getCountryOfOrigin() +
                ", Description: " + beer.getDescription() +
                ", Packaging: " + beer.getPackaging() +
                ", Serving Temperature: " + beer.getServingTemperature() +
                ", Food Pairing: " + beer.getFoodPairing();
    }
}
