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

    }

    @Test
    public void addNullCampTest() {
        Camp camp = null;
        campList.addCamp(camp);
        assertEquals(0, campList.getAllCamps().size());
    }

    @Test
    public void addCampTestValidDate() {
        Date date = new Date(19-23-2022);
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




}
