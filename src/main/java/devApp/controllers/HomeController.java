package devApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping(value="/recipes", method=RequestMethod.GET)
    public ModelAndView ModelAndView(){
    	return new ModelAndView("recipes");
    }
	
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView getHome() {
        return new ModelAndView("home");
    }

    @RequestMapping(value = {"/admin/home"}, method = RequestMethod.GET)
    public ModelAndView getAdminHome() {
        return new ModelAndView("home");
    }
}
