package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusManagement.Destinations;
import BusManagement.User;

class isRegisterPriceValid {

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
		//Test registered user price valid
		Destinations dest = new Destinations(0,"ankara","izmir",150.0,130,new ArrayList<>());
	    User usr = new User(0,null,null);
	    usr.setDestinations(dest);
	    Double usrprice = usr.getDestinations().getPrice();
	    assertEquals(usrprice,112.5,0);
	}

}
