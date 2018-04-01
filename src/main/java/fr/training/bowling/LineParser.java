package fr.training.bowling;

import static fr.training.bowling.Constants.MISS;
import static fr.training.bowling.Constants.NUMBER_OF_FRAMES;
import static fr.training.bowling.Constants.NUMBER_OF_PINS;
import static fr.training.bowling.Constants.SPARE;
import static fr.training.bowling.Constants.STRIKE;

import fr.training.bowling.frame.BaseFrame;
import fr.training.bowling.frame.ExtraFrame;
import fr.training.bowling.frame.FullFrame;
import fr.training.bowling.frame.SpareFrame;
import fr.training.bowling.frame.StrikeFrame;
import java.util.ArrayList;
import java.util.List;

public class LineParser {

  public List<BaseFrame> parse(String rollsAsString) {

    List<BaseFrame> frames = new ArrayList<>();

    int rollIndex = 0;
    int frameIndex = 0;
    while (rollIndex < rollsAsString.length()) {
      BaseFrame frame;
      if (this.isExtraFrame(frameIndex)) {
        frame = new ExtraFrame(frameIndex, getRollScore(rollIndex, rollsAsString));
        rollIndex++;
      } else {
        char scoreAsChar = rollsAsString.charAt(rollIndex);
        if (this.isStrike(scoreAsChar)) {
          frame = new StrikeFrame(frameIndex);
          rollIndex++;
        } else {
          int firstRollScore = getRollScore(rollIndex, rollsAsString);
          int secondRollScore = getRollScore(rollIndex + 1, rollsAsString);
          if (this.isSpare(firstRollScore, secondRollScore)) {
            frame = new SpareFrame(frameIndex, firstRollScore, secondRollScore);
          } else {
            frame = new FullFrame(frameIndex, firstRollScore, secondRollScore);
          }
          rollIndex += 2;
        }
      }
      frameIndex++;
      frames.add(frame);
    }
    return frames;
  }

  private int getRollScore(int rollIndex, String rollsAsString) {
    char rollAsChar = rollsAsString.charAt(rollIndex);
    int score;
    switch (rollAsChar) {
    case MISS:
      score = 0;
      break;
    case SPARE:
      score = NUMBER_OF_PINS - this.getRollScore(rollIndex - 1, rollsAsString);
      break;
    case STRIKE:
      score = NUMBER_OF_PINS;
      break;
    default:
      score = Character.getNumericValue(rollAsChar);
      break;
    }
    return score;
  }

  private boolean isStrike(char rollAsChar) {
    return STRIKE == rollAsChar;
  }

  private boolean isSpare(int firstRollScore, int secondRollScore) {
    return firstRollScore + secondRollScore == NUMBER_OF_PINS;
  }

  private boolean isExtraFrame(int frameIndex) {
    return frameIndex >= NUMBER_OF_FRAMES;
  }

}