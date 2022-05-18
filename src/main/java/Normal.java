import java.util.List;

public class Normal {
    private final int score;

    public Normal(List<Integer> rolls, int rollIndex) {
        this.score = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

    public int score() {
        return this.score;
    }
}
