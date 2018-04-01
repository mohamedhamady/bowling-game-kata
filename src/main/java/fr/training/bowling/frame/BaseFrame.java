package fr.training.bowling.frame;

public abstract class BaseFrame {

  private int frameIndex;

  protected BaseFrame(int frameIndex) {
    this.frameIndex = frameIndex;
  }

  public int getFrameIndex() {
    return this.frameIndex;
  }

  public abstract int getNumberOfKnockedPins();

  public abstract int getNumberOfPinsKnockedInFirstRoll();

  public abstract int getNumberOfRolls();

  public abstract int getNumberOfBonusRolls();

}