package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {
  private static Sulfuras sulfuras;

  @BeforeAll
  public static void init_product() {
    sulfuras = new Sulfuras(3,  40);
  }

  @Test
  public void should_return_same_quality() {
    long quality = sulfuras.calculateQuality();
    assertEquals(40, quality);
  }
}