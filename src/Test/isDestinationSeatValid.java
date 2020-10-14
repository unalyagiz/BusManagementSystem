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

class isDestinationSeatValid {

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
	 //checking  amount of seats are same or not
	@Test
	void test() {
		ArrayList<Integer> seats = new ArrayList<>();
	    for(int i=0;i<40;i++){
	        seats.add(i);
	    }
	    Destinations dest1 = new Destinations();
	    dest1.setSeat(new ArrayList<>(seats));
	    ArrayList<Integer> dest1seats = dest1.getSeat();
	    Destinations dest2 = new Destinations();
	    dest2.setSeat(new ArrayList<>(seats));
	    ArrayList<Integer> dest2seats = dest2.getSeat();
	    dest2seats.remove(1);
	    int destseatsize = dest1seats.size();
	    int destseat2size = dest2seats.size();
	    assertNotEquals(destseatsize,destseat2size);
	}

}
