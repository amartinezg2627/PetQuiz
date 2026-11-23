package com.petquiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the QuestionBank class.
 */
class QuestionBankTest {

    private final QuestionBank bank = new QuestionBank();

    @Test
    void eachCategoryHasTwentyQuestions() {
        assertEquals(20, bank.countByCategory(QuestionBank.CATEGORY_DAILY));
        assertEquals(20, bank.countByCategory(QuestionBank.CATEGORY_ADOPTION));
    }

    @Test
    void randomQuestionsHaveTheRequestedAmountAndNoDuplicates() {
        Question[] selected = bank.getRandomQuestions(QuestionBank.CATEGORY_DAILY, 5);
        Set<Question> unique = new HashSet<>();
        for (Question question : selected) {
            unique.add(question);
        }
        assertEquals(5, selected.length);
        assertEquals(5, unique.size());
    }

    @Test
    void invalidAmountsAreRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> bank.getRandomQuestions(QuestionBank.CATEGORY_DAILY, 0));
        assertThrows(IllegalArgumentException.class,
                () -> bank.getRandomQuestions(QuestionBank.CATEGORY_DAILY, 21));
    }
}