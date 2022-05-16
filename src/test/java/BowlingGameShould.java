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

    @Test
    public void make_strike_and_sum_the_following_two_rolls() {
        var game = new Game();

        game.roll(List.of(10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.finalScore()).isEqualTo(18);
    }
}
