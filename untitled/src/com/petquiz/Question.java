package com.petquiz;

/**
 * Represents a quiz question with its category and three answer options.
 */
public class Question {

    private static final int NUMBER_OF_ANSWERS = 3;

    private final String text;
    private final String category;
    private final Answer[] answers;

    /**
     * Creates a question.
     *
     * @param text     the question text
     * @param category the category the question belongs to
     * @param answers  exactly three answers, one of them correct
     * @throws IllegalArgumentException if the answers are not valid
     */
    public Question(String text, String category, Answer[] answers) {
        if (answers == null || answers.length != NUMBER_OF_ANSWERS) {
            throw new IllegalArgumentException("A question needs exactly 3 answers");
        }
        this.text = text;
        this.category = category;
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    /**
     * Checks whether the chosen label is the correct answer.
     *
     * @param label the label chosen by the user, in upper or lower case
     * @return true if the label matches the correct answer
     */
    public boolean isCorrectAnswer(char label) {
        char normalized = Character.toUpperCase(label);
        for (Answer answer : answers) {
            if (answer.getLabel() == normalized) {
                return answer.isCorrect();
            }
        }
        return false;
    }
}