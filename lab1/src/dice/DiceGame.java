package dice;

import java.util.List;
import java.util.Random;

public class DiceGame {
    public static final int MAX_WINS = 7;
    private static final Random random = new Random();

    // Метод для броска кубиков
    public static int rollDice(int numDice) {
        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += random.nextInt(6) + 1;
        }
        return total;
    }

    // Метод для определения индекса победителя
    public static int getWinnerIndex(List<Integer> rolls) {
        int maxRoll = rolls.get(0);
        int winnerIndex = 0;
        for (int i = 1; i < rolls.size(); i++) {
            if (rolls.get(i) > maxRoll) {
                maxRoll = rolls.get(i);
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}
