package fr.training.bowling.frame;

import static com.google.common.base.Preconditions.checkArgument;
import static fr.training.bowling.Constants.NUMBER_OF_SPARE_BONUS_ROLLS;
import static fr.training.bowling.Constants.NUMBER_OF_PINS;

public class SpareFrame extends FullFrame {

  public SpareFrame(int frameIndex, int firstRollKnockedPins, int secondRollKnockedPins) {
    super(frameIndex, firstRollKnockedPins, secondRollKnockedPins);
    checkArgument(firstRollKnockedPins + secondRollKnockedPins == NUMBER_OF_PINS,
        String.format("Number of knocked pins in Spare frame must be equals to %d", NUMBER_OF_PINS));
  }

  @Override
  public int getNumberOfBonusRolls() {
    return NUMBER_OF_SPARE_BONUS_ROLLS;
  }

}