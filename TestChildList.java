/**
 * Tested by Matthew Hughes
 */

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestChildList {
    ChildList childList = ChildList.getInstance();
    ArrayList<Child> children = new ArrayList<>();

    @BeforeEach
    public void setup(){
        childList.clear();
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
                "555-444-3333", "Business");
        for(int i = 0; i < 2; i++){
            MedicalInfo medicalInfo = new MedicalInfo(
                    new ArrayList<Contact>(),
                    "Address"+i,
                    new ArrayList<String>(),
                    new ArrayList<String>(),
                    pediatrician
            );
            children.add(new Child("FName"+i, "LName"+i, medicalInfo, new Date()));
        }
        childList.addChild(children.get(0));
        childList.addChild(children.get(1));
    }

    @Test
    public void testAddChild(){
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
                "555-444-3333", "Business");
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "Address3",
                new ArrayList<String>(),
                new ArrayList<String>(),
                pediatrician
        );
        childList.addChild(new Child("FName", "LName", medicalInfo, new Date()));
        assertEquals(3, childList.getChildren().size());
    }

    @Test
    public void testEmptyAddChild(){
        childList.clear();
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
                "555-444-3333", "Business");
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "Address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                pediatrician
        );
        childList.addChild(new Child("FName", "LName", medicalInfo, new Date()));
        assertEquals(1, childList.getChildren().size());
    }

    @Test
    public void testAddNullChild(){
        childList.addChild(null);
        assertEquals(2, childList.getChildren().size());
    }

    @Test
    public void testAddDuplicateChild(){
        Child duplicateChild = childList.getChildren().get(0);
        childList.addChild(duplicateChild);
        assertEquals(2, childList.getChildren().size());
    }

    @Test
    public void testGetChildUUID(){
        Child testChild = childList.getChildren().get(0);
        Child child = childList.getChild(testChild.getUUID());
        assertEquals(testChild, child);
    }

    @Test
    public void testGetChildMissingUUID(){
        Child child = childList.getChild(UUID.randomUUID());
        assertEquals(null, child);
    }

    @Test
    public void testGetChildNullUUID(){
        Child child = childList.getChild((UUID)null);
        assertEquals(null, child);
    }

    @Test
    public void testRemoveChildSize(){
        Child child = childList.getChildren().get(0);
        childList.removeChild(child);
        assertEquals(1, childList.getChildren().size());
    }

    @Test
    public void testRemoveChildContains(){
        Child child = childList.getChildren().get(0);
        childList.removeChild(child);
        assertEquals(false, childList.getChildren().contains(child));
    }

    @Test
    public void testRemoveMissingChild(){
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
                "555-444-3333", "Business");
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "Address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                pediatrician
        );
        childList.removeChild(new Child("FName", "LName", medicalInfo, new Date()));
        assertEquals(2, childList.getChildren().size());
    }

    @Test
    public void testRemoveNullChild(){
        childList.removeChild(null);
        assertEquals(2, childList.getChildren().size());
    }

    @Test
    public void testEmptyRemoveChild(){
        Child child = childList.getChildren().get(0);
        childList.clear();
        childList.removeChild(child);
        assertEquals(0, childList.getChildren().size());
    }

    @Test
    public void testClear(){
        childList.clear();
        assertEquals(0, childList.getChildren().size());
    }
}
