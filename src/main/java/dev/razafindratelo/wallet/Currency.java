package dev.razafindratelo.wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Currency {
  MGA(1),
  EURO(5_000),
  USD(4_500);

  private final double mgaValue;

  public static double convert(double value, Currency fromCurrency, Currency targetCurrency) {
    return value * fromCurrency.getMgaValue() / targetCurrency.getMgaValue();
  }
}
