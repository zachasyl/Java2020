
package cs5004.questionnaire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for QuestionnaireImpl.
 */
public class QuestionnaireImplTest {


  /**
   * Tests that a question can be added to a YN object.
   */
  @org.junit.Test
  public void testAddQuestionYNGood() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new YesNo("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("yes");
    assertEquals("Do you like cheese?", theQuestions.questionList.get(0).getPrompt().toString());
  }

  /**
   * Tests that a question can be added to a YN object past index 0.
   */
  @org.junit.Test
  //testing we can add to array past first element index 0
  public void testAddQuestionYNGood2() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new YesNo("Do you like cheese?", true);
    Question cheese2 = new YesNo("Do you like cheese2?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("cheese2", cheese2);
    assertEquals("Do you like cheese2?",
            theQuestions.questionList.get(1).getPrompt().toString());
  }

  /**
   * Tests that an illegalargument is thrown if YS isnt answered yes or no.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionBad() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new YesNo("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("maybe");
    System.out.print(theQuestions.questionList.get(0).getPrompt());

  }

  /**
   * Tests that a question can be added to a short answer object.
   */
  @org.junit.Test
  public void testAddQuestionShortAnswerGood() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new ShortAnswer("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("yes I do");

    assertEquals("Do you like cheese?", theQuestions.questionList.get(0).getPrompt());
  }

  /**
   * Tests that an illegal argument is thrown if the answer isnt short.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionShortAnswerBad() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new ShortAnswer("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("AaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaa"
            +
            "aAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaa"
            +

            "aaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaa"
            +
            "aaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaa"
            +
            "aaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaaAaaaaaaaaa");
  }

  /**
   * Tests that an illegal argument exception is thrown if answer is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionShortAnswerNull() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new ShortAnswer("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer(null);
  }

  /**
   * Tests that a question can be added to a linkert object. Also tests getPrompt().
   */
  @org.junit.Test
  public void testAddQuestionLinkertGood() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("Disagree");
    assertEquals("Do you like cheese?", theQuestions.questionList.get(0).getPrompt());
  }

  /**
   * Tests that linkert illegal argument is thrown when answer isnt an enum.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionLinkertBad() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("idk");

  }

  /**
   * Tests that linkert illegal argument is thrown when answer isnt an enum (when its empty).
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionLinkertBad2() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("");

  }

  /**
   * Tests that linkert illegal argument is thrown for linkert when answer is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddQuestionLinkertBad3() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer(null);

  }

  /**
   * Tests that a question can be removed from linkert.
   */
  @org.junit.Test
  // expected to be out of bound since index 0, only item, is removed.
  public void testRemoveQuestion() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("Disagree");

    theQuestions.removeQuestion("cheese");
    assertEquals("", theQuestions.toString());

    //theQuestions.questionList.get(0).getPrompt().
  }

  /**
   * Tests that a question can be removed from yesno.
   */
  @org.junit.Test
  // expected to be out of bound since index 0, only item, is removed.
  public void testRemoveQuestio2n() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new YesNo("Do you like cheese?", true);

    theQuestions.addQuestion("cheese", cheese);
    cheese.answer("yes");

    theQuestions.removeQuestion("cheese");
    assertEquals("", theQuestions.toString());

    //theQuestions.questionList.get(0).getPrompt();
  }

  /**
   * Tests get question functionality.
   */
  @org.junit.Test
  public void testGetQuestionNum() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);
    Question apple = new Likert("Do you like apples?", true);
    Question banana = new Likert("Do you like bananas?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);
    assertEquals("Do you like bananas?", theQuestions.getQuestion(3).getPrompt());

  }

  /**
   * Tests get quesiton by id functionality.
   */
  @org.junit.Test
  public void testGetQuestionID() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();
    Question cheese = new Likert("Do you like cheese?", true);
    Question apple = new Likert("Do you like apples?", true);
    Question banana = new Likert("Do you like bananas?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);
    assertEquals("Do you like apples?",
            theQuestions.getQuestion("apples").getPrompt());

  }

  /**
   * Tests required list functionality.
   */
  @org.junit.Test
  public void testGetRequiredList() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new Likert("Do you like cheese?", true);
    Question apple = new Likert("Do you like apples?", true);
    Question banana = new Likert("Do you like bananas?", false);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    theQuestions.questionList = theQuestions.getRequiredQuestions();

    assertEquals("Question: Do you like cheese?\n" +
            "\n" +
            "Answer: \n" +
            "\n" +
            "Question: Do you like apples?\n" +
            "\n" +
            "Answer: ", theQuestions.toString());


  }

  /**
   * Tests optional list functionality.
   */
  @org.junit.Test
  public void testGetOptionalList() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new Likert("Do you like cheese?", true);
    Question apple = new Likert("Do you like apples?", true);
    Question banana = new Likert("Do you like bananas?", false);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    theQuestions.questionList = theQuestions.getOptionalQuestions();

    assertEquals("Question: Do you like bananas?\n" +
            "\n" +
            "Answer: ", theQuestions.toString());
  }

  /**
   * tests boolean returned by is complete.
   */
  @org.junit.Test
  public void testIsCompleteTrue() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new ShortAnswer("Do you like cheese?", true);
    Question apple = new ShortAnswer("Do you like apples?", true);
    Question banana = new ShortAnswer("Do you like bananas?", false);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    cheese.answer("Agree");
    apple.answer("Disagree");
    // the banana answer is NOT required so return will still be true
    banana.answer("");
    assertEquals(true, theQuestions.isComplete());
  }

  /**
   * tests boolean returned by is complete.
   */
  @org.junit.Test
  public void testIsCompleteFalse() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new ShortAnswer("Do you like cheese?", true);
    Question apple = new ShortAnswer("Do you like apples?", true);
    Question banana = new ShortAnswer("Do you like bananas?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    cheese.answer("");
    apple.answer("");
    banana.answer("");
    assertEquals(false, theQuestions.isComplete());

  }

  /**
   * tests get responses.
   */
  @org.junit.Test
  public void testGetResponses() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new ShortAnswer("Do you like cheese?", true);
    Question apple = new ShortAnswer("Do you like apples?", true);
    Question banana = new ShortAnswer("Do you like bananas?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    cheese.answer("I love cheese");
    apple.answer("apples are okay");
    banana.answer("every morning");
    assertEquals("[I love cheese, apples are okay, every morning]",
            theQuestions.getResponses().toString());
  }

  /**
   * tests tostring().
   */
  @org.junit.Test
  public void stringTest() {
    QuestionnaireImpl theQuestions = new QuestionnaireImpl();

    Question cheese = new ShortAnswer("Do you like cheese?", true);
    Question apple = new ShortAnswer("Do you like apples?", true);
    Question banana = new ShortAnswer("Do you like bananas?", true);

    theQuestions.addQuestion("cheese", cheese);
    theQuestions.addQuestion("apples", apple);
    theQuestions.addQuestion("banana", banana);

    cheese.answer("I love cheese");
    apple.answer("apples are okay");
    banana.answer("every morning");
    assertEquals("Question: Do you like cheese?\n" +
            "\n" +
            "Answer: I love cheese\n" +
            "\n" +
            "Question: Do you like apples?\n" +
            "\n" +
            "Answer: apples are okay\n" +
            "\n" +
            "Question: Do you like bananas?\n" +
            "\n" +
            "Answer: every morning", theQuestions.toString());
  }

}









