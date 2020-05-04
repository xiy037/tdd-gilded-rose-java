package cn.xpbootcamp.gilded_rose;

public class DateException extends Exception {
  public DateException() {
    super("Now time should be after startDate");
  }
}
