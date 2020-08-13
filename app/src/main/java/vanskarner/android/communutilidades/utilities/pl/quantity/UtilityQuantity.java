package vanskarner.android.communutilidades.utilities.pl.quantity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class UtilityQuantity implements IUtilityQuantity {

    public static final String FORMAT_PATTERN_INTEGER = "%,d";
    public static final String FORMAT_PATTERN_ONE_DECIMAL = "###,###.#";
    public static final String FORMAT_PATTERN_TWO_DECIMAL = "###,###.##";
    public static final String FORMAT_PATTERN_THREE_DECIMAL = "###,###.###";

    @Override
    public String integerFormat(Integer quantity, String pattern) {
        return String.format(pattern, quantity);
    }

    @Override
    public String decimalFormat(double quantity, String pattern) {
        DecimalFormat myFormat = new DecimalFormat(pattern);
        int numberOfDecimals = myFormat.getMaximumFractionDigits();
        double rounded = roundedDouble(quantity, numberOfDecimals);
        myFormat.setRoundingMode(RoundingMode.DOWN);
        return myFormat.format(rounded);
    }

    @Override
    public float roundedFloat(Float quantity, int numberOfDecimals) {
        return (float) roundedDouble(quantity.doubleValue(), numberOfDecimals);
    }

    @Override
    public double roundedDouble(Double quantity, int numberOfDecimals) {
        Double dec1=Math.pow(10, numberOfDecimals);        
        BigDecimal bigDecimalQuantity = new BigDecimal(quantity.toString());        
        BigDecimal decimals = new BigDecimal(dec1.toString());        
        BigDecimal result1 = bigDecimalQuantity.multiply(decimals);
        BigDecimal result2;
        if(result1.doubleValue()<0){
            result2 = new BigDecimal(Math.round(-result1.doubleValue()));
            return -(result2.divide(decimals).doubleValue());
        }else{
            result2 = new BigDecimal(Math.round(result1.doubleValue()));
            return result2.divide(decimals).doubleValue();
        }
    }

    @Override
    public boolean isDecimal(double quantity) {
        return quantity % 1 != 0;
    }
}
