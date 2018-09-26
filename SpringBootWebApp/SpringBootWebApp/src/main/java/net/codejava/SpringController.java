import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.coinbaseAPI.SettingsForm;

@Controller
//MVC Controller//
public class SpringController{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(Model model) {
		model.addAttribute("homePage", new loginPage());
		return "homePage";
	}
	
	// posts user and password input//
	//TODO: Hash Password//
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginResult(
			@ModelAttribute("login") loginPage login, 
			BindingResult result, Model homePage) throws IOException, ParseException {
		if (result.hasErrors()) {
            return "homePage";
        }
		String user = login.getUser();
		String pass = login.getPass();
		
		homePage.addAttribute("pass", pass);
		homePage.addAttribute("user", user);
		
		return "loginConfirmed";
	}
		
}