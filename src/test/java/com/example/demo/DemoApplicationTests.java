package com.example.demo;

import com.example.demo.domain.Shift;
import com.example.demo.domain.User;
import com.example.demo.repository.ShiftsRepository;
import com.example.demo.repository.UserDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private UserDetailRepository userDetailRepository;
	@Autowired
	private ShiftsRepository shiftsRepository;


	public DemoApplicationTests() { }

	@Test
	public void contextLoads() {
	}

	@Test
	public void insertBidirectionalRelations(){
		User user1 = User.builder().name("First").password("123").build();
		User user2 = User.builder().name("Second").password("456").build();
		List<User> users = (List<User>) userDetailRepository.saveAll(Arrays.asList(user1, user2));

		Shift shift1 = Shift.builder().startedDate(LocalDateTime.now()).finishedDate(LocalDateTime.now().plusHours(8)).build();
		shift1.getUsers().addAll(users);
		Shift shift = shiftsRepository.save(shift1);
		log.info("initial shift "+ shift1);
		log.info("saved shift "+ shift);
		users.forEach(user -> user.getShifts().add(shift));
		userDetailRepository.saveAll(users);

	}
}
