package com.solvd.happyfarm.price;

import java.math.BigDecimal;
import java.util.Objects;

public class Price {

    private BigDecimal value;
    private String currency;

    public Price(BigDecimal value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return Objects.equals(getValue(), price.getValue()) && Objects.equals(getCurrency(), price.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getCurrency());
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
