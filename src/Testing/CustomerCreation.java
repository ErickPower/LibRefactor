package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Map;

import Actors.Customer;
import Media.PhysicalMedia;
import Utilities.Address;
import Utilities.CalendarPeriod;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CustomerCreation {

	@Test
	void test() {
		Calendar albertBirthDate = Calendar.getInstance();
		albertBirthDate.set(1997,4,17);
		Customer Albert = new Customer("101","Albert" , "Smith" , albertBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 0.0, false);
		
		Customer Joanne = new Customer("101","Albert" , "Smith" , albertBirthDate,new Address 
				(100,"sesame street","t2y344","calgary","canada"),"4039224555", null,null,null, 0.0, true);
		
		Assert.assertNotNull(Albert);
		Assert.assertNotNull(Joanne);
		
		Assert.assertEquals(true, Joanne.getTag());
		Assert.assertEquals(false, Albert.getTag());
	}

}
