package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.Book_Dao;
import model.Book;
import model.Type;
import service.Book_service;
import service.Type_Service;
@Controller
@RequestMapping("Book")
public class BookController {

	@Autowired
	Book_service service;
	@Autowired
	Type_Service tservice;
	
	@RequestMapping("index")
	public String select(String txt,ModelMap m) {
		if(txt!=null) txt="where book.name like '%"+txt+"%'";
		else txt="";
		m.put("list", service.select(txt));
		return "Book/index";
	}

	@RequiresPermissions("add")
	@RequestMapping("add")
	public String add(ModelMap m) {
		m.put("sexlist", Book.sexs);
		m.put("typelist", tservice.select(""));
		return "Book/editor";
	}
	@RequestMapping("upd")
	public String upd(int id,ModelMap m) {
		m.put("info",service.selectbyid(id));
		return add(m);
	}
	@RequestMapping("insert")
	public String insert(Book b,ModelMap m) {
		System.out.println("fffff");
		service.insert(b);
		return select(null, m);
	}
	@RequestMapping("update")
	public String update(Book b,ModelMap m) {
		service.update(b);
		return select(null, m);
	}
	@RequestMapping("delete")
	public String delete(Book b,ModelMap m) {
		service.delete(b.getId());
		return select(null, m);
	}
	
	
}
