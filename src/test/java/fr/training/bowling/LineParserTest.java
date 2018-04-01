package fr.training.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import fr.training.bowling.frame.BaseFrame;
import fr.training.bowling.frame.ExtraFrame;
import fr.training.bowling.frame.FullFrame;
import fr.training.bowling.frame.SpareFrame;
import fr.training.bowling.frame.StrikeFrame;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineParserTest {

  private LineParser lineParser;

  @BeforeEach
  void setup() {
    this.lineParser = new LineParser();
  }

  @Test
  void missAllRolls() {

    // Given
    String rollsAsString = "--------------------";

    // When
    List<BaseFrame> frames = lineParser.parse(rollsAsString);

    // Then
    assertThat(frames).hasSize(Constants.NUMBER_OF_FRAMES).allMatch(frame -> frame instanceof FullFrame);
  }

  @Test
  void perfectGame() {

    // Given
    String rollsAsString = "XXXXXXXXXXXX";

    // When
    List<BaseFrame> frames = lineParser.parse(rollsAsString);

    // Then
    assertThat(frames).hasSize(Constants.NUMBER_OF_FRAMES + 2);
    assertThat(frames.subList(0, Constants.NUMBER_OF_FRAMES)).allMatch(frame -> frame instanceof StrikeFrame);
    assertThat(frames.subList(Constants.NUMBER_OF_FRAMES, Constants.NUMBER_OF_FRAMES + 2))
    .allMatch(frame -> frame instanceof ExtraFrame);
  }

  @Test
  void _10PairsOf9AndMiss() {

    // Given
    String rollsAsString = "9-9-9-9-9-9-9-9-9-9-";

    // When
    List<BaseFrame> frames = lineParser.parse(rollsAsString);

    // Then
    assertThat(frames).hasSize(Constants.NUMBER_OF_FRAMES).allMatch(frame -> frame instanceof FullFrame);
  }

  @Test
  void _10PairsOf5AndSpareWithAFinal5() {

    // Given
    String rollsAsString = "5/5/5/5/5/5/5/5/5/5/5";

    // When
    List<BaseFrame> frames = lineParser.parse(rollsAsString);

    // Then
    assertThat(frames).hasSize(Constants.NUMBER_OF_FRAMES + 1);
    assertThat(frames.subList(0, Constants.NUMBER_OF_FRAMES)).allMatch(frame -> frame instanceof SpareFrame);
    assertThat(frames.subList(Constants.NUMBER_OF_FRAMES, Constants.NUMBER_OF_FRAMES + 1))
        .allMatch(frame -> frame instanceof ExtraFrame);
  }

}