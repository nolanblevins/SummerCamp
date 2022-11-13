/*
 * Tested by Jonah Andrews
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;

public class TestFAQList {

    private FAQList faqList = FAQList.getInstance();

    @BeforeEach
    public void setup() {
        faqList.clear();
    }

    @Test
    public void testAddValidFAQ() {
        FAQ faq = new FAQ("sun vs lions", "lions");
        faqList.addFAQ(faq);
        assertEquals(1, faqList.getFaqs().size());
    }

    @Test
    public void testAddInvalidFAQ() {
        FAQ faq = new FAQ(null, null);
        faqList.addFAQ(faq);
        assertEquals(0, faqList.getFaqs().size());
    }

    @Test
    public void testAddValidFAQs() {
        FAQ faq = new FAQ("sun vs lions", "lions");
        FAQ faq2 = new FAQ("hotdog a sandwhich", "sure");
        faqList.addFAQ(faq);
        faqList.addFAQ(faq2);
        assertEquals(2, faqList.getFaqs().size());
    }

    @Test
    public void testAddDuplicateFAQ() {
        FAQ faq = new FAQ("sun vs lions", "lions");
        FAQ faq2 = new FAQ("sun vs lions", "lions");
        faqList.addFAQ(faq);
        faqList.addFAQ(faq2);
        assertEquals(1, faqList.getFaqs().size());
    }


}
