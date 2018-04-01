
package fr.training.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BowlingGameTest {

  private static final String MISS_ALL_ROLLS = "--------------------";
  private static final String PERFECT_GAME = "XXXXXXXXXXXX";
  private static final String _10_PAIRS_OF_9_AND_MISS = "9-9-9-9-9-9-9-9-9-9-";
  private static final String _10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5 = "5/5/5/5/5/5/5/5/5/5/5";

  private BowlingGame bowlingGame;

  @BeforeEach
  void setup() {
    this.bowlingGame = new BowlingGame();
  }

  static Stream<Object[]> testCases() {
    return Stream.of(new Object[][]{
        {MISS_ALL_ROLLS, 0},
        {PERFECT_GAME, 300},
        {_10_PAIRS_OF_9_AND_MISS, 90},
        {_10_PAIRS_OF_5_AND_SPARE_WITH_A_FINAL_5, 150}
    });
  }

  @ParameterizedTest
  @MethodSource("testCases")
  void testScoreWithParameterizedData(String rollsAsString, int expectedScore) {

    // Given rollsAsString

    // When
    int score = this.bowlingGame.score(rollsAsString);

    // Then
    assertEquals(score, expectedScore);
  }

}
