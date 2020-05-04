package cn.xpbootcamp.gilded_rose;

import java.time.Duration;
import java.time.LocalDateTime;

public class Product {
  //TODO: sellIn, quality, startDate, originalSellIn, originalQuality
  /**
   * ExpDate - Now = sellIn, so sellIn is a changeable property, method: calculateSellIn(LocalDate now);
   * Quality will change with sellIn time using method: calculateQuality();
   */

  private long produceId;
  private long sellIn;
  private long quality;
  private LocalDateTime startDate;
  private long originalSellIn;
  private long originalQuality;

  public Product(long id, long originalSellIn, long originalQuality, LocalDateTime startDate) {
    this.produceId = id;
    this.originalSellIn = originalSellIn;
    this.originalQuality = originalQuality;
    this.startDate = startDate;
  }

  public long getSellIn() {
    return sellIn;
  }

  public void setSellIn(long sellIn) {
    this.sellIn = sellIn;
  }

  public long getQuality() {
    return quality;
  }

  public void setQuality(long quality) {
    this.quality = quality;
  }

  public long calculateSellIn(LocalDateTime now) throws DateException {
    long result = 0;
    if (now.isBefore(this.startDate)) {
      throw new DateException();
    } else {
      int daysDiff = (int)Math.ceil((double)Duration.between(startDate, now).toHours() / 24);
      result = this.originalSellIn - daysDiff;
      setSellIn(result);
    }
    return result;
  }


  public long calculateQuality() {
    long daysDiff = this.originalSellIn - this.sellIn;
    long quality = this.sellIn > 0 ? (this.originalQuality - daysDiff )
            : (this.originalQuality - this.originalSellIn - Math.abs(this.sellIn) * 2);
    quality = quality < 0 ? 0 : quality;
    return quality;
  }
}
