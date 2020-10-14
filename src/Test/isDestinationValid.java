package Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BusManagement.Destinations;

class isDestinationValid {

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
		
		  //checking  two objects refer the same
		    Destinations dest1 = new Destinations(1,"ankara","izmir",150.0,475,null);
		    Destinations dest2 = new Destinations(2,"izmir","ankara",150.0,475,null);
		    assertNotSame(dest1,dest2);
		
	}

}
