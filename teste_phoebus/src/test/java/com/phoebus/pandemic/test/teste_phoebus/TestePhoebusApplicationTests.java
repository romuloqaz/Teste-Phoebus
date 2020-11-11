package com.phoebus.pandemic.test.teste_phoebus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoebus.pandemic.test.teste_phoebus.resources.HospitalResource;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestePhoebusApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private HospitalResource service;

	private static final String RECURSO = "{\"id\": 10, \"name\": recurso1, \"valueResource\": \"3\"}";

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	public void loadHigherHospital() throws Exception {
		mockMvc.perform(get("/hospitais/maior")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void loadMinusHospital() throws Exception {
		mockMvc.perform(get("/hospitais/menor")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void loadIdHospital() throws Exception {
		mockMvc.perform(get("/hospitais/1")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(4)
	public void loadIdResources() throws Exception {
		mockMvc.perform(get("/recursos/1")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(5)
	public void lowerOccupation() throws Exception {
		mockMvc.perform(get("/hospitais/capacidadeMenor")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(6)
	public void higherOccupation() throws Exception {
		mockMvc.perform(get("/hospitais/capacidadeMaior")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(7)
	public void getHospitals() throws Exception {
		mockMvc.perform(get("/hospitais")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}

	@Test
	@Order(8)
	public void getNegotiations() throws Exception {
		mockMvc.perform(get("/negociacoes")
				.contentType("application/json"))
				.andExpect(status().isOk());
	}


//	@Test
//	@Order(4)
//	public void postExchange() throws Exception {
//		mockMvc.perform(post("/recursos").contentType("application/json").content(RECURSO))
//				.andExpect(status().isCreated());
//
//	}

}
