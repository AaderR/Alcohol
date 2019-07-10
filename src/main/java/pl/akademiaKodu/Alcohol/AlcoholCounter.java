package pl.akademiaKodu.Alcohol;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class AlcoholCounter {

    private static final float etchingFactorWomen = 0.6f;

    private static final float etchingFactorMen = 0.7f;

    private static final int burningAlcoholForMenAnHour = 11;
    private static final int burningAlcoholForWomenAnHour = 9;


    public double calculatePerMil(double quantity, double weight,
                                 boolean male, Alcohol alcohol) {
        double proMil = 0;
        if (male) {
            proMil = (float) ((float) quantity / etchingFactorMen / weight * alcohol.getStrength());
        } else {
            proMil = (float) ((float) quantity / etchingFactorWomen / weight * alcohol.getStrength());
        }
        return proMil;
    }

    public float calculatePermilWithHours(double quantity, double weight, boolean male, double hours, Alcohol alcohol) {
        float proMil = 0;
        if (male) {
            proMil = (float) ((float) ((quantity * alcohol.getStrength()) - burningAlcoholForMenAnHour * hours) / (etchingFactorMen* weight));
        } else {
            proMil = (float) ((float) ((quantity * alcohol.getStrength()) - burningAlcoholForWomenAnHour * hours) / (etchingFactorWomen * weight));
        }
        return proMil;
    }



}