package in.co.loan.granting.system.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeCtl {

	@GetMapping(path={"/welcome"})
	public String display() {
		return "welcome";
	}
	
	@GetMapping(path={"/home","/"})
	public String homeDisplay() {
		return "home";
	}
	
	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}
	
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}
	
	@GetMapping("/FAQ")
	public String FAQ() {
		return "faq";
	}
	
}
