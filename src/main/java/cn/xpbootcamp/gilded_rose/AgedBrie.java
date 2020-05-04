package cn.xpbootcamp.gilded_rose;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;

//TODO: override calculateQuality() to increase quality by 1 when sellIn decreases by 1;

public class AgedBrie extends Product {

  public AgedBrie(long id, long originalSellIn, long originalQuality, LocalDateTime startDate) {
    super(id, originalSellIn, originalQuality, startDate);
  }

  @Override
  public long calculateQuality() {
    long daysDiff = this.getOriginalSellIn() - this.getSellIn();
    long quality = this.getOriginalQuality() + daysDiff;
    quality = quality > 50 ? 50 : quality;
    this.setQuality(quality);
    return quality;
  }

}
