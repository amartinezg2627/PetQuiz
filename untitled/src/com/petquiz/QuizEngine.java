package com.petquiz;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Manages the game logic: user interaction, input validation, scoring
 * and feedback messages. It also stores all the games played.
 */
public class QuizEngine {

    private static final int MIN_QUESTIONS = 5;
    private static final double MEDIUM_START = 34.0;
    private static final double HIGH_START = 67.0;
    private static final double PERFECT_SCORE = 100.0;

    // Feedback messages, easy to modify in the future
    private static final String MESSAGE_LOW =
            "Every pet lover starts somewhere! There is still a lot to learn about "
                    + "caring for animals, so give it another try.";
    private static final String MESSAGE_MEDIUM =
            "Good effort! You already know some basics about responsible pet ownership. "
                    + "A little more practice and you will be an expert.";
    private static final String MESSAGE_HIGH =
            "Great job! You clearly care about animals. Just a few more details "
                    + "and you will be a perfect pet guardian.";
    private static final String MESSAGE_PERFECT =
            "Perfect score! You are a true champion of responsible pet ownership. "
                    + "Animals are lucky to have you!";

    private final QuestionBank questionBank;
    private final Scanner scanner;
    private final ArrayList<GameRecord> gameRecords;

    /**
     * Creates the engine.
     *
     * @param questionBank the repository of questions
     * @param scanner      the scanner used to read the user input
     */
    public QuizEngine(QuestionBank questionBank, Scanner scanner) {
        this.questionBank = questionBank;
        this.scanner = scanner;
        this.gameRecords = new ArrayList<>();
    }

    /**
     * Plays one complete game and stores its result.
     */
    public void playGame() {
        String username = askUsername();
        String category = chooseCategory();
        int total = askNumberOfQuestions(questionBank.countByCategory(category));
        Question[] questions = questionBank.getRandomQuestions(category, total);

        int correct = 0;
        for (int i = 0; i < questions.length; i++) {
            if (askQuestion(questions[i], i + 1, total)) {
                correct++;
            }
        }

        int incorrect = total - correct;
        double percentage = calculatePercentage(correct, total);
        showResult(correct, incorrect, percentage);
        gameRecords.add(new GameRecord(username, LocalDateTime.now(), correct, incorrect));
    }

    /**
     * Asks the user if they want to play again.
     *
     * @return true if the user wants to play again, false to exit
     */
    public boolean askPlayAgain() {
        String input;
        do {
            System.out.print("\nDo you want to play again? (Y/N): ");
            input = scanner.nextLine().trim().toUpperCase();
            if (!input.equals("Y") && !input.equals("N")) {
                System.out.println("Invalid option. Please type Y or N.");
            }
        } while (!input.equals("Y") && !input.equals("N"));
        return input.equals("Y");
    }

    /**
     * Returns the games played so far.
     *
     * @return a copy of the list of game records
     */
    public List<GameRecord> getGameRecords() {
        return new ArrayList<>(gameRecords);
    }

    /**
     * Checks that the input is A, B or C, in upper or lower case.
     *
     * @param input the text typed by the user
     * @return true if the input is a valid option
     */
    public static boolean isValidOption(String input) {
        if (input == null) {
            return false;
        }
        String normalized = input.trim().toUpperCase();
        return normalized.equals("A") || normalized.equals("B") || normalized.equals("C");
    }

    /**
     * Calculates the percentage of correct answers.
     *
     * @param correct the number of correct answers
     * @param total   the total number of questions
     * @return the percentage from 0 to 100
     */
    public static double calculatePercentage(int correct, int total) {
        if (total <= 0) {
            return 0.0;
        }
        return correct * 100.0 / total;
    }

    /**
     * Returns the feedback message that matches a percentage.
     *
     * @param percentage the percentage of correct answers
     * @return the message for that score range
     */
    public static String getFeedbackMessage(double percentage) {
        if (percentage >= PERFECT_SCORE) {
            return MESSAGE_PERFECT;
        } else if (percentage >= HIGH_START) {
            return MESSAGE_HIGH;
        } else if (percentage >= MEDIUM_START) {
            return MESSAGE_MEDIUM;
        }
        return MESSAGE_LOW;
    }

    private String askUsername() {
        String username;
        do {
            System.out.print("Enter your username: ");
            username = scanner.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("The username cannot be empty.");
            }
        } while (username.isEmpty());
        return username;
    }

    private String chooseCategory() {
        String[] categories = questionBank.getCategories();
        System.out.println("\nChoose a category:");
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ") " + categories[i]);
        }
        int option = askIntInRange("Category number: ", 1, categories.length);
        return categories[option - 1];
    }

    private int askNumberOfQuestions(int maximum) {
        String prompt = "How many questions do you want to answer? ("
                + MIN_QUESTIONS + "-" + maximum + "): ";
        return askIntInRange(prompt, MIN_QUESTIONS, maximum);
    }

    private int askIntInRange(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // not a number: the error message below is shown
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    private boolean askQuestion(Question question, int number, int total) {
        System.out.println("\nQuestion " + number + "/" + total + ": " + question.getText());
        for (Answer answer : question.getAnswers()) {
            System.out.println(answer.getLabel() + ") " + answer.getText());
        }
        char chosen = askAnswer();
        boolean isCorrect = question.isCorrectAnswer(chosen);
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The right answer was " + findCorrectLabel(question) + ".");
        }
        return isCorrect;
    }

    private char askAnswer() {
        String input;
        do {
            System.out.print("Your answer (A/B/C): ");
            input = scanner.nextLine();
            if (!isValidOption(input)) {
                System.out.println("Invalid option. Please type A, B or C.");
            }
        } while (!isValidOption(input));
        return input.trim().toUpperCase().charAt(0);
    }

    private char findCorrectLabel(Question question) {
        for (Answer answer : question.getAnswers()) {
            if (answer.isCorrect()) {
                return answer.getLabel();
            }
        }
        return '?';
    }

    private void showResult(int correct, int incorrect, double percentage) {
        System.out.println("\n===== GAME OVER =====");
        System.out.println("Correct answers: " + correct);
        System.out.println("Incorrect answers: " + incorrect);
        System.out.println(String.format(Locale.ENGLISH, "Score: %.2f%%", percentage));
        System.out.println(getFeedbackMessage(percentage));
    }
}