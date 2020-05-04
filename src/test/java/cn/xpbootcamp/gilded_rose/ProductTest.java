package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
  private static Product product;

  @BeforeAll
  public static void init_product() {
    product = new Product(1, 15, 40, LocalDateTime.of(2020, 1, 1, 12, 0));
  }

  @Test
  public void should_return_new_sellIn() throws DateException {
    long sellIn = product.calculateSellIn(LocalDateTime.of(2020, 1, 3, 12, 0));
    assertEquals(13, sellIn);
  }

  @Test
  public void should_return_new_sellIn_02() throws DateException {
    long sellIn = product.calculateSellIn(LocalDateTime.of(2020, 1, 3, 0, 0));
    assertEquals(13, sellIn);
  }

  @Test
  public void should_return_new_sellIn_03() throws DateException {
    long sellIn = product.calculateSellIn(LocalDateTime.of(2020, 1, 3, 14, 0));
    assertEquals(12, sellIn);
  }

  @Test
  public void should_return_negative_sellIn() throws DateException {
    long sellIn = product.calculateSellIn(LocalDateTime.of(2020, 1, 16, 14, 0));
    assertEquals(-1, sellIn);
  }

  @Test
  public void should_return_quality_decreased_by_1_before_expiration() throws DateException {
    product.calculateSellIn(LocalDateTime.of(2020, 1, 3, 12, 0));
    long quality = product.calculateQuality();
    assertEquals(38, quality);
  }

  @Test
  public void should_return_quality_decreased_by_2_after_expiration() throws DateException {
    product.calculateSellIn(LocalDateTime.of(2020, 1, 17, 14, 0));
    long quality = product.calculateQuality();
    assertEquals(21, quality);
  }

  @Test
  public void should_return_zero_quality_when_it_reaches_negative() throws DateException {
    product.calculateSellIn(LocalDateTime.of(2020, 5, 1, 12, 0));
    product.calculateQuality();
    long quality = product.getQuality();
    assertEquals(0, quality);
  }

}