import java.util.Scanner;
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        final int hundred = 100;
        questions = new Question[hundred];
        size = 0;
    }
    /**
     *
     *
     * @param      q          The quarter
     *
     * @throws     Exception  { exception_description }
     */
    public void addQuestion(final Question q) throws Exception {
        if (q.getQuestionText().equals("")) {
            throw new Exception("Error! Malformed question");
        } else if (q.getChoice().length < 2) {
            throw new Exception(
                q.getQuestionText()
                + " does not have enough answer choices");
        } else if ((!("abcd1234".contains(
                          q.getCorrectAnswer().split(" ")[1]
                      )))) {
            throw new Exception(
                "Error! Correct answer choice number"
                + " is out of range for question text 1");
        } else if (q.getMaxMarks() < 0) {
            throw new Exception("Invalid max marks for "
                                + q.getQuestionText());
        } else if (q.getPenalty() > 0) {
            throw new Exception("Invalid penalty for "
                                + q.getQuestionText());
        }
        questions[size++] = q;
    }

    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        if (index < size) {
            return questions[index];
        }
        return null;
    }
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int totalscore = 0;
        for (int i = 0; i < size; i++) {
            s = s + questions[i].getQuestionText() + "\n";
            if (questions[i].evaluateResponse(
                        questions[i].getResponse())) {
                totalscore = totalscore
                             + questions[i].getMaxMarks();
                s = s
                    + " Correct Answer! - Marks Awarded: "
                    + questions[i].getMaxMarks() + "\n";
            } else {
                totalscore = totalscore
                             + questions[i].getPenalty();
                s = s + " Wrong Answer! - Penalty: "
                    + questions[i].getPenalty() + "\n";
            }
        }
        s = s + "Total Score: " + totalscore;
        return s;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * { errorflag }.
     */
    private static boolean errorflag = false;
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * { flag function }.
     *
     * @return     { boolean type }
     */
    public static boolean getflag() {
        return errorflag;
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation
            // invoke the
            // corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println(
                    "|----------------|");
                loadQuestions(s, q,
                              Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
                                     final Quiz quiz, final int q) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q == 0) {
            System.out.println("Quiz does not have questions");
            errorflag = true;
            return;
        }
        try {
            final int five = 5;
            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] tokens = line.split(":");
                if (tokens.length != five) {
                    System.out.println(
                        "Error! Malformed question");
                    errorflag = true;
                    return;
                }
                final int three = 3;
                final int four = 4;
                Question newques = new Question(
                    tokens[0], tokens[1].split(","),
                    Integer.parseInt(tokens[2]),
                    Integer.parseInt(tokens[three]),
                    Integer.parseInt(tokens[four]));
                quiz.addQuestion(newques);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errorflag = true;
            return;
        }
        System.out.println(q + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here
        // to display the quiz questions
        // on the console.
        // read the user responses
        // from the console
        // using scanner object.
        // store the user respone in the question object
        if (getflag()) {
            return;
        }
        for (int i = 0; i < q; i++) {
            String choiceline = scan.nextLine();
            quiz.getQuestion(i).setResponse(choiceline);
            System.out.println(quiz.getQuestion(i));
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here
        // to display the score
        // report using quiz object.
        if (getflag()) {
            return;
        }
        System.out.println(quiz.showReport());
    }
}