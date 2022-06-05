package cs5004.questionnaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;


/**
 * This class represents a Questionnaire which contains questions. It is the implementation of
 * Questionnaire.
 */
public class QuestionnaireImpl implements Questionnaire {
  List<Question> questionList = new ArrayList<>();
  List<String> identifierList = new ArrayList<String>();


  /**
   * Construct a Questionnaire object. This object has a questionList.
   */
  public QuestionnaireImpl() {
    this.questionList = questionList;

  }

  /**
   * Adds a question to the questionnaire.
   *
   * @param identifier the string that IDs question.
   * @param q          the question.
   */
  public void addQuestion(String identifier, Question q) {
    if ("".equals(identifier) || identifier == null || q == null) {
      throw new IllegalArgumentException("identifier is mandatory");
    }
    //prevents duplicate identifiers
    for (int i = 0; i < identifierList.size(); i++) {
      if (identifierList.get(i) == identifier) {
        throw new IllegalArgumentException("That identifier already exists");
      }
    }

    this.questionList.add(q);
    this.identifierList.add(identifier);

  }

  @Override
  public void removeQuestion(String identifier) {

    for (int i = 0; i < identifierList.size(); i++) {

      if (identifierList.get(i) == identifier) {
        questionList.remove(i);
      }
    }
  }

  @Override
  public Question getQuestion(int num) {
    for (int i = 0; i < identifierList.size(); i++) {

      if (i == num - 1) {
        return questionList.get(i);
      }
    }
    return null;
  }

  @Override
  public Question getQuestion(String identifier) {
    for (int i = 0; i < identifierList.size(); i++) {

      if (identifierList.get(i) == identifier) {
        return questionList.get(i);

      }
    }
    return null;
  }

  @Override
  public List<Question> getRequiredQuestions() {
    List<Question> required = new ArrayList<Question>();

    for (int i = 0; i < questionList.size(); i++) {

      if (questionList.get(i).isRequired()) {
        required.add(questionList.get(i));
      }
    }
    return required;
  }

  @Override
  public List<Question> getOptionalQuestions() {
    List<Question> optional = new ArrayList<Question>();

    for (int i = 0; i < questionList.size(); i++) {

      if (!questionList.get(i).isRequired()) {
        optional.add(questionList.get(i));
      }
    }
    return optional;
  }

  @Override
  public boolean isComplete() {
    List<Question> complete = new ArrayList<Question>();
    complete = getRequiredQuestions();

    for (int i = 0; i < complete.size(); i++) {

      if (complete.get(i).getAnswer().equals("")) {
        return false;
      }
    }
    return true;
    // Report if all required questions have some non-empty response.
  }

  @Override
  public List<String> getResponses() {
    List<String> responses = new ArrayList<String>();


    for (int i = 0; i < questionList.size(); i++) {

      responses.add(questionList.get(i).getAnswer());
    }

    return responses;
  }

  @Override
  public Questionnaire filter(Predicate<Question> pq) {
    QuestionnaireImpl filter = new QuestionnaireImpl();

    for (int i = 0; i < questionList.size(); i++) {
      filter.questionList.add((Question) pq);
    }

    return filter;
  }

  @Override
  public void sort(Comparator<Question> comp) {
    Collections.sort(questionList, comp);
  }

  @Override
  public <R> R fold(BiFunction<Question, R, R> bf, R seed) {
    return null;
  }

  @Override
  public String toString() {


    String x = "";
    for (int i = 0; i < questionList.size(); i++) {


      if (i < questionList.size() - 1) {
        x +=
                "Question: " + questionList.get(i).getPrompt().toString() + "\n\n" +
                        "Answer: " + questionList.get(i).getAnswer().toString() + "\n\n";
        // prevents double space after last answer is printed.
      } else {
        x +=
                "Question: " + questionList.get(i).getPrompt().toString() + "\n\n" +
                        "Answer: " + questionList.get(i).getAnswer().toString();
      }
    }
    return x;
  }
}