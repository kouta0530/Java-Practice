package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import static org.hamcrest.Matchers.hasSize;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.example.demo.Board;

@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void returnMessageFromBoardController() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void getMessageAddPage() throws Exception {
		this.mockMvc.perform(get("/add")).andExpect(status().isOk());
	}

	@Test
	public void getCreatedBoardDetail() throws Exception {
		this.mockMvc.perform(get("/detail").param("id", "1"))
				.andExpect(status().isOk())
				.andExpect(view().name("board/detail"))
				.andExpect(content().string(containsString("帰社日について")))
				.andExpect(content().string(containsString("島根")))
				.andExpect(content().string(containsString("帰社日は以下の通りに決定しました。2018/01/11")));
	}

	@Test
	public void editCreatedPage() throws Exception {
		this.mockMvc.perform(get("/edit").param("id", "1"))
				.andExpect(status().isOk())
				.andExpect(view().name("board/edit"))
				.andExpect(content().string(containsString("帰社日について")))
				.andExpect(content().string(containsString("島根")))
				.andExpect(content().string(containsString("帰社日は以下の通りに決定しました。2018/01/11")));
	}

	@Test
	public void createNewBoard() throws Exception {
		Board board = new Board();
		board.setTitle("testBoard");
		board.setUpsert(new Date());
		board.setWriter("test");
		board.setContent("create test board");
		this.mockMvc.perform(post("/create").flashAttr("formModel", board))
				.andExpect(redirectedUrl("/"));

		this.mockMvc.perform(get("/")).andExpect(content().string(containsString("testBoard")));
	}

	@Test
	public void deleteBoard() throws Exception {
		this.mockMvc.perform(post("/delete").param("id", "3"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));

		this.mockMvc.perform(get("/"))
				.andExpect(model().attribute("data", hasSize(2)));
	}
}