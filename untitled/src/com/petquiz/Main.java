package com.petquiz;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Entry point of the PetQuiz game. It controls the replay loop and shows
 * the statistics of all the games played before exiting.
 */
public class Main {

    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Starts the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuizEngine engine = new QuizEngine(new QuestionBank(), scanner);

        System.out.println("===== Welcome to PetQuiz =====");
        System.out.println("Learn how to take care of your pet and why adopting is a great idea!");

        boolean playAgain;
        do {
            engine.playGame();
            playAgain = engine.askPlayAgain();
        } while (playAgain);

        showStatistics(engine.getGameRecords());
        scanner.close();
    }

    /**
     * Shows the statistics of all the games played.
     *
     * @param records the list of game records
     */
    private static void showStatistics(List<GameRecord> records) {
        System.out.println("\n===== GAME STATISTICS =====");
        if (records.isEmpty()) {
            System.out.println("No games were played.");
        }
        for (GameRecord record : records) {
            System.out.printf("Player: %s | Finished: %s | Correct: %d | Incorrect: %d%n",
                    record.getUsername(),
                    record.getEndDateTime().format(DATE_FORMAT),
                    record.getCorrectAnswers(),
                    record.getIncorrectAnswers());
        }
        System.out.println("\nThank you for playing. Remember: adopt, don't buy!");
    }
}