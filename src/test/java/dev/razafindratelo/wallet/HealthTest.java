package dev.razafindratelo.wallet;

import static dev.razafindratelo.wallet.Health.getHealthStatus;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HealthTest {
  @Test
  void should_get_okay_back() {
    assertEquals("OK", getHealthStatus());
  }
}
