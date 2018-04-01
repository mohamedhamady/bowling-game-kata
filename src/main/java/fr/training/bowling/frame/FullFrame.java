package fr.training.bowling.frame;

import static com.google.common.base.Preconditions.checkArgument;
import static fr.training.bowling.Constants.NUMBER_OF_FULL_FRAME_BONUS_ROLLS;
import static fr.training.bowling.Constants.NUMBER_OF_FULL_FRAME_ROLLS;
import static fr.training.bowling.Constants.NUMBER_OF_PINS;

import fr.training.bowling.Constants;
import fr.training.bowling.Roll;

public class FullFrame extends BaseFrame {

  private Roll firstRoll;

  private Roll secondRoll;

  public FullFrame(int frameIndex, int firstRollKnockedPins, int secondRollKnockedPins) {
    super(frameIndex);

    checkArgument(firstRollKnockedPins + secondRollKnockedPins <= Constants.NUMBER_OF_PINS,
        String.format("frame score must be <= %d", NUMBER_OF_PINS));

    this.firstRoll = new Roll(firstRollKnockedPins);
    this.secondRoll = new Roll(secondRollKnockedPins);
  }

  @Override
  public int getNumberOfKnockedPins() {
    return firstRoll.getNumberOfKnockedPins() + secondRoll.getNumberOfKnockedPins();
  }

  @Override
  public int getNumberOfPinsKnockedInFirstRoll() {
    return firstRoll.getNumberOfKnockedPins();
  }

  @Override
  public int getNumberOfRolls() {
    return NUMBER_OF_FULL_FRAME_ROLLS;
  }

  @Override
  public int getNumberOfBonusRolls() {
    return NUMBER_OF_FULL_FRAME_BONUS_ROLLS;
  }

}