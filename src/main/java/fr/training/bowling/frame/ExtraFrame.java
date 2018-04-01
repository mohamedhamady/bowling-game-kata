package fr.training.bowling.frame;

import static fr.training.bowling.Constants.NUMBER_OF_EXTRA_FRAME_BONUS_ROLLS;
import static fr.training.bowling.Constants.NUMBER_OF_EXTRA_FRAME_ROLLS;
import fr.training.bowling.Roll;

public class ExtraFrame extends BaseFrame {

  private Roll roll;

  public ExtraFrame(int frameIndex, int numberOfKnockedPins) {
    super(frameIndex);
    this.roll = new Roll(numberOfKnockedPins);
  }

	@Override
	public int getNumberOfKnockedPins() {
		return this.roll.getNumberOfKnockedPins();
	}

	@Override
	public int getNumberOfPinsKnockedInFirstRoll() {
		return this.getNumberOfKnockedPins();
	}

	@Override
	public int getNumberOfRolls() {
		return NUMBER_OF_EXTRA_FRAME_ROLLS;
	}

	@Override
	public int getNumberOfBonusRolls() {
		return NUMBER_OF_EXTRA_FRAME_BONUS_ROLLS;
	}

}