public class FAQ {
    private String question;
    private String answer;
    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public String toString() {
        return "FAQ:" + "\n" + "\t"+ "question:" + question + "\n" + "\t" + "answer:" + answer;
    }
    
    
}
