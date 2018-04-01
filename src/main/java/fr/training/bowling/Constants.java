package fr.training.bowling;

public final class Constants {

  public static final int NUMBER_OF_PINS = 10;
  public static final int NUMBER_OF_FRAMES = 10;

  /** Full frame is a frame with two rolls and it's score < NUMBER_OF_PINS */
  public static final int NUMBER_OF_FULL_FRAME_ROLLS = 2;
  public static final int NUMBER_OF_FULL_FRAME_BONUS_ROLLS = 0;

  public static final int NUMBER_OF_SPARE_BONUS_ROLLS = 1;

  public static final int NUMBER_OF_STRIKE_FRAME_ROLLS = 1;
  public static final int NUMBER_OF_STRIKE_BONUS_ROLLS = 2;

  /** Extra Frames */
  public static final int NUMBER_OF_EXTRA_FRAME_BONUS_ROLLS = 0;
  public static final int NUMBER_OF_EXTRA_FRAME_ROLLS = 1;

  /** Parser inputs */
  public static final char STRIKE = 'X';
  public static final char SPARE = '/';
  public static final char MISS = '-';

  private Constants() {

  }

}