public class FAQ {
    private String question;
    private String answer;

    /**
     * Constructor for FAQ
     * 
     * @param question is the question for the faq
     * @param answer is the answer for the faq
     */
    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Accessor for question
     * 
     * @return question for faq
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Accessor for answer
     * 
     * @return answer for faq
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method returns all of the parameters for faq in the form of a string
     * 
     * @return a concatenated string of the faq properties
     * 
     */
    public String toString() {
        return "Question:" + question + "\n" + "Answer:" + answer;
    }
}
