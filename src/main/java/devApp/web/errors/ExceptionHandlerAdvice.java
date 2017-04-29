package devApp.web.errors;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
 
@ControllerAdvice
class ExceptionHandlerAdvice {
 
	/**
	 * Handling all exceptions thrown in controllers
	 */
	@ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("general_error");		
	
		return modelAndView;
	}
}
