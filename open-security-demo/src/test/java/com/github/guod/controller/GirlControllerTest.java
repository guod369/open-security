package com.github.guod.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by 廖师兄 2017-02-14 23:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void doSave() throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders.post("/doGirlSave").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.param("name", "guod").param("age", "12").param("cupSize", "B"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void doDelete() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.delete("/doDelete/8a897d7e62e2f4ba0162e2f4ff970000").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void doUpdate() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.put("/doUpdate/8a897d7e62e301d40162e301e1cb0000").contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("name", "sun").param("age", "12"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void doList() throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/doGirlList"))
		.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(jsonPath("$.length()").value(3));
	}

}