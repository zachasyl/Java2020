package cs5004.questionnaire;

/**
 * This class represents a short answer Question and its methods.
 */
public class ShortAnswer implements Question {

  private String question;
  private String answer;
  private boolean required;

  /**
   * Construct a SA object that has the provided string queswtion and boolean.
   *
   * @param question the question posed by this object.
   * @param required a boolean representing whether question must be answered.
   */
  public ShortAnswer(String question, boolean required) {
    this.question = question;
    this.required = required;
    this.answer = "";
  }

  @Override
  public String getPrompt() {
    return question;
  }

  @Override
  public boolean isRequired() {
    return required;
  }


  @Override
  public String answer(String answer) {
    if (answer == null || answer.length() > 280) {
      throw new IllegalArgumentException("280 character limit");

    } else {
      this.answer = answer;
      return answer;
    }
  }

  @Override
  public String getAnswer() {
    return answer;

  }

  @Override
  public ShortAnswer copy() {
    ShortAnswer x = new ShortAnswer(question, required);
    x.answer = answer;
    return x;
  }
}