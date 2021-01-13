package openweb.wmc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerA {

	@GetMapping("/")
	public String welcome() {
		return "templateA";
	}
	
	@GetMapping("/greeting")
	public String welcome(Model model) {
		model.addAttribute("msg", "Author: William Chávez");
		model.addAttribute("reference", "Openwebinars");
		return "templateA";
	}
	
	@GetMapping("/requestparam")
	public String requestParam(@RequestParam("param") String param, Model model) {
		model.addAttribute("param", param);
		return "templateA";
	}
}
