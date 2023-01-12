package com.solvd.happyfarm.product;

import com.solvd.happyfarm.price.Price;
import java.time.LocalDate;
import java.util.Objects;

public class Wool extends Product {

    private float volume;

    public Wool(LocalDate manufactureDate, LocalDate expirationDate, Price price, float volume) {
        super(manufactureDate, expirationDate, price);
        this.volume = volume;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wool)) return false;
        Wool wool = (Wool) o;
        return Objects.equals(volume, wool.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume);
    }

    @Override
    public String toString() {
        return "Wool{" +
                "volume=" + volume +
                '}';
    }
}
