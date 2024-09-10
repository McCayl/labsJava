import dice.DiceGame;
import dice.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static dice.DiceGame.*;

public class MainTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получаем количество игроков и кубиков от пользователя
        System.out.print("Введите количество игроков: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Введите количество кубиков: ");
        int numDice = scanner.nextInt();

        // Создаем список игроков
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new Player("Игрок " + i));
        }

        // Инициализируем игру
        int currentPlayerIndex = 0;

        // Основной цикл игры
        while (true) {
            System.out.println("\nНовый кон!");

            // Каждый игрок бросает кубики
            List<Integer> rolls = new ArrayList<>();
            for (Player value : players) {
                int roll = DiceGame.rollDice(numDice);
                rolls.add(roll);
                System.out.println(value.getName() + " выбросил: " + roll);
            }

            // Определяем победителя кона
            int winnerIndex = DiceGame.getWinnerIndex(rolls);

            // Если ничья, повторяем бросок
            while (winnerIndex == -1) {
                System.out.println("Ничья! Перебрасываем кубики.");
                rolls.clear();
                for (Player player : players) {
                    int roll = DiceGame.rollDice(numDice);
                    rolls.add(roll);
                    System.out.println(player.getName() + " выбросил: " + roll);
                }
                winnerIndex = DiceGame.getWinnerIndex(rolls);
            }

            Player winner = players.get(winnerIndex);
            winner.addWin();
            System.out.println(winner.getName() + " выиграл кон!");

            // Проверяем, выиграл ли кто-то игру
            if (winner.getWins() >= MAX_WINS) {
                System.out.println("\n" + winner.getName() + " выиграл игру!");
                break;
            }

            // Передаем ход победителю
            currentPlayerIndex = winnerIndex;
        }

        scanner.close();
    }
}
