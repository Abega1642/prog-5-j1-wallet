package dev.razafindratelo.wallet;

import static dev.razafindratelo.wallet.Currency.EURO;
import static dev.razafindratelo.wallet.Currency.MGA;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoneyTest {
  @Test
  void should_add_money_successfully() {
    var money = new Money(0.0d, MGA);
    var toBeAdded = new Money(100d, EURO);

    var actual = money.add(toBeAdded);

    assertEquals(500_000d, actual.amount());
    assertEquals(MGA, actual.currency());
  }
}
