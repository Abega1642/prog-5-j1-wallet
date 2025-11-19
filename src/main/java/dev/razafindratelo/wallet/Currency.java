package dev.razafindratelo.wallet;

import lombok.Getter;

@Getter
public enum Currency {
  MGA(1), EURO(5_000), USD(4_500);

  private final double weight;
  Currency(double weight) {
    this.weight = weight;
  }

  public static double convert(double value, Currency fromCurrency, Currency toCurrency) {
    return value * fromCurrency.getWeight() / toCurrency.getWeight();
  }
}
