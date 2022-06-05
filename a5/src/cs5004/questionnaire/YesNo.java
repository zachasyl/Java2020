package cs5004.questionnaire;

/**
 * This class represents a YesNo Question and its methods.
 */
public class YesNo implements Question {

  private String question;
  private String answer;
  private boolean required;

  /**
   * Construct a YesNo object that has the provided string queswtion and boolean.
   *
   * @param question the question posed by this object.
   * @param required a boolean representing whether question must be answered.
   */
  public YesNo(String question, boolean required) {
    this.question = question;
    this.required = required;
    // initializes as empty that way even if an exception is thrown we will still
    // have an empty answer to use for purpose of is required() (as it may not be).
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

    if (answer == null) {
      throw new IllegalArgumentException("no null");
    }

    if (!(answer.equalsIgnoreCase("yes"))
            && !(answer.equalsIgnoreCase("no"))) {
      throw new IllegalArgumentException("must be yes or no");

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
  public YesNo copy() {
    YesNo x = new YesNo(question, required);
    x.answer = answer;
    return x;
  }
}

