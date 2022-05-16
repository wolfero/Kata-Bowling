import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();


    public void saveRoll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int finalScore() {
        var score = 0;
        int rollIndex = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += strike(rollIndex);
                rollIndex++;
                continue;
            }

            var frameScore = sumFrameScore(rollIndex);
            if (isSpare(frameScore)) {
                score += spare(rollIndex);
            } else {
                score += frameScore;
            }

            rollIndex += 2;
        }
        return score;
    }

    private boolean isStrike(int currentRoll) {
        return rolls.get(currentRoll) == 10;
    }

    private int strike(int rollIndex) {
        return 10 + rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }

    private int sumFrameScore(int rollIndex) {
        return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
    }

    private boolean isSpare(int frameScore) {
        return frameScore == 10;
    }

    private int spare(int rollIndex) {
        return 10 + rolls.get(rollIndex + 2);
    }
}
