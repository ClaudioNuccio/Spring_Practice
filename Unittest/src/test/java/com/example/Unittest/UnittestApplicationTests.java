package com.example.Unittest;

import com.example.Unittest.controllers.UserController;
import com.example.Unittest.entities.Users;
import com.example.Unittest.services.UserService;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class UnittestApplicationTests {
	@Autowired
	private UserController userController;
	@Autowired
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;

	private Users createUser() throws Exception {
		Users user = new Users();
		user.setName("Francesco");
		user.setSurname("Virgulini");
		user.setEmail("VirguliniF@mail.test");
		user.setActive(true);
		return  createUser(user);
	}

	private Users createUser(Users user) throws Exception {
		MvcResult result = createUserRequest(user);
		return objectMapper.readValue(result.getResponse().getContentAsString(), Users.class);
	}

	private MvcResult createUserRequest() throws Exception {
		Users user = new Users();
		user.setName("Francesco");
		user.setSurname("Virgulini");
		user.setEmail("VirguliniF@mail.test");
		user.setActive(true);

		String userJSON = objectMapper.writeValueAsString(user);

		return this.mockMvc.perform(post("/user/create")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();
	}

	private MvcResult createUserRequest(Users user) throws Exception {
		if (user != null) {
			String studentJSON = objectMapper.writeValueAsString(user);

			return this.mockMvc.perform(post("/user/create")
							.contentType(MediaType.APPLICATION_JSON)
							.content(studentJSON)).andDo(print())
					.andExpect(status().isOk())
					.andReturn();
		} else return null;
	}

	private Users getUserFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/user" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		try {
			String userJson = result.getResponse().getContentAsString();
			return objectMapper.readValue(userJson, Users.class);
		} catch (Exception e) {
			return null;
		}


	}

	@Test
	void UserControllerExist() {
		assertThat(userController).isNotNull();
	}

	@Test
	void createUserTest() throws Exception {
		MvcResult userRequest = createUserRequest();
		Users userFromResponse = objectMapper.readValue(userRequest.getResponse().getContentAsString(), Users.class);
		assertThat(userFromResponse.getId()).isNotNull();
	}

	@Test
	void getUserListTest() throws Exception {
		createUserRequest();
		MvcResult result = this.mockMvc.perform(get("/user/getall"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List usersFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("The users in database are: " + usersFromResponse.size());
		assertThat(usersFromResponse.size()).isNotZero();
	}

	@Test
	void readOneStudent() throws Exception {
		Users user = createUser();
		assertThat(user.getId()).isNotNull();

		MvcResult result = this.mockMvc.perform(get("/user/getone/" + user.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Users userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Users.class);

		assertThat(userFromResponse.getId()).isEqualTo(user.getId());
	}

	@Test
	void updateUser() throws Exception {
		Users user = createUser();
		assertThat(user.getId()).isNotNull();
		String newName = "Gianfranco";
		user.setName(newName);
		String userJSON = objectMapper.writeValueAsString(user);


		MvcResult result = this.mockMvc.perform(put("/user/patch/" + user.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Users userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Users.class);
		assertThat(userFromResponse.getId()).isNotNull();
		assertThat(userFromResponse.getName()).isEqualTo(newName);
	}

	@Test
	void updateUserActive() throws Exception {
		Users user = createUser();
		assertThat(user.getId()).isNotNull();
		boolean active = false;
		user.setActive(active);
		String userJSON = objectMapper.writeValueAsString(user);


		MvcResult result = this.mockMvc.perform(put("/user/patch/" + user.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON)).andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Users userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Users.class);
		assertThat(userFromResponse.getId()).isNotNull();
		assertThat(userFromResponse.isActive()).isFalse();
	}

	@Test
	void deleteStudent() throws Exception {
		Users user = createUser();
		assertThat(user.getId()).isNotNull();
		boolean active = false;
		user.setActive(active);


        MvcResult result = this.mockMvc.perform(delete("/user/" + user.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		boolean userFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Boolean.class);
		assertThat(userFromResponse).isTrue();


	}


}
