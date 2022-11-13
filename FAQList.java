import java.util.ArrayList;

public class FAQList {
    private ArrayList<FAQ> faqs;
    private static FAQList faqList;

    private FAQList(){
        faqs = DataReader.loadFAQs();
    }

    /**
     * Returns an instance of the FAQList
     * 
     * @return FAQList  an instance of the FAQList
     */
    public static FAQList getInstance(){
        if(faqList == null){
            faqList = new FAQList();
        }
        return faqList;
    }

    /**
     * Returns an ArrayList of type FAQ
     * 
     * @return ArrayList<FAQ>   an array list of FAQs
     */
    public ArrayList<FAQ> getFaqs(){
        return this.faqs;
    }

    /**
     * Adds a FAQ to the list of FAQs
     * 
     * @param faq   the FAQ to be added to the ArrayList of FAQs
     */
    public void addFAQ(FAQ faq){
        this.faqs.add(faq);
    }

    /**
     * Added for testing
     */

    public void clear(){
        faqs.clear();
    }
}
