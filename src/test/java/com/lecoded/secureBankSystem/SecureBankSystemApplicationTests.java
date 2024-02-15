package com.lecoded.secureBankSystem;

import com.lecoded.secureBankSystem.entity.UserEntity;
import com.lecoded.secureBankSystem.repository.Userrepository;
import com.lecoded.secureBankSystem.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SecureBankSystemApplicationTests {


	@MockBean
	Userrepository userrepository;
	@Autowired
	UserService userService;

	@Test
	public void whenUsersPasswordIsLargerThan8Digit_theSuccess(){
		UserEntity userEntity1 = new UserEntity();
		userEntity1.setName("Noura");
		userEntity1.setPassword(1234bii32);

		UserEntity userEntity2 = new UserEntity();
		userEntity2.setName("Noura");
		userEntity2.setPassword(1234bii32)

		UserEntity userEntity3 = new UserEntity();
		userEntity3.setName("Noura");
		userEntity3.setPassword(1234bii32)


		List<UserEntity> mokeUserEntities = Arrays.asList(userEntity1,userEntity2,userEntity3);
		Mockito.when(userrepository.findAll()).thenReturn(mockUserEntities);
		int sum = 5+5;

		Assertions.assertSame(20,sum);

		public List<String>
	}
}
