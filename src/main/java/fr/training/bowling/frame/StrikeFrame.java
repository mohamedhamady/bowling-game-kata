package fr.training.bowling.frame;

import static fr.training.bowling.Constants.NUMBER_OF_PINS;
import static fr.training.bowling.Constants.NUMBER_OF_STRIKE_BONUS_ROLLS;
import static fr.training.bowling.Constants.NUMBER_OF_STRIKE_FRAME_ROLLS;

import fr.training.bowling.Roll;

public final class StrikeFrame extends BaseFrame {

  private Roll roll;

  public StrikeFrame(int frameIndex) {
    super(frameIndex);
    this.roll = new Roll(NUMBER_OF_PINS);
  }

  @Override
  public int getNumberOfKnockedPins() {
    return roll.getNumberOfKnockedPins();
  }

  @Override
  public int getNumberOfPinsKnockedInFirstRoll() {
    return roll.getNumberOfKnockedPins();
  }

  @Override
  public int getNumberOfRolls() {
    return NUMBER_OF_STRIKE_FRAME_ROLLS;
  }

  @Override
  public int getNumberOfBonusRolls() {
    return NUMBER_OF_STRIKE_BONUS_ROLLS;
  }

}