package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@GetMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg","お名前を入力してください");
		return mav;
	}
	
	@PostMapping(value="/")
	public ModelAndView send(
			@RequestParam("text1")String str,
			ModelAndView mav
			) {
		mav.setViewName("index");
		mav.addObject("msg","こんにちは" + str + "さん!");
		return mav;
	}
}
