package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class BookController {

	@RequestMapping("index1")
	public String tojsp( String id ) {
		System.out.println(id);
		return "index";
	}
	
}
