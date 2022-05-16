import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingGameShould {
    @Test
    public void miss_all_pins_in_all_rolls() {
        var game = new Game();

        game.roll(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.finalScore()).isEqualTo(0);
    }
}
