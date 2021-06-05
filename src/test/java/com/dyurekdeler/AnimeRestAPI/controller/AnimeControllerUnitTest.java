package com.dyurekdeler.AnimeRestAPI.controller;

import com.dyurekdeler.AnimeRestAPI.model.Anime;
import com.dyurekdeler.AnimeRestAPI.repository.AnimeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(controllers = AnimeControllerUnitTest.class)
class AnimeControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private AnimeRepository animeRepository;

	@Test
	void whenValidInput_thenReturns200() throws Exception {
		//object mapper generated the json body
		Anime anime = new Anime(9L, "Naruto");
		mockMvc.perform(post("/animes")
			.contentType("application/json")
			.content(objectMapper.writeValueAsString(anime)))
			.andExpect(status().isOk());
	}

}
