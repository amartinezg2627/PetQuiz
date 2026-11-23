package com.petquiz;

/**
 * Represents a single answer option of a quiz question.
 */
public class Answer {

    private final char label;
    private final String text;
    private final boolean correct;

    /**
     * Creates an answer option.
     *
     * @param label   the option label ('A', 'B' or 'C')
     * @param text    the text shown to the user
     * @param correct true if this option is the right answer
     */
    public Answer(char label, String text, boolean correct) {
        this.label = label;
        this.text = text;
        this.correct = correct;
    }

    public char getLabel() {
        return label;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }
}