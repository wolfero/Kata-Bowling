import java.util.List;

public class Spare {
    public boolean validate(int frameScore) {
        return frameScore == 10;
    }

    public int score(List<Integer> rolls, int rollIndex) {
        return 10 + rolls.get(rollIndex + 2);
    }
}
