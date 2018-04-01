package fr.training.bowling;

import fr.training.bowling.frame.BaseFrame;
import java.util.List;

public class BowlingGame {

  public int score(String rollsAsString) {
    List<BaseFrame> frames = new LineParser().parse(rollsAsString);
    Line line = new Line(frames);
    return line.computeScore();
  }

}
