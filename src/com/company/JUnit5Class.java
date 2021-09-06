package com.company;

public class JUnit5Class {
    private String liquidType;
    private double percentFull;

    public String getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(String liquidType) {
        if (liquidType == null)
            return;

        this.liquidType = liquidType;
    }

    public double getPercentFull() {
        return percentFull;
    }

    public boolean isEmpty() {
        return percentFull == 0;
    }

    public void setPercentFull(double percentFull) {
        if (percentFull > 100 || percentFull < 0)
            throw new IllegalArgumentException("Percent must be between 0 and 100");
        this.percentFull = percentFull;
    }

    public JUnit5Class(String liquidType, double percentFull) {
        this.liquidType = liquidType;
        this.percentFull = percentFull;
    }
}
