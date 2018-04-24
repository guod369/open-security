/**
 *
 */
package com.github.guod.validate.code.controller;

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
 * project - ETC发票系统
 *
 * @author guod
 * @date 日期:2018年3月2日 时间:下午4:00:02
 * @JDK 1.8
 * @version 3.0
 * @Description 功能模块：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void insert() throws Exception {
		String contentAsString = mockMvc
				.perform(MockMvcRequestBuilders.get("/hello").contentType(MediaType.APPLICATION_JSON_UTF8)
				.param("name","guod"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1")).andReturn().getResponse()
				.getContentAsString();
		System.out.println(contentAsString);
	}
	
	@Test
	public void query() throws Exception{
		String contentAsString = mockMvc.perform(MockMvcRequestBuilders.get("/query").contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn().getResponse().getContentAsString();
		System.out.println(contentAsString);
		
	}

}
