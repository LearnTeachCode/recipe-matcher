package devApp.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devApp.entity.user.model.WebUser;
import devApp.entity.user.service.WebUserService;
import devApp.helpers.AppHelper;
import devApp.security.service.SecurityService;
import devApp.validator.WebUserValidator;


@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private WebUserService webUserService;
	
	@Autowired
	private SecurityService securityService;
	
	
	@Autowired
	private WebUserValidator webUserValidator;
	
	@Autowired
	private AppHelper appHelper;

	/*
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLogin() {
        return new ModelAndView("login");
    }
    */

	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new WebUser());

        return "registration";
    }

	
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") WebUser userForm, BindingResult bindingResult, Model model) {
    	// form validation
    	this.webUserValidator.validate(userForm, bindingResult);
    	
        if (bindingResult.hasErrors()) {
        	// getting and pushing registration field validation errors to the view
        	final List<ObjectError> errorsList = bindingResult.getAllErrors(); 
        	model.addAttribute("errorsjson", this.appHelper.objectToJSON(errorsList, LOG, "error"));
        	
        	return "registration";
        }       
        
        webUserService.addWebUser(userForm);

        // after registration user logs in automatically
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());        
        
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }

        return "login";
    }

    @RequestMapping(value = {"/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
