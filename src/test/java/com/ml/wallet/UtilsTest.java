package com.ml.wallet;

import com.ml.wallet.dtos.UserDTO;
import com.ml.wallet.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UtilsTest {

	private final Page<UserDTO> LIST_USERS_DTO = builderUsersDTO();

	@Test
	public void mapEntityPageIntoDtoPageWithSuccess() {
		Page<User> usersDTO = Utils.mapEntityPageIntoDtoPage(LIST_USERS_DTO, User.class);

		assertEquals(1, usersDTO.getSize());
	}

	private Page<UserDTO> builderUsersDTO() {
		return new PageImpl<>(Collections.singletonList(
				UserDTO.builder()
						.id(1L)
						.build()
		));
	}

}
