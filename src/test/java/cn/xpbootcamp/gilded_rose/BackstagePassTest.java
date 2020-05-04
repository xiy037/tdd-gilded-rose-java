package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassTest {
  private static BackstagePass ticket;
  private static BackstagePass ticket2;

  @BeforeAll
  public static void init_product() {
    ticket = new BackstagePass(4, 15, 40, LocalDateTime.of(2020, 1, 1, 12, 0));
    ticket2 = new BackstagePass(5, 15, 10, LocalDateTime.of(2020,1, 1, 12, 0));
  }

  @Test
  public void should_return_quality_increased_by_one_when_sellIn_larger_than_ten() throws DateException {
    long sellIn = ticket.calculateSellIn(LocalDateTime.of(2020, 1, 3, 12, 0));
    long quality = ticket.calculateQuality();

    assertEquals(13, sellIn);
    assertEquals(42, quality);
  }

  @Test
  public void sellIn_between_ten_and_five() throws DateException {
    long sellIn = ticket.calculateSellIn(LocalDateTime.of(2020, 1, 7, 12, 0));
    long quality = ticket.calculateQuality();

    assertEquals(9, sellIn);
    assertEquals(47, quality);
  }

  @Test
  public void sellIn_between_five_and_zero() throws DateException {
    long sellIn = ticket2.calculateSellIn(LocalDateTime.of(2020, 1, 12, 12, 0));
    long quality = ticket2.calculateQuality();

    assertEquals(4, sellIn);
    assertEquals(28, quality);
  }

  @Test
  public void sellIn_is_zero() throws DateException {
    long sellIn = ticket2.calculateSellIn(LocalDateTime.of(2020, 1, 16, 12, 0));
    long quality = ticket2.calculateQuality();

    assertEquals(0, sellIn);
    assertEquals(40, quality);
  }

  @Test
  public void sellIn_below_zero() throws DateException {
    long sellIn = ticket2.calculateSellIn(LocalDateTime.of(2020, 1, 16, 14, 0));
    long quality = ticket2.calculateQuality();

    assertEquals(-1, sellIn);
    assertEquals(0, quality);
  }
}