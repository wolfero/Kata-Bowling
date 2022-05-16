import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingGameShould {
    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void miss_all_pins_in_all_rolls() {
        roll(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.finalScore()).isEqualTo(0);
    }

    @Test
    public void make_strike_and_sum_the_following_two_rolls() {
        roll(List.of(10, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.finalScore()).isEqualTo(26);
    }

    @Test
    public void make_spare_and_sum_the_following_roll() {
        roll(List.of(6, 4, 5, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        assertThat(game.finalScore()).isEqualTo(24);
    }

    @Test
    public void make_real_game_rolls_and_get_their_score() {
        roll(List.of(6, 4, 5, 4, 10, 10, 5, 5, 6, 4, 4, 0, 6, 2, 2, 0, 10, 5, 4));

        assertThat(game.finalScore()).isEqualTo(132);
    }

    private void roll(List<Integer> rolls) {
        for (int pinsDown : rolls) {
            game.saveRoll(pinsDown);
        }
    }
}
