package cs5004.questionnaire;

/**
 * Enum representing all the possible answers to a likert question.
 */
enum LikertResponseOption {
  STRONGLY_DISAGREE(-2, "Strongly Disagree"),
  DISAGREE(-1, "Disagree"),
  NEUTRAL(0, "Neither Agree Nor Disagree"),
  AGREE(1, "Agree"),
  STRONGLY_AGREE(2, "Strongly Agree");

  public final int val;
  public final String txt;

  /**
   * Construct a likereponseoption.
   *
   * @param val the value of question.
   * @param txt the text of queswtion.
   */
  LikertResponseOption(int val, String txt) {
    this.val = val;
    this.txt = txt;
  }

  int getValue() {
    return val;
  }

  String getText() {
    return txt;
  }
}