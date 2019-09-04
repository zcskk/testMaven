package controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Book_Dao;
import dao.Type1_Dao;
import model.Type;
import service.Book1_Service;
import service.Type_Service;

@Controller
public class TypeController {

	@Autowired
	Type_Service service;
	@Autowired
	Book1_Service bservice;
	
	@RequestMapping("index")
	public String select(String txt,ModelMap m) {
		if(txt!=null) txt="where type.name like '%"+txt+"%'";
		else txt="";
		m.put("list", service.select(txt));
		return "index";
	}

	
	@RequestMapping("add")
	public String add(ModelMap m) {
		m.put("statuslist", Type.statuslist);
		m.put("booklist", bservice.select("",null,null));
		return "editor";
	}
	@RequestMapping("upd")
	public String upd(int id,ModelMap m) {
		m.put("info",service.selectbyid(id));
		return add(m);
	}
	@RequestMapping("insert")
	public String insert(Type t,ModelMap m) {
		
		service.insert(t);
		return select(null, m);
	}
	@RequestMapping("update")
	public String update(Type t,ModelMap m) {
		service.update(t);
		return select(null, m);
	}
	@RequestMapping("delete")
	public String delete(Type t,ModelMap m) {
		service.delete(t.getId());
		return select(null, m);
	}
}
