package com.petquiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the static logic methods of QuizEngine.
 */
class QuizEngineTest {

    @Test
    void validOptionsAreAcceptedInUpperAndLowerCase() {
        assertTrue(QuizEngine.isValidOption("A"));
        assertTrue(QuizEngine.isValidOption("b"));
        assertTrue(QuizEngine.isValidOption("C"));
        assertTrue(QuizEngine.isValidOption(" c "));
    }

    @Test
    void invalidOptionsAreRejected() {
        assertFalse(QuizEngine.isValidOption("D"));
        assertFalse(QuizEngine.isValidOption("AB"));
        assertFalse(QuizEngine.isValidOption("1"));
        assertFalse(QuizEngine.isValidOption(""));
        assertFalse(QuizEngine.isValidOption(null));
    }

    @Test
    void percentageIsCalculatedCorrectly() {
        assertEquals(80.0, QuizEngine.calculatePercentage(4, 5), 0.001);
        assertEquals(100.0, QuizEngine.calculatePercentage(5, 5), 0.001);
        assertEquals(0.0, QuizEngine.calculatePercentage(0, 5), 0.001);
        assertEquals(0.0, QuizEngine.calculatePercentage(0, 0), 0.001);
    }

    @Test
    void lowRangeUsesTheSameMessage() {
        String low = QuizEngine.getFeedbackMessage(0.0);
        assertEquals(low, QuizEngine.getFeedbackMessage(33.0));
        assertEquals(low, QuizEngine.getFeedbackMessage(33.33));
    }

    @Test
    void boundaryBetween33And34ChangesTheMessage() {
        assertNotEquals(QuizEngine.getFeedbackMessage(33.0),
                QuizEngine.getFeedbackMessage(34.0));
    }

    @Test
    void mediumAndHighRangesAreSeparated() {
        assertEquals(QuizEngine.getFeedbackMessage(34.0),
                QuizEngine.getFeedbackMessage(66.0));
        assertNotEquals(QuizEngine.getFeedbackMessage(66.0),
                QuizEngine.getFeedbackMessage(67.0));
        assertEquals(QuizEngine.getFeedbackMessage(67.0),
                QuizEngine.getFeedbackMessage(99.0));
    }

    @Test
    void perfectScoreHasItsOwnMessage() {
        assertNotEquals(QuizEngine.getFeedbackMessage(99.0),
                QuizEngine.getFeedbackMessage(100.0));
    }
}