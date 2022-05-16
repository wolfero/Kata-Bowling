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

    public int finalScore() {
        return rolls.stream().mapToInt(score->score).sum();
    }
}
