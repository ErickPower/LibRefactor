package Testing;

import java.util.Calendar;


import org.junit.Assert;
//import org.junit.Test;

import Actors.Customer;
import Actors.Student;
import Actors.Faculty;
import Utilities.Address;
import Utilities.FeeChargeSystem;
import Utilities.Status;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class updateBlackListStatusTest {
	
	FeeChargeSystem a;
	Student JohnSmith;
	Faculty AbbyDoe;

	@BeforeEach
	void setUp() throws Exception {
		//Initialization
			Calendar johnBirthDate = Calendar.getInstance();
			johnBirthDate.set(1997,4,17);
			JohnSmith = new Student("101","John" , "Smith" , johnBirthDate,new Address 
					(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 0.0);
			AbbyDoe = new Faculty("102", "Abby", "Doe", johnBirthDate, new Address(101,"sesame street","t2y344","calgary","canada"), "4039991234", null, null, null, 0.0 );
			
			a = new FeeChargeSystem();
	}

	@Test
	void blacklistUsers() {		
		/* Initialize Student JohnSmith, Faculty AbbyDoe, FeeChargeSystem a */

		Double totFees = a.addFee(50.0, JohnSmith);
		totFees = a.addFee(50.0, AbbyDoe);
		JohnSmith.updateBlackListStatus();
		AbbyDoe.updateBlackListStatus();
		
		Assert.assertTrue((JohnSmith.getIsBlackListed()).equals(true));
		Assert.assertTrue((AbbyDoe.getIsBlackListed()).equals(true));
		
		a.clearFees(JohnSmith);
		a.clearFees(AbbyDoe);
		
		JohnSmith.updateBlackListStatus();
		AbbyDoe.updateBlackListStatus();
		
		Assert.assertTrue((JohnSmith.getIsBlackListed()).equals(false));
		Assert.assertTrue((AbbyDoe.getIsBlackListed()).equals(false));
	}
}