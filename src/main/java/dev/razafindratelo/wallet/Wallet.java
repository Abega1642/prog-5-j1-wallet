package dev.razafindratelo.wallet;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Wallet {
  private final String mark;
  private final String color;
  private Weight weight;
  private Money money;
  private boolean isLost;
  private List<Card> cards;

  public Money addMoney(Money toBeAdded) {
    double newMoneyAmount = toBeAdded.amount();

    if (newMoneyAmount < 0)
      throw new IllegalArgumentException("Money amount should not be negative");

    var newMoney = this.money.add(toBeAdded);
    this.setMoney(newMoney);

    return newMoney;
  }

  public Money withdrawMoney(Money toBeSubtracted) {
    var newMoney = this.money.subtract(toBeSubtracted);

    if (newMoney.amount() < 0)
      throw new IllegalArgumentException(
          format(
              "Withdraw not allowed because your current money is %f, but the money you want to"
                  + " withdraw is %f",
              money.amount(), toBeSubtracted.amount()));

    this.setMoney(newMoney);

    return newMoney;
  }

  public String checkMoney() {
    return (money.amount() > 0) ? "NOT EMPTY" : "EMPTY";
  }

  public Card addCard(Card newCard) {
    if (newCard == null) throw new IllegalArgumentException("Card should not be null");

    var cardList = new ArrayList<>(cards);
    cardList.add(newCard);
    setCards(cardList);

    return newCard;
  }
}
