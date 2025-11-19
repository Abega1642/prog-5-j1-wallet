package dev.razafindratelo.wallet;

import static dev.razafindratelo.wallet.classifier.Currency.EURO;
import static dev.razafindratelo.wallet.classifier.Currency.MGA;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class WalletTest {

  private static final Wallet TEST_WALLET =
      new Wallet(
          "random-mark",
          "brown",
          Weight.getDefault(500),
          new Money(50_000d, MGA),
          false,
          List.of());

  @Test
  void should_add_money_to_wallet() {
    TEST_WALLET.setMoney(new Money(50_000d, MGA));
    var toBeAdded = new Money(50_000d, MGA);
    var totalMoney = TEST_WALLET.addMoney(toBeAdded);

    assertEquals(100_000d, TEST_WALLET.getMoney().amount());
    assertEquals(100_000d, totalMoney.amount());
  }

  @Test
  void should_withdraw_money_to_wallet() {
    TEST_WALLET.setMoney(new Money(50_000d, MGA));
    var toBeSubtracted = new Money(50_000d, MGA);
    var totalMoney = TEST_WALLET.addMoney(toBeSubtracted);

    assertEquals(100_000d, TEST_WALLET.getMoney().amount());
    assertEquals(100_000d, totalMoney.amount());
  }

  @Test
  void should_throw_exception_on_subtract_money() {
    TEST_WALLET.setMoney(new Money(50_000d, MGA));
    var toBeAdded = new Money(50_001d, MGA);
    assertThrows(IllegalArgumentException.class, () -> TEST_WALLET.withdrawMoney(toBeAdded));
  }

  @Test
  void should_throw_exception_on_negative_amount_with_addMoney_method() {
    TEST_WALLET.setMoney(new Money(50_000d, MGA));
    var toBeAdded = new Money(-50_000d, MGA);
    assertThrows(IllegalArgumentException.class, () -> TEST_WALLET.addMoney(toBeAdded));
  }

  @Test
  void should_add_new_card_to_wallet() {
    var card = new Card("BNI CARD", new Money(1_000_000d, EURO));

    TEST_WALLET.addCard(card);
    assertEquals(1, TEST_WALLET.getCards().size());
  }

  @Test
  void should_get_not_empty_as_state() {
    assertEquals("NOT EMPTY", TEST_WALLET.checkMoney());
  }
}
