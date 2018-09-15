import java.util.Scanner;
import java.util.ArrayList;
class Quiz{
    String  questionText;
    String[] choices;
    String correctAnswer;
    String marksAwarded;
    String penality;
Quiz(){

}
Quiz(String  questionText, String[] choices, String correctAnswer, String marksAwarded, String penality){
    this.questionText = questionText;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.marksAwarded = marksAwarded;
        this.penality = penality;

}
}

public final class Solution {
    static ArrayList<Quiz> quizes = new ArrayList<Quiz>();
    static ArrayList<String> answers = new ArrayList<String>();
    
    private Solution() {
        // leave this blank
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
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
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
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class

while (questionCount> 0){
     String line = s.nextLine();
            String[] tokens = line.split(":");
            String[] choices = tokens[1].split(",");
            Quiz p = new Quiz(tokens[0],choices,tokens[2],tokens[3],tokens[4]);
            quizes.add(p);
            questionCount = questionCount + 1;
}
      if(quizes.size() != 0) {
            System.out.println(quizes.size() + "should be added to quizes");
        }else {
            System.out.println("Quiz does not have questions");
        }


    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        
        
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
    }
}
