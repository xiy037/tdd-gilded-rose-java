package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AgedBrieTest {
  private static AgedBrie agedBrie;

  @BeforeAll
  public static void init_product() {
    agedBrie = new AgedBrie(2, 10, 30, LocalDateTime.of(2020, 1, 1, 12, 0));
  }

  @Test
  public void should_return_increased_quality_when_sellIn_decrease() throws DateException {
    agedBrie.calculateSellIn(LocalDateTime.of(2020, 1, 3, 12, 0));
    long quality = agedBrie.calculateQuality();
    assertEquals(32, quality);
  }

  @Test
  public void should_return_50_when_quality_exceeds_50() throws DateException {
    agedBrie.calculateSellIn(LocalDateTime.of(2020, 5, 3, 12, 0));
    long quality = agedBrie.calculateQuality();
    assertEquals(50, quality);
  }

}