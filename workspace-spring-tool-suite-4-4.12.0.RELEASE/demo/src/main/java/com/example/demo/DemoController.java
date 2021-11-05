package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
		int sum = 0;
		for(int i= 1; i<= num; i++) {
			sum += i;
		}
		mav.addObject("msg","sum=" + sum);
		mav.setViewName("index");
		return mav;
	}
}
