package io.pragra.designpattern.builderDesign;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// By using Builder Annotation
@Builder
public class Beer {
    //required
    private String name;
    private double drinkSize;
    private double alcoholPercentage;
    private double price;

    // Other attributes
    private String brewery;
    private String countryOfOrigin;
    private String description;
    private String packaging;
    private String servingTemperature;
    private String foodPairing;
}
