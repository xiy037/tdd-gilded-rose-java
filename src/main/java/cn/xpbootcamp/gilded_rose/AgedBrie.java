package cn.xpbootcamp.gilded_rose;

import java.time.LocalDateTime;

//TODO: override calculateQuality() to increase quality when sellIn decrease;

public class AgedBrie extends Product {
  public AgedBrie(long id, long originalSellIn, long originalQuality, LocalDateTime startDate) {
    super(id, originalSellIn, originalQuality, startDate);
  }

  @Override
  public long calculateQuality() {
    return super.calculateQuality();
  }
}
