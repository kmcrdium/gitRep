package com.smpl.smvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	protected HomeService homeService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//http://localhost/kr/home.do
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is "+ locale.toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home.tiles";
	}
	//http://localhost/kr/list.do?first=A&second=B
	@RequestMapping(value = "list.do", method = RequestMethod.GET)
	public String list(LinkedHashMap model, Command command)
	{
		logger.info("first param : " + command.getFirst());
		logger.info("second param : " + command.getSecond());
		
		homeService.list(model, command);
		
		return "home.tiles";
	}
	
	/* PathVariable Usage */
	//http://localhost/kr/A/B/pathVarList.do
	@RequestMapping(value = "/{first}/{second}/pathVarList.do", method = RequestMethod.GET)
	public String pathVarList(@PathVariable String first, @PathVariable String second, LinkedHashMap model, Command command)
	{
		logger.info("first param : " + command.getFirst());
		logger.info("second param : " + command.getSecond());
		
		homeService.list(model, command);
		
		return "home.tiles";
	}
	
}
