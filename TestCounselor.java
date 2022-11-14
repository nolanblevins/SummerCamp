/**
 * Nolan Blevins
 */
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCounselor {
    Counselor counselor;
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
        counselor = new Counselor("FName", "LName", "Test@email.com",
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
    public void testAddNullNote() {
        Date bDay = null;
        try{
            bDay = new SimpleDateFormat("MM:dd:yyyy").parse("05:15:2012");
        } catch(Exception e){

        }
        Child child = new Child("FName", "LName", medicalInfo, bDay);
        counselor.addNotes(child, null);
        assertEquals(0, child.getNotes().size());
    }
    @Test
    public void testAddNote() {
        Date bDay = null;
        try{
            bDay = new SimpleDateFormat("MM:dd:yyyy").parse("05:15:2012");
        } catch(Exception e){

        }
        Child child = new Child("FName", "LName", medicalInfo, bDay);
        counselor.addNotes(child, "Bad temper");
        assertEquals(1, child.getNotes().size());
    }


    @Test
    public void testAddEmptyNote() {
        Date bDay = null;
        try{
            bDay = new SimpleDateFormat("MM:dd:yyyy").parse("05:15:2012");
        } catch(Exception e){

        }
        Child child = new Child("FName", "LName", medicalInfo, bDay);
        counselor.addNotes(child, " ");
        assertEquals(0, child.getNotes().size());
    }
    @Test
    public void testViewSchedule() {
        Schedule testSchedule = counselor.viewSchedule(WeekDay.MONDAY);
        Schedule testSchedule2 = counselor.viewSchedule(WeekDay.MONDAY);
        assertEquals(testSchedule2.getSchedule(), testSchedule.getSchedule());
    }

    @Test
    public void testGetGroupSize() {
        assertEquals(2, counselor.getGroupSize());
    }

    


    
}
