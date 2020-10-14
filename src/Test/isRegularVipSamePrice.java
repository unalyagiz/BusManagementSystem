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

class isRegularVipSamePrice {

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
		//Test compare vip seat price 
		Seat seat1= new Seat(5,10,"regular",new Destinations(1,"ankara","izmir",150.0,475,null));
		double regprice = seat1.getPrice();
		Seat seat2= new Seat(1,8,"vip",new Destinations(1,"ankara","izmir",150.0,475,null));
		
		double x = seat2.getPrice();
		assertNotEquals(x,regprice);
	}

}
