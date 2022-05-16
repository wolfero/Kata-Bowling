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
            } else if(isSpare(currentRoll)){
                score += strike + rollScore(currentRoll + 2);
                currentRoll+=2;
            }
        }
        return score;
    }

    private boolean isSpare(int currentRoll) {
        return rollScore(currentRoll) + rollScore(currentRoll + 1) == strike;
    }

    private boolean isStrike(int currentRoll) {
        return rollScore(currentRoll) == strike;
    }

    private Integer rollScore(int currentRoll) {
        return rolls.get(currentRoll);
    }
}
