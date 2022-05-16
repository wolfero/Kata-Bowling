import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Integer> rolls = new ArrayList<>();

    public void saveRoll(int pinsDown) {
        rolls.add(pinsDown);
    }

    public int finalScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            Strike strike = new Strike();
            if (strike.validate(rolls, rollIndex)) {
                score += strike.sum(rolls, rollIndex);
                rollIndex++;
                continue;
            }

            Spare spare = new Spare();
            int frameScore = rolls.get(rollIndex) + rolls.get(rollIndex + 1);
            if (spare.validate(frameScore)) {
                score += spare.sum(rolls, rollIndex);
            } else {
                score += frameScore;
            }
            rollIndex += 2;
        }

        return score;
    }
}
