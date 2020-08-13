package vanskarner.android.communutilidades.utilities.pl.quantity;

public interface IUtilityQuantity {

    String integerFormat(Integer quantity, String pattern);

    String decimalFormat(double quantity, String numberOfDecimals);

    float roundedFloat(Float quantity, int numberOfDecimals);

    double roundedDouble(Double quantity, int numberOfDecimals);
    
    boolean isDecimal(double quantity);
}
