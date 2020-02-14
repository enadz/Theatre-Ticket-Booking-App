package com.tongo.backend;

import com.tongo.backend.data.models.Seat;
import com.tongo.backend.services.SeatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private SeatService seatService;

	@Test
	void contextLoads() {
	}

	@Test
	void testing () {
		List<Seat> seats = seatService.getSeats();
		Assert.notEmpty(seats, "test");
	}



}
