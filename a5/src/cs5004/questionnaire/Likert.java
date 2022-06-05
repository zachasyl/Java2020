package cs5004.questionnaire;

/**
 * This class represents a Likert Question and its methods.
 */
public class Likert implements Question {

  private String question;
  private String answer;
  private boolean required;


  /**
   * Construct a Likert object that has the provided string queswtion and boolean.
   *
   * @param question the question posed by this object.
   * @param required a boolean representing whether question must be answered.
   */
  public Likert(String question, boolean required) {
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

    if (answer == null) {
      throw new IllegalArgumentException("Null not allowed");
    }
    // use loop to go through all enum values and compare
    for (LikertResponseOption linkert : LikertResponseOption.values()) {


      if (linkert.getText().toLowerCase().equals(answer.toLowerCase())) {
        this.answer = answer;
        //this.answer = linkert.getText();
        return answer;
      }

    }

    throw new IllegalArgumentException("Not allowed");
  }

  @Override
  public String getAnswer() {
    return answer;
  }

  @Override
  public Question copy() {
    Likert x = new Likert(question, required);
    x.answer = answer;
    return x;
  }
}

