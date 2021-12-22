package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.ExecutionException;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.example.demo.BoardController;

@WebMvcTest(controllers = BoardController.class)
public class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnMessageFromBoardController() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getRequestFromDetailDomain() throws Exception {
		this.mockMvc.perform(get("/detail")).andDo(print()).andExpect(status().isOk());
	}

}
