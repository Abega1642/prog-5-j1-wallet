package dev.razafindratelo.wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Wallet {
  private final String mark;
  private final String color;
  private Weight weight;
  private Money money;
  private List<Card> cards;

  public Money addMoney(Money money) {
    double newMoneyAmount = money.amount();

    if (newMoneyAmount < 0)
      throw new IllegalArgumentException("Money amount cannot be negative");

    Currency currency = money.currency();
  }
}
