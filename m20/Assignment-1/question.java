/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {

	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
			 final int correctAnswer1,
			 final int maxMarks1,
			 final int penalty1) {
		this.questiontext = question1;
		this.choices = choices1;
		this.correctAnswer = correctAnswer1;
		this.maxMarks = maxMarks1;
		this.penalty = penalty1;
	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse(final String choice) {
		if (this.getCorrectAnswer().equals(choice)) {
			return true;
		}
		return false;
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public String getCorrectAnswer() {
		final int three = 3;
		final int four = 4;
		if (this.correctAnswer == 1) {
			return this.choices[0];
		} else if (this.correctAnswer == 2) {
			return this.choices[1];
		} else if (this.correctAnswer == three) {
			return this.choices[2];
		} else if (this.correctAnswer == four) {
			return this.choices[three];
		} else {
			return "choice " + this.correctAnswer;
		}
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		return this.questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return this.choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return this.maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return this.penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		this.response = answer;
	}
	/**
	 * Gets the response.
	 *
	 * @return     The response.
	 */
	public String getResponse() {
		return this.response;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		s = s + this.questiontext + "(" + this.maxMarks + ")" + "\n";
		for (int i = 0; i < choices.length - 1; i++) {
			s = s + choices[i] + "	";
		}
		s = s + choices[choices.length - 1] + "\n";
		return s;
	}
}