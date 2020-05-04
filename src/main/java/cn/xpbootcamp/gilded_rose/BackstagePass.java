package cn.xpbootcamp.gilded_rose;

import java.time.LocalDateTime;

/**
 * BackstagePass quality change rule:
 *sellIn >= 10, quality + 1/day;
 * 10 > sellIn >= 5, quality + 2/day;
 * 5>= sellIn >=0, quality + 3/day;
 * sellIn<0, quality = 0.
 */

public class BackstagePass extends Product {

  public BackstagePass(long id, long originalSellIn, long originalQuality, LocalDateTime startDate) {
    super(id, originalSellIn, originalQuality, startDate);
  }

  //TODO: override calculateQuality

  @Override
  public long calculateQuality() {
    long daysDiff = this.getOriginalSellIn() - this.getSellIn();
    long quality = this.getSellIn() >= 10 ? (this.getOriginalQuality() + daysDiff)
            : this.getSellIn() >= 5 ? (this.getOriginalQuality() + this.getOriginalSellIn() - 10 + (10 - this.getSellIn()) * 2)
            : this.getSellIn() >= 0 ? (this.getOriginalQuality() + this.getOriginalSellIn() - 10 + 5 * 2 + (5 - this.getSellIn()) * 3)
            : 0;
    quality = quality > 50 ? 50 : quality;
    this.setQuality(quality);
    return quality;
  }
}
