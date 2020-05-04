package cn.xpbootcamp.gilded_rose;

import java.time.LocalDateTime;

public class Sulfuras extends Product {

  public Sulfuras(long id, long originalQuality) {
    super(id, Long.MAX_VALUE, originalQuality, null);
  }

  @Override
  public long calculateSellIn(LocalDateTime now) throws DateException {
    return Long.MAX_VALUE;
  }

  @Override
  public long calculateQuality() {
    return getOriginalQuality();
  }
}
