package dev.razafindratelo.wallet;

public record Weight(double value, Unit unit) {

  public static Weight getDefault(double value) {
    return new Weight(value, Unit.G);
  }
}
