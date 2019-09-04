package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.TypeDao;
import model.Book;
import model.Type;
import service.Book1_Service;
import service.Book_service;
import service.Type_Service;
import until.ReturnInfo;

@Controller
public class Book_controller  {

	
	@Autowired
	Book1_Service service;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping("Book")
	public @ResponseBody ReturnInfo  insert(Book b) {
		service.insert(b);
		return index("",null,null);
	}
	
	
	@GetMapping("Book")
	public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit){
		
		return service.select(txt, page,limit);
	}

	@GetMapping("Book/getsex")
    public @ResponseBody String[]  getsex() {
		return Book.sexs;
	}
	@GetMapping("Book/gettype")
public @ResponseBody List getType() {
		
		return  service.selectType();
	}
	@GetMapping("Book/{id}")
	public @ResponseBody Book  edit(@PathVariable("id") int id) {
		
	    
		return service.selectById(id);
	}
	

	@PutMapping("Book/{id}")
	public @ResponseBody ReturnInfo   update(Book b) {
		service.update(b);
		return index("",null,null);
	}
	
	@DeleteMapping("Book/{id}")
	public @ResponseBody ReturnInfo   delete(@PathVariable("id") int id) {
		service.delete(id);
		return index("",null,null);
	}
	
}
