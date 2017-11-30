package com.ara.bbtgroup;

import com.ara.bbtgroup.entities.Users;
import com.ara.bbtgroup.entities.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BbtgroupApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	@Before
	public void setUp() throws Exception{
		Users users = new Users("Max", "Muster");

		assertNull(users.getId());
		this.usersRepository.save(users);
		assertNotNull(users.getId());
	}

	@Test
	public void contextLoads() {
		Users userA = usersRepository.findByFirstname("Max");
		assertNotNull(userA);

	}

}
