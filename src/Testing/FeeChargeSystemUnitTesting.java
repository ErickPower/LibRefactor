package Testing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
//import org.junit.Test;

import Actors.Customer;
//import Actors.Student;
//import Actors.Faculty;
import Media.CD;
import Utilities.Address;
import Utilities.FeeChargeSystem;
import Utilities.Status;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class is for Testing FeeChargeSystem.java class
 *
 */
public class FeeChargeSystemUnitTesting {

	Calendar johnBirthDate;
	Customer JohnSmith;
	FeeChargeSystem a;
	
	
	@BeforeEach
	void setUp() throws Exception{
		johnBirthDate = Calendar.getInstance();
		johnBirthDate.set(1997,4,17);
		JohnSmith = new Customer("101","John" , "Smith" , johnBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 0.0, false);
		
		//Create metallica CD
		ArrayList<String> metallicaComposers = new ArrayList<String>();
		metallicaComposers.add("Metallica");
		Calendar metallicaDate = Calendar.getInstance();
		metallicaDate.set(1988,7,25);
		CD metallica = new CD("...And Justice For All",metallicaComposers, metallicaDate,new Status("available"));
		
		//Create Queen CD
		ArrayList<String> theGameComposers = new ArrayList<String>();
		theGameComposers.add("Queen");
		Calendar theGameDate = Calendar.getInstance();
		theGameDate.set(1980,06,30);
		CD theGameCd = new CD("The Game",theGameComposers,theGameDate,new Status("available"));
		
		//Generate return date : January 20th, 2019.
		Calendar mediaRetDate = Calendar.getInstance();
		mediaRetDate.set(2019, Calendar.AUGUST, 4);
		LocalDate mediaDate = LocalDate.of(mediaRetDate.get(Calendar.YEAR),
				mediaRetDate.get(Calendar.MONTH)+1,mediaRetDate.get(Calendar.DAY_OF_MONTH));
		mediaDate.atTime(mediaRetDate.get(Calendar.HOUR_OF_DAY), mediaRetDate.get(Calendar.MINUTE), 
				mediaRetDate.get(Calendar.SECOND));
		
		//Add media to John's account with that expired date 
        JohnSmith.addMediaOwned(metallica, mediaRetDate);
        JohnSmith.addMediaOwned(theGameCd,mediaRetDate);
        
        a = new FeeChargeSystem();
	}
	/**
	 * Test that creates artificial return dates & calculates the overdue Fees that should be $20 for john smith
	 * WARNING!!!: Adjust the fee in Assert statement in line XX depending for the day today!
	 * Alternatively, adjust the MONTH, and DAY(4) in line 58 to change when the items are due back.
	 * Created on October 7th, 2019. - so the overdue fees should be 20.0, however as time passes, fees will grow so 
	 * line XX needs to be changed.
	 */
	@Test
	public void chargeTwentyDollars(){
		/* Initialize JohnSmith, a, and items that John has borrowed. The items are set to be due 
		 * 		back 2 months + 3 days prior to today.
		 * The fees are calculated at 5$ per item, per month. So initialized 2 items, due
		 * 		back 2 months before today. 2*2*5$ = $20.0 */
		Double totFees = a.calculateAndApplyOverdueFees(JohnSmith);
		
		Double expResult = 20.0;
		Double Result = JohnSmith.getFeesOwned();
		//Comparison
		Assert.assertEquals(expResult, Result);
		
		
	}
}
