package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    //Use assertNotEquals to verify that the IDs of the two objects are distinct
    @Test
    public void testSettingJobId() {
        Job oneJob = new Job();
        Job twoJob = new Job();
        assertNotEquals(oneJob, twoJob);
    }

    //Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class
    // and value of each field. Your test should have 5 assert statements of each type.
    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());
    }

    //Generate two Job objects that have identical field values EXCEPT for id. Test that equals returns false.
    @Test
    public void testJobsForEquality() {
        Job sameJob = new Job("Game tester", new Employer("Sony"), new Location("Japan"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job notSameJob = new Job("Game tester", new Employer("Sony"), new Location("Japan"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(sameJob.equals(notSameJob));
    }

    //test toString before creating it
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newLineJob = new Job("Line cook", new Employer("Wendy's"), new Location("Independence"),
                new PositionType("cook"), new CoreCompetency("On time"));
//        String jobInfo = "ID: 1\nName: Line cook\nEmployer: Wendy's\nLocation: Independence\nPosition Type: cook\nCore Competency: On time";
//        char firstChar = newLineJob.toString().charAt(0);
//        char lastChar = newLineJob.toString().charAt(newLineJob.toString().length()-1);
        //assertEquals('\n' + jobInfo + '\n', newLineJob.toString());
        assertEquals('\n', newLineJob.toString().charAt(0));
        assertEquals('\n', newLineJob.toString().charAt(newLineJob.toString().length()-1));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job correctDataJob = new Job("Racecar driver", new Employer("FORD"), new Location("Detroit"),
                new PositionType("Driver"), new CoreCompetency("Stamina"));
        String correct = "\nID: 1\nName: Racecar driver\nEmployer: FORD\nLocation: Detroit\nPosition Type: Driver\nCore Competency: Stamina\n";
        assertEquals(correct, correctDataJob.toString());
    }


    @Test
    public void testToStringHandlesEmptyField() {
        Job emptyJob = new Job("Racecar driver", new Employer("FORD"), new Location(""),
                new PositionType("Driver"), new CoreCompetency(""));
        String correct = "\nID: 1\nName: Racecar driver\nEmployer: FORD\nLocation: Data not available\nPosition Type: Driver\nCore Competency: Data not available\n";
        assertEquals(correct, emptyJob.toString());
    }

    //Bonus only id return oops
    @Test
    public void testOnlyId() {
        Job idOnly = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
        String onlyIdMessage = "OOPS! This job does not seem to exist.";
        assertEquals(onlyIdMessage, idOnly.toString());
    }
}
