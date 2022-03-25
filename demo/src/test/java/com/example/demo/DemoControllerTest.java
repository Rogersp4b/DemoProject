package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class DemoControllerTest {

    @Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(1)
	public void queryall() throws Exception {
		mockMvc.perform(
				get("/currency/queryAll").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    @Order(2)
	public void insert() throws Exception {
		CurrencyRq rqData = new CurrencyRq();
		rqData.setCode("JPY");
		rqData.setCodeCH("日元");
		rqData.setRate("11,111.1100");
		String content = objectMapper.writeValueAsString(rqData);
		mockMvc.perform(post("/currency/insert").content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    @Order(3)
	public void update() throws Exception {
		CurrencyRq rqData = new CurrencyRq();
		rqData.setCode("GBP");
		rqData.setCodeCH("英鎊");
		rqData.setRate("31,755.6700");
		String content = objectMapper.writeValueAsString(rqData);
		mockMvc.perform(post("/currency/update").content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    @Order(4)
	public void delete() throws Exception {
		CurrencyRq rqData = new CurrencyRq();
		rqData.setCode("USD");
		String content = objectMapper.writeValueAsString(rqData);
		mockMvc.perform(post("/currency/delete").content(content).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    @Order(5)
	public void insertCoinDesk() throws Exception {
		mockMvc.perform(post("/currency/insertFormURL").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
    @Order(6)
	public void query() throws Exception {
		mockMvc.perform(get("/currency/query").param("code","USD").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
