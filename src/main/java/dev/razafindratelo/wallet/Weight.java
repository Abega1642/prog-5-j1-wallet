package dev.razafindratelo.wallet;

import dev.razafindratelo.wallet.classifier.Unit;

public record Weight(double value, Unit unit) {

  public static Weight getDefault(double value) {
    return new Weight(value, Unit.G);
  }
}
