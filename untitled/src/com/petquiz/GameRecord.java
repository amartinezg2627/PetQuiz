package com.petquiz;

import java.time.LocalDateTime;

/**
 * Stores the reslt of a completed game session.
 */
public class GameRecord {

    private final String username;
    private final LocalDateTime endDateTime;
    private final int correctAnswers;
    private final int incorrectAnswers;

    /**
     * Create a game record.
     *
     * @param username              the player's name
     * @param endDateTime           date and time when the game ended
     * @param correctAnswers        number of correct answer
     * @param incorrectAnswers      number of incorrect answers
     */
    public GameRecord(String username, LocalDateTime endDateTime,
                      int correctAnswers, int incorrectAnswers){
        this.username = username;
        this.endDateTime = endDateTime;
        this.correctAnswers = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }
}