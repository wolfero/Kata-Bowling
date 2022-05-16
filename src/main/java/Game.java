import java.util.ArrayList;
import java.util.List;

public class Game {
    public void roll(List<Integer> rolls) {
        for (int pinsDown : rolls) {
            saveRoll(pinsDown);
        }
    }

    private final List<Integer> rolls = new ArrayList<>();

    private void saveRoll(int pinsDown) {
        rolls.add(pinsDown);
    }

    private final int maxFrames = 10;
    private final int strike = 10;

    public int finalScore() {
        var score = 0;
        var currentRoll = 0;
        for (int frame = 0; frame < maxFrames; frame++) {
            if (isStrike(currentRoll)) {
                score += strike + rollScore(currentRoll + 1) + rollScore(currentRoll + 2);
                currentRoll++;
            }
        }

        return score;
    }

    private boolean isStrike(int currentRoll) {
        return rollScore(currentRoll) == strike;
    }

    private Integer rollScore(int cursor) {
        return rolls.get(cursor);
    }
}
