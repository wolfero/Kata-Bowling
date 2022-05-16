import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingShould {
    @Test
    public void miss_all_pins_in_all_rolls() {
        var game = new Bowling();

        game.roll(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        assertThat(game.finalScore()).isEqualTo(0);
    }
}
