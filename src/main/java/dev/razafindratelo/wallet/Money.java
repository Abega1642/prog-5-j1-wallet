package dev.razafindratelo.wallet;

import static dev.razafindratelo.wallet.Currency.convert;

public record Money(double amount, Currency currency) {

  public Money add(Money other) {
    double newAmount = amount + convert(other.amount(), other.currency(), currency);

    return new Money(newAmount, currency);
  }

  public Money subtract(Money other) {
    double newAmount = amount - convert(other.amount(), other.currency(), currency);

    return new Money(newAmount, currency);
  }
}
