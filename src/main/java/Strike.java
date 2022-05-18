import java.util.List;

public class Strike {
    private final int value = 10;

    public boolean validate(List<Integer> rolls, int currentRoll) {
        return rolls.get(currentRoll) == value;
    }

    public int score(List<Integer> rolls, int rollIndex) {
        return value + rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
    }
}
