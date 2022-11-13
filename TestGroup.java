/**
 * Tested by Matthew Hughes
 */

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGroup {
    Group group;
    Pediatrician pediatrician = new Pediatrician("FName", "LName",
            "555-444-3333", "Business");
    MedicalInfo medicalInfo = new MedicalInfo(
            new ArrayList<Contact>(),
            "Address",
            new ArrayList<String>(),
            new ArrayList<String>(),
            pediatrician
    );

    @BeforeEach
    public void setup(){
        Pediatrician pediatrician = new Pediatrician("FName", "LName",
                "555-444-3333", "Business");
        MedicalInfo medicalInfo = new MedicalInfo(
                new ArrayList<Contact>(),
                "Address",
                new ArrayList<String>(),
                new ArrayList<String>(),
                pediatrician
        );
        Counselor counselor = new Counselor("FName", "LName", "Test@email.com",
                "555-444-3333", "password", new Date(), medicalInfo);
        Date bDay = null;
        try{
            bDay = new SimpleDateFormat("MM:dd:yyyy").parse("05:15:2012");
        } catch(Exception e){

        }
        Child child = new Child("FName", "LName", medicalInfo, bDay);
        Child child2 = new Child("FName2", "LName2", medicalInfo, bDay);
        group = new Group("Group1", 1, 0, counselor, 10,11);
        group.addChild(child);
        group.addChild(child2);
    }

    @Test
    public void testBeforeCreateSchedule(){
        assertEquals(null, group.getSchedule());
    }

    @Test
    public void testCreateSchedule(){
        group.createSchedule();
        assertEquals(7, group.getSchedule().size());
    }

    @Test
    public void testGetGroupChild(){
        Child child = group.getCampers().get(0);
        assertEquals(group, group.getGroupByChild(child));
    }

    @Test
    public void testGetGroupMissingChild(){
        Child child = new Child("FName", "LName", medicalInfo, new Date());
        assertEquals(null, group.getGroupByChild(child));
    }

    @Test
    public void testGetGroupNullChild(){
        assertEquals(null, group.getGroupByChild(null));
    }

    @Test
    public void testEmptyGetGroupChild(){
        Child child = group.getCampers().get(0);
        group.getCampers().clear();
        assertEquals(null, group.getGroupByChild(child));
    }

    @Test
    public void testGetGroupByCounselor(){
        Counselor counselor = group.getCounselor();
        assertEquals(group, group.getGroupByCounselor(counselor));
    }

    @Test
    public void testGetGroupByWrongCounselor(){
        Counselor counselor = new Counselor("FName", "LName", "email@email.com",
                "555-444-3333", "password", new Date(), medicalInfo);
        assertEquals(null, group.getGroupByCounselor(counselor));
    }

    @Test
    public void testGetGroupByNullCounselor(){
        assertEquals(null, group.getGroupByCounselor(null));
    }

    @Test
    public void testAddChild(){
        group.addChild(new Child("FName", "LName", medicalInfo, new Date()));
        assertEquals(3, group.getCampers().size());
    }

    @Test
    public void testEmptyAddChild(){
        group.getCampers().clear();
        group.addChild(new Child("FName", "LName", medicalInfo, new Date()));
        assertEquals(1, group.getCampers().size());
    }

    @Test
    public void testAddDuplicateChild(){
        group.addChild(group.getCampers().get(0));
        assertEquals(2, group.getCampers().size());
    }

    @Test
    public void testAddNullChild(){
        group.addChild(null);
        assertEquals(2, group.getCampers().size());
    }

    @Test
    public void testChildFits(){
        Child child = null;
        try{
            child = new Child("FName", "LName", medicalInfo,
                    new SimpleDateFormat("MM:dd:yyyy").parse("05:08:2012"));
        } catch(Exception e){

        }
        assertEquals(true, group.childFits(child));
    }

    @Test
    public void testToOldChildFit(){
        Child child = null;
        try{
            child = new Child("FName", "LName", medicalInfo,
                    new SimpleDateFormat("MM:dd:yyyy").parse("05:08:2010"));
        } catch(Exception e){

        }
        assertEquals(false, group.childFits(child));
    }

    @Test
    public void testToYoungChildFit(){
        Child child = null;
        try{
            child = new Child("FName", "LName", medicalInfo,
                    new SimpleDateFormat("MM:dd:yyyy").parse("05:08:2014"));
        } catch(Exception e){

        }
        assertEquals(false, group.childFits(child));
    }

    @Test
    public void testDuplicateChildFits(){
        Child child = group.getCampers().get(0);
        assertEquals(false, group.childFits(child));
    }

    @Test
    public void testNullChildFits(){
        assertEquals(false, group.childFits(null));
    }

    @Test
    public void testRemoveChildSize(){
        Child child = group.getCampers().get(0);
        group.removeChild(child);
        assertEquals(1, group.getCampers().size());
    }

    @Test
    public void testRemoveChildContains(){
        Child child = group.getCampers().get(0);
        group.removeChild(child);
        assertEquals(false, group.getCampers().contains(child));
    }

    @Test
    public void testRemoveLastChild(){
        Child child = group.getCampers().get(1);
        group.removeChild(child);
        assertEquals(false, group.getCampers().contains(child));
    }

    @Test
    public void testRemoveMissingChild(){
        Child child = new Child("FName", "LName", medicalInfo, new Date());
        group.removeChild(child);
        assertEquals(2, group.getCampers().size());
    }

    @Test
    public void testRemoveNullChild(){
        group.removeChild(null);
        assertEquals(2, group.getCampers().size());
    }

    @Test
    public void testEmptyRemoveChild(){
        Child child = group.getCampers().get(0);
        group.getCampers().clear();
        group.removeChild(child);
        assertEquals(0, group.getCampers().size());
    }
}
