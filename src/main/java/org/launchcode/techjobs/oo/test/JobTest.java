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

}
