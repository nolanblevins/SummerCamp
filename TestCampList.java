/*
 * Tested by Jonah Andrews
 */

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCampList {

    private CampList campList = CampList.getInstance();
    //private Camp camp = new Camp(null, 0, null);

    @BeforeEach
    public void setUp() {
        campList.clear();
    }

    @AfterEach
    public void tearDown() {
        //not needed in this case
    }

    @Test
    public void addNullCampTest() {
        Camp camp = null;
        campList.addCamp(camp);
        assertEquals(0, campList.getAllCamps().size());
    }

    @Test
    public void addCampTestValidDate() {
        Date date = new Date(9-23-2022);
        Camp camp = new Camp(date, 0, "dogs");
        campList.addCamp(camp);
        assertEquals(1, campList.getAllCamps().size());
    }

    @Test
    public void addCampTestInvalidDate() {
        Date date = null;
        Camp camp = new Camp(date, 0, "puppy");
        campList.addCamp(camp);
        assertEquals(0, campList.getAllCamps().size());
    }

    @Test
    public void addDuplicateCampTest() {
        Date date = new Date(9-23-2022);
        Camp camp = new Camp(date, 9, "obama");
        Camp camp2 = new Camp(date, 9, "obama");
        campList.addCamp(camp);
        campList.addCamp(camp2);
        assertEquals(1, campList.getAllCamps().size());
    }

    @Test
    public void addUniqueCampsWithSameDateTest() {
        Date date = new Date(9-23-2022);
        Camp camp = new Camp(date, 9, "obama");
        Camp camp2 = new Camp(date, 12, "tacos");
        campList.addCamp(camp);
        campList.addCamp(camp2);
        assertEquals(2, campList.getAllCamps().size());
    }




}
