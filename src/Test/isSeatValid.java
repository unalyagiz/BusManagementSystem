package Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusManagement.Destinations;
import BusManagement.Seat;

class isSeatValid {

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
		//checking two objects refer to each other
	    Destinations dest1 = new Destinations(4,"ankara","istanbul",190.0,420,null);
	    Seat seat1 = new Seat();
	    Destinations dest2 = new Destinations();
	    Seat seat2 = new Seat();
	    seat1.setDestination(dest1);
	    seat2.setDestination(dest2);
	    Destinations route1=seat1.getDestination();
	    Destinations route2 = seat2.getDestination();
	    assertNotSame(route1,route2);
	}

}
