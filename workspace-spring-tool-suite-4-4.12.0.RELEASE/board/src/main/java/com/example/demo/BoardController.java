package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.BoardRepository;
import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

@Controller
public class BoardController {

	@Autowired
	BoardRepository repos;
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<Board> list = repos.findAll();
		
		mav.setViewName("board/list");
		mav.addObject("data",list);
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView detail(@RequestParam int id) {
		ModelAndView mav = new ModelAndView();
		Board board = repos.findById(id);
		mav.setViewName("board/detail");
		mav.addObject("board",board);
		return mav;
	}
	
	@GetMapping("/add")
	public ModelAndView add() {
		ModelAndView mav = new ModelAndView();
		Board board = new Board();
		mav.setViewName("board/edit");
		mav.addObject("formModel", board);
		return mav;
	}
	
	@GetMapping("edit")
	public ModelAndView edit(@RequestParam int id){
		ModelAndView mav = new ModelAndView();
		Board board = repos.findById(id);
		mav.setViewName("board/edit");
		mav.addObject("formModel", board);
		return mav;
	}

	@PostMapping("/create")
	@Transactional(readOnly=false)
	public ModelAndView create(
			@ModelAttribute("formModel") Board board
			) {
		board.setUpsert(new Date());
		repos.saveAndFlush(board);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/delete")
	@Transactional(readOnly=false)
	public ModelAndView delete(@RequestParam int id) {
		repos.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	@PostConstruct 
	public void init() {
		Board board1 = new Board();
		board1.setTitle("帰社日について");
		board1.setUpsert(new Date());
		board1.setWriter("島根");
		board1.setContent("帰社日は以下の通りに決定しました。2018/01/11");
		repos.saveAndFlush(board1);
		
		Board board2 = new Board();
		board2.setTitle("新入社員歓迎会のおしらせ");
		board2.setUpsert(new Date());
		board2.setWriter("島根");
		board2.setContent("あたらしく新入社員が入りました");
		repos.saveAndFlush(board2);
	}
}
