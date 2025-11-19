package dev.razafindratelo.wallet;

public class Health {
  private Health() {
    throw new UnsupportedOperationException("Utility class");
  }

  public static String getHealthStatus() {
    return "OK";
  }
}
