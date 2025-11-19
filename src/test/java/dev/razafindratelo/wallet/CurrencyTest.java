package dev.razafindratelo.wallet;

import static dev.razafindratelo.wallet.Currency.EURO;
import static dev.razafindratelo.wallet.Currency.MGA;
import static dev.razafindratelo.wallet.Currency.USD;
import static dev.razafindratelo.wallet.Currency.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CurrencyTest {
  @Test
  void should_convert_mga_to_euro_correctly() {
    double mgaValue = 5_000_000d;
    double actual = convert(mgaValue, MGA, EURO);

    assertEquals(1_000d, actual);
  }

  @Test
  void should_convert_euro_to_mga_correctly() {
    double euroValue = 1_500d;
    double actual = convert(euroValue, EURO, MGA);

    assertEquals(7_500_000d, actual);
  }

  @Test
  void should_convert_euro_to_usd_correctly() {
    double euroValue = 1d;
    double actual = convert(euroValue, EURO, USD);

    assertEquals(1.1111111111111112d, actual);
  }

  @Test
  void should_convert_usd_to_euro_correctly() {
    double usdValue = 1d;
    double actual = convert(usdValue, USD, EURO);

    assertEquals(0.9d, actual);
  }
}
