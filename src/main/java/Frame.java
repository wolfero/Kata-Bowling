import java.util.List;

public class Frame {
    private final int score;

    public Frame(List<Integer> rolls, int rollIndex) {
        this.score = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

    public int score() {
        return this.score;
    }
}
