import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingGameShould {
    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(0, List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
                Arguments.of(26, List.of(10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
                Arguments.of(24, List.of(6, 4, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)),
                Arguments.of(132, List.of(6, 4, 5, 4, 10, 10, 5, 5, 6, 4, 4, 0, 6, 2, 2, 0, 10, 5, 4)),
                Arguments.of(300, List.of(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void save_frames_and_calculate_the_final_score(int expectedScore, List<Integer> rolls) {
        Game game = new Game();

        game.saveRolls(rolls);

        assertThat(game.finalScore()).isEqualTo(expectedScore);
    }
}
