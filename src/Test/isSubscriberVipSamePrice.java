package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusManagement.Destinations;
import BusManagement.Seat;
import BusManagement.User;

class isSubscriberVipSamePrice {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		Destinations dest = new Destinations(1,"ankara","izmir",150.0,475,new ArrayList<>());
	    User usr = new User(0,null,null);
	    usr.setDestinations(dest);
	    
	    Double usrprice = usr.getDestinations().getPrice();
		Seat seat2= new Seat(1,8,"vip",new Destinations(1,"ankara","izmir",150.0,475,null));
		double x = seat2.getPrice();
		
		assertNotEquals(x,usrprice);
	}

}
