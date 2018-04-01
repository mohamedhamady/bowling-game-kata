package fr.training.bowling;

import static com.google.common.base.Preconditions.checkArgument;
import static fr.training.bowling.Constants.NUMBER_OF_PINS;

public class Roll {

  private int numberOfKnockedPins;

  public Roll(int numberOfKnockedPins) {
    checkArgument(numberOfKnockedPins <= NUMBER_OF_PINS && numberOfKnockedPins >= 0,
        String.format("Number of knocked pins must be in the interval [0, %s] ", NUMBER_OF_PINS));
    this.numberOfKnockedPins = numberOfKnockedPins;
  }

  public int getNumberOfKnockedPins() {
    return this.numberOfKnockedPins;
  }

}