package springwebprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springwebprj.main.Test;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public void index(Model model) {
		Test test = new Test();
		test.setTest1("11");
		test.setTest2("22");
		model.addAttribute("test",test);
		
	}
	
	@RequestMapping("list")
	@ResponseBody
	public String list() {
		
		return "Hello list!";
	}
}
