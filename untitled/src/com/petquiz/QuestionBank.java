package com.petquiz;

import java.util.Random;

/**
 * Central repository of quiz questions. It stores the full collection in a
 * static array and returns random questions by category.
 */
public class QuestionBank {

    /** Category about the daily care of a pet. */
    public static final String CATEGORY_DAILY = "Daily needs of your pet";
    /** Category about adoption and responsible ownership. */
    public static final String CATEGORY_ADOPTION = "Adoption and responsible ownership";

    private static final String[] CATEGORIES = {CATEGORY_DAILY, CATEGORY_ADOPTION};
    private static final Random RANDOM = new Random();

    /** Static collection with all the questions (20 per category). */
    private static final Question[] QUESTIONS = {
            // ---------- Daily needs of your pet ----------
            build(CATEGORY_DAILY, "How many times a day should an adult dog usually go for a walk?",
                    "Once a week", "Never, if it has a garden", "At least twice a day", 'C'),
            build(CATEGORY_DAILY, "What must a pet always have available?",
                    "Fresh water", "Only milk", "Fizzy drinks", 'A'),
            build(CATEGORY_DAILY, "Which food is dangerous for dogs?",
                    "Cooked rice", "Chocolate", "Plain cooked chicken", 'B'),
            build(CATEGORY_DAILY, "How often should a cat's litter box be cleaned?",
                    "Every day", "Once a month", "Only when the cat stops using it", 'A'),
            build(CATEGORY_DAILY, "Why do pets need regular visits to the vet?",
                    "To get new toys", "To make them tired", "To check their health and get vaccines", 'C'),
            build(CATEGORY_DAILY, "How can you keep an indoor cat happy?",
                    "Leave it alone all day", "Play with it and give it a scratching post", "Never let it move", 'B'),
            build(CATEGORY_DAILY, "Where should a pet sleep?",
                    "In a safe, quiet and comfortable place", "On the balcony in winter", "Inside a closed car", 'A'),
            build(CATEGORY_DAILY, "What should you do when it is very hot outside?",
                    "Leave your dog in a parked car", "Walk it at midday", "Give it shade and water, and walk early or late", 'C'),
            build(CATEGORY_DAILY, "Why is it good to brush a dog?",
                    "It keeps the coat clean and healthy", "It makes the dog bark less", "It is never necessary", 'A'),
            build(CATEGORY_DAILY, "How should you pick up a small pet, like a rabbit?",
                    "By the ears", "Supporting its body with both hands", "By the tail", 'B'),
            build(CATEGORY_DAILY, "Why do rabbits need hay and things to gnaw?",
                    "To make noise", "To avoid sleeping", "To wear down their teeth, which never stop growing", 'C'),
            build(CATEGORY_DAILY, "How much food should you give your pet?",
                    "The amount recommended for its age and size", "As much as it wants all day", "Only leftovers from your plate", 'A'),
            build(CATEGORY_DAILY, "What is a microchip for?",
                    "To make the pet run faster", "To cure diseases", "To identify the pet and find its owner if it gets lost", 'C'),
            build(CATEGORY_DAILY, "Why should puppies meet people and other animals?",
                    "To learn to behave calmly around them", "To grow bigger", "To stop eating", 'A'),
            build(CATEGORY_DAILY, "Which one is a sign that your pet might be ill?",
                    "It plays as usual", "It stops eating and seems very tired", "It drinks water normally", 'B'),
            build(CATEGORY_DAILY, "What should you do with your dog's poop during a walk?",
                    "Leave it on the sidewalk", "Hide it in the bushes", "Pick it up and throw it in a bin", 'C'),
            build(CATEGORY_DAILY, "Can you leave a pet alone for several weeks while the family travels?",
                    "Yes, if you leave a big bowl of food", "No, someone must take care of it", "Yes, if the TV is on", 'B'),
            build(CATEGORY_DAILY, "Which toy is safe for a dog?",
                    "Small pieces it can swallow", "An old shoe", "A toy of the right size that it cannot swallow", 'C'),
            build(CATEGORY_DAILY, "What helps a pet stay at a healthy weight?",
                    "Exercise and the right portions of food", "Lots of sweets", "Sleeping all day", 'A'),
            build(CATEGORY_DAILY, "What should you do before giving human medicine to a pet?",
                    "Give it half a pill", "Ask a vet first", "Nothing, it is the same", 'B'),

            // ---------- Adoption and responsible ownership ----------
            build(CATEGORY_ADOPTION, "Where can you adopt a pet?",
                    "In an animal shelter", "In a street market", "On a website with no information", 'A'),
            build(CATEGORY_ADOPTION, "Why is adopting a good idea?",
                    "Because it is a trend", "Because it gives a home to an animal that needs one", "Because it is a free toy", 'B'),
            build(CATEGORY_ADOPTION, "How long can a dog or a cat live?",
                    "A few weeks", "About one year", "Around 10 to 15 years or more", 'C'),
            build(CATEGORY_ADOPTION, "Who is responsible for a pet's care?",
                    "The owner, for its whole life", "Only the neighbours", "Nobody, animals take care of themselves", 'A'),
            build(CATEGORY_ADOPTION, "What is neutering or spaying useful for?",
                    "To make the pet louder", "To avoid unwanted litters and help the pet's health", "To change its colour", 'B'),
            build(CATEGORY_ADOPTION, "What should you do if you are tired of your pet?",
                    "Leave it on the street", "Give it away to anyone", "Look for a responsible new home or contact a shelter", 'C'),
            build(CATEGORY_ADOPTION, "Is a pet a good surprise gift?",
                    "No, the whole family must decide and be ready for it", "Yes, always", "Yes, if it is cheap", 'A'),
            build(CATEGORY_ADOPTION, "Which costs does owning a pet involve?",
                    "None, pets are free", "Food, vet visits and vaccines", "Only the first day", 'B'),
            build(CATEGORY_ADOPTION, "Why is abandoning a pet wrong?",
                    "It is only a small problem", "It is allowed if the pet is old", "It is illegal and puts the animal in danger", 'C'),
            build(CATEGORY_ADOPTION, "What should you do if you find a lost pet with a collar?",
                    "Try to contact its owner or take it to a vet to read the microchip", "Keep it without asking", "Ignore it", 'A'),
            build(CATEGORY_ADOPTION, "What should you think about before adopting?",
                    "Only the colour of the pet", "If you have time, space and money to care for it", "What your friends will say", 'B'),
            build(CATEGORY_ADOPTION, "Why should you avoid buying animals from illegal sellers?",
                    "They are always cheaper", "They give better pets", "The animals are often mistreated", 'C'),
            build(CATEGORY_ADOPTION, "What does a shelter usually do before an animal is adopted?",
                    "Check its health, vaccinate it and microchip it", "Nothing at all", "Teach it to talk", 'A'),
            build(CATEGORY_ADOPTION, "Can wild animals be kept as pets?",
                    "Yes, they adapt easily", "No, they need their natural habitat", "Yes, if they are small", 'B'),
            build(CATEGORY_ADOPTION, "Are adult dogs good for adoption?",
                    "No, they never learn", "No, they are always aggressive", "Yes, their personality is already known", 'C'),
            build(CATEGORY_ADOPTION, "What should you do if someone in your home is allergic to animals?",
                    "Talk to a doctor and spend time with the animal before adopting", "Adopt anyway", "Hide the problem", 'A'),
            build(CATEGORY_ADOPTION, "How can you help a shelter without adopting?",
                    "You cannot help", "By volunteering or donating food", "By buying a pet", 'B'),
            build(CATEGORY_ADOPTION, "Why is it good to spend time with an animal before adopting it?",
                    "To see if you get along and fit your lifestyle", "To get free food", "It is not necessary", 'A'),
            build(CATEGORY_ADOPTION, "What does a newly adopted pet need most?",
                    "To be left alone", "Patience, time to adapt and a routine", "Lots of visitors on the first day", 'B'),
            build(CATEGORY_ADOPTION, "What is the best attitude of a responsible owner?",
                    "Care for the pet only when it is fun", "Care for the pet only on weekends", "Commit to the pet's needs every day", 'C')
    };

    /**
     * Builds a question with three answers.
     *
     * @param category     the question category
     * @param text         the question text
     * @param a            text of option A
     * @param b            text of option B
     * @param c            text of option C
     * @param correctLabel label of the correct option ('A', 'B' or 'C')
     * @return the new question
     */
    private static Question build(String category, String text,
                                  String a, String b, String c, char correctLabel) {
        Answer[] answers = {
                new Answer('A', a, correctLabel == 'A'),
                new Answer('B', b, correctLabel == 'B'),
                new Answer('C', c, correctLabel == 'C')
        };
        return new Question(text, category, answers);
    }

    /**
     * Returns the available categories.
     *
     * @return a copy of the categories array
     */
    public String[] getCategories() {
        return CATEGORIES.clone();
    }

    /**
     * Counts how many questions a category has.
     *
     * @param category the category name
     * @return the number of questions in that category
     */
    public int countByCategory(String category) {
        int count = 0;
        for (Question question : QUESTIONS) {
            if (question.getCategory().equals(category)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns all the questions of a category.
     *
     * @param category the category name
     * @return an array with the questions of that category
     */
    public Question[] getQuestionsByCategory(String category) {
        Question[] result = new Question[countByCategory(category)];
        int index = 0;
        for (Question question : QUESTIONS) {
            if (question.getCategory().equals(category)) {
                result[index] = question;
                index++;
            }
        }
        return result;
    }

    /**
     * Selects random, non-repeated questions from a category.
     *
     * @param category the category name
     * @param amount   how many questions are needed
     * @return an array with the selected questions
     * @throws IllegalArgumentException if the amount is not valid for the category
     */
    public Question[] getRandomQuestions(String category, int amount) {
        Question[] pool = getQuestionsByCategory(category);
        if (amount < 1 || amount > pool.length) {
            throw new IllegalArgumentException("Invalid number of questions: " + amount);
        }
        // Fisher-Yates shuffle
        for (int i = pool.length - 1; i > 0; i--) {
            int j = RANDOM.nextInt(i + 1);
            Question temp = pool[i];
            pool[i] = pool[j];
            pool[j] = temp;
        }
        Question[] selected = new Question[amount];
        System.arraycopy(pool, 0, selected, 0, amount);
        return selected;
    }
}
