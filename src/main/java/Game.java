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
        if (strike.validate(rolls, rollIndex)) {
            score += strike.sum(rolls, rollIndex);
            rollIndex++;
        } else {
            score += getSpareOrNormalScore();
            rollIndex += 2;
        }
        return score;
    }

    private int getSpareOrNormalScore() {
        Spare spare = new Spare();
        Frame frame = new Frame(rolls, rollIndex);

        return (spare.validate(frame.score())) ?
                spare.sum(rolls, rollIndex) :
                frame.score();
    }
}
