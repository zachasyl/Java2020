package cs5004.questionnaire;

/**
 * This interface represents a Question, whether it be likert, YesNo, ShortAnswer, or any.
 */
public interface Question {

  /**
   * Gets the prompt/actual question.
   *
   * @return the question as a string.
   */
  String getPrompt();

  /**
   * Determines if question is required to answer or not.
   *
   * @return true or false.
   */
  boolean isRequired();

  /**
   * Makes this.answer = answer parameter.
   *
   * @param answer the answer to question.
   * @return answer string.
   */
  String answer(String answer);

  /**
   * Returns the answer to question.
   *
   * @return answer string.
   */
  String getAnswer();

  /**
   * Creates a new question that is a copy.
   *
   * @return Question, an entirely new question with same attributes.
   */
  Question copy();


}
