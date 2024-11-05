package task4.impl;

import task4.UsdRubConverter;

public class UsdRubConverterImpl implements UsdRubConverter {
    private double rate = 60;

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double convertRubToUsd(double rub) {
        return rub / rate;
    }

    @Override
    public double convertUsdToRub(double usd) {
        return usd * rate;
    }
}
