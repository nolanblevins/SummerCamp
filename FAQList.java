import java.util.ArrayList;

public class FAQList {
    private ArrayList<FAQ> faqs;
    private static FAQList faqList;

    private FAQList(){
        faqs = DataReader.loadFAQs();
    }

    public static FAQList getInstance(){
        if(faqList == null){
            faqList = new FAQList();
        }
        return faqList;
    }

    public ArrayList<FAQ> getFaqs(){
        return this.faqs;
    }
}
