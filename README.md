# PetQuiz

A console quiz game written in Java to raise awareness among children and young
people about responsible pet ownership and the importance of adopting instead of buying.

## Features

- Two categories with 20 questions each (40 in total):
  - Daily needs of your pet
  - Adoption and responsible ownership
- Each question has three answers (A, B or C). Upper and lower case are accepted.
- The user chooses the category and how many questions to answer (minimum 5).
  The questions are selected randomly, without repeating.
- Immediate feedback after each answer (correct or incorrect).
- A different final message for each score range (0-33%, 34-66%, 67-99% and 100%),
  with the percentage shown to 2 decimal places.
- Play again with a new category, or exit.
- Statistics of all the games played (username, date and time, correct and incorrect
  answers) are shown before exiting.

## Project structure

- `Answer`: data model for one answer option.
- `Question`: data model for a question with its category and three answers.
- `GameRecord`: data model for the result of a completed game.
- `QuestionBank`: static array with all the questions and random selection by category.
- `QuizEngine`: game logic, input validation, scoring and feedback messages.
  Stores the games played in an `ArrayList`.
- `Main`: entry point, replay loop and final statistics.

## How to run

1. Clone the repository.
2. Open the project with IntelliJ IDEA (JDK 17 or higher).
3. Run the `Main` class.

## Tests

Unit tests with JUnit 5 are located in the `test` folder (13 tests for `QuizEngine`,
`Question` and `QuestionBank`).

## Documentation

The `docs` folder contains:

- the program lifecycle flowchart,
- the UML class diagram,
- the software testing report (equivalence partitioning, boundary value analysis
  and decision table).

## Author

Your name here
