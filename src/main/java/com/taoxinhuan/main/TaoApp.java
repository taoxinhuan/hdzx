package com.taoxinhuan.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@MapperScan("com.taoxinhuan.main.dao")
@Controller
public class TaoApp {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "/loginx.html";
	}

	public static void main(String[] args) {
		SpringApplication.run(TaoApp.class, args);
	}
	
}
