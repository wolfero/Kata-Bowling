import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();

    public void saveRolls(List<Integer> rollsToSave) {
        rolls.addAll(rollsToSave);
    }

    public int finalScore() {
        int score = 0;
        final int maxFrames = 10;
        for (int frame = 0; frame < maxFrames; frame++) {
            score += calculateFinalScore();
        }
        return score;
    }

    private int rollIndex = 0;

    private int calculateFinalScore() {
        int score = 0;
        Strike strike = new Strike();
        var isStrike = strike.validate(rolls, rollIndex);
        if (isStrike) {
            score += strike.score(rolls, rollIndex);
            rollIndex++;
        } else {
            score += getSpareOrNormalScore();
            rollIndex += 2;
        }
        return score;
    }

    private int getSpareOrNormalScore() {
        Spare spare = new Spare();
        Normal normal = new Normal(rolls, rollIndex);
        final int normalScore = normal.score();

        var isSpare = spare.validate(normalScore);
        if (isSpare) {
            return spare.score(rolls, rollIndex);
        }

        return normalScore;
    }
}
