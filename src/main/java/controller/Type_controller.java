package controller;

import java.util.List;

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

import model.Book;
import model.Type;
import service.Book1_Service;
import service.Type1_Service;
import service.Type_Service;
import until.ReturnInfo;

@Controller
public class Type_controller {

	@Autowired
	Type1_Service service;
	@Autowired
	Book1_Service bservice;
	

	@GetMapping("Type")
     public @ResponseBody ReturnInfo index(String txt,Integer page,Integer limit){
		
		return service.select(txt, page,limit);
	}

	@GetMapping("Type/getsex1")
    public @ResponseBody String[]  getsex() {
		return Book.sexs;
	}
	
	@GetMapping("Type/{id}")
	public @ResponseBody Type  edit(@PathVariable("id") int id) {
		return service.selectById(id);
	}
	@GetMapping("Type/getstatus")
     public @ResponseBody String[]  getstatus() {
		return Type.statuslist;
	}
	@GetMapping("Type/getbook")
    public @ResponseBody List getbook() {
		return bservice.select("", null, null).getList();
	}
	
	@PostMapping("Type/insert")
	public @ResponseBody ReturnInfo  insert(Type b) {
		System.out.println("ffffff");
		service.insert(b);
		return index("",null,null);
	}
	@PutMapping("Type/update")
	public @ResponseBody ReturnInfo  update(Type b) {
		service.update(b);
		return index("",null,null);
	}
	@DeleteMapping("Type/{id}")
	public @ResponseBody ReturnInfo  delete(@PathVariable("id")int id) {
		service.delete(id);
		return index("",null,null);
	}
	
}
