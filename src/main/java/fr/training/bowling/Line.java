package fr.training.bowling;

import static fr.training.bowling.Constants.NUMBER_OF_FRAMES;

import fr.training.bowling.frame.BaseFrame;
import java.util.List;

public class Line {

  List<BaseFrame> frames;

  public Line(List<BaseFrame> frames) {
    this.frames = frames;
  }

  public int computeScore() {
    return this.frames.stream()
        .mapToInt(frame -> frame.getNumberOfKnockedPins() + this.computeBonus(frame))
        .limit(NUMBER_OF_FRAMES)
        .sum();
  }

  private int computeBonus(BaseFrame frame) {
    int bonus = 0;
    if (this.hasBonusRolls(frame)) {
      BaseFrame nextFrame = null;
      int bonusRollIndex = 0;
      while (bonusRollIndex < frame.getNumberOfBonusRolls()) {
        nextFrame = this.nextFrame(frame);
        if (bonusRollIndex + nextFrame.getNumberOfRolls() <= frame.getNumberOfBonusRolls()) {
          bonus += nextFrame.getNumberOfKnockedPins();
          bonusRollIndex += nextFrame.getNumberOfRolls();
        } else {
          bonus += nextFrame.getNumberOfPinsKnockedInFirstRoll();
          bonusRollIndex++;
        }
      }
    }
    return bonus;
  }

  private BaseFrame nextFrame(BaseFrame frame) {
    return this.frames.get(frame.getFrameIndex() + 1);
  }

  private boolean hasBonusRolls(BaseFrame frame) {
    return frame.getNumberOfBonusRolls() > 0;
  }

}