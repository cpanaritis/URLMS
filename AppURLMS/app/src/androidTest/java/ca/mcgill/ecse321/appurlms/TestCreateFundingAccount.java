package ca.mcgill.ecse321.appurlms;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;

import ca.mcgill.ecse321.urlms.controller.URLMSController;
import ca.mcgill.ecse321.urlms.model.Director;
import ca.mcgill.ecse321.urlms.model.Laboratory;
import ca.mcgill.ecse321.urlms.model.Staff;
import ca.mcgill.ecse321.urlms.model.URLMS;
import ca.mcgill.ecse321.urlms.persistence.PersistenceXStream;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class TestCreateFundingAccount {
    // Set values for test cases
    private static String testEmail ="director@urlms.ca";
    private static String testPassword ="password";
    private static String testName ="Director";

    private static String testStaffEmail ="staff@urlms.ca";
    private static String testStaffPassword ="password1";
    private static String testStaffName ="Member";
    private static Staff.StaffRole role = Staff.StaffRole.ResearchAssociate;

    private URLMS urlms;

    @Before
    public void setUp() {
        urlms = URLMS.getInstance();

        // Create data file
        PersistenceXStream.initializeURLMS(InstrumentationRegistry.getTargetContext().getApplicationContext().getFilesDir().getAbsolutePath()+"/data.xml");
        PersistenceXStream.saveToXMLwithXStream(urlms);
    }

    @After
    public void tearDown() {
        urlms.delete();
    }

    @Test
    public void test() {
        URLMSController sysC = new URLMSController(urlms);
        sysC.createDirector(testEmail,testPassword,testName);
        sysC.login(testEmail, testPassword);
        sysC.addLaboratory("name", "study", new Date(2017, 10, 10));
        sysC.addStaff(testStaffEmail, testStaffPassword, testStaffName, role);

        //Case 1: Successful create funding account
        assertEquals(true, sysC.createFundingAccount(1000, 10));

        //Case 2: Create funding account with same account number
        assertEquals(false, sysC.createFundingAccount(100, 10));

        //Case 3: Create funding account with 0 funds
        assertEquals(true, sysC.createFundingAccount(0, 11));

        //Case 4: Create funding account with negative funds
        assertEquals(false, sysC.createFundingAccount(-1, 12));

        //Case 5: Create funding account with large funds
        assertEquals(true, sysC.createFundingAccount(999999999, 13));

        //Case 6: Created funding account with negative ID
        assertEquals(false, sysC.createFundingAccount(1, -1));

        //Case 7: Create funding account with ID 0
        assertEquals(true, sysC.createFundingAccount(1, 0));

        sysC.logout();
        sysC.login(testStaffEmail, testStaffPassword);
        Laboratory test = urlms.getLaboratory(0);
        sysC.setActiveLaboratory(test);

        //Case 8: Staff creates an funding account
        assertEquals(false, sysC.createFundingAccount(1, 14));
    }
}
