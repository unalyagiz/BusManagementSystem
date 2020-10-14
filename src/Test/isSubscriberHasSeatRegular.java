package Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusManagement.Destinations;
import BusManagement.Seat;
import BusManagement.User;

class isSubscriberHasSeatRegular {

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
		User usr = new User();
	    Destinations dest = new Destinations(5,"antalya","izmir",220.0,360,null);
	    usr.setDestinations(dest);
	    double price = usr.getDestinations().getPrice();
	    Seat seat1= new Seat(5,10,"regular",new Destinations(5,"antalya","izmir",220.0,360,null));
	    double regprice = seat1.getPrice();
	    assertNotEquals(regprice,price);
	}

}
