package com.petquiz;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Question class.
 */
class QuestionTest {

    private Question createQuestion() {
        Answer[] answers = {
                new Answer('A', "Option A", false),
                new Answer('B', "Option B", true),
                new Answer('C', "Option C", false)
        };
        return new Question("Sample question?", "Test category", answers);
    }

    @Test
    void correctAnswerIsRecognizedInUpperAndLowerCase() {
        Question question = createQuestion();
        assertTrue(question.isCorrectAnswer('B'));
        assertTrue(question.isCorrectAnswer('b'));
    }

    @Test
    void wrongAnswerIsRejected() {
        Question question = createQuestion();
        assertFalse(question.isCorrectAnswer('A'));
        assertFalse(question.isCorrectAnswer('C'));
    }

    @Test
    void questionNeedsExactlyThreeAnswers() {
        Answer[] twoAnswers = {
                new Answer('A', "Option A", true),
                new Answer('B', "Option B", false)
        };
        assertThrows(IllegalArgumentException.class,
                () -> new Question("Bad question?", "Test category", twoAnswers));
    }
}