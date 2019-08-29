package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.Type1_Dao;
import model.Type;
import service.Type_Service;

@Controller
public class TypeController {

//	@Autowired
//	Type_Service service;
	@Autowired
	Type1_Dao dao;
	
	@RequestMapping("index")
	public String select(String txt,ModelMap m) {
		if(txt!=null) txt="where type.name like '%"+txt+"%'";
		else txt="";
		m.put("list", dao.select(txt));
		return "index";
	}
//	@RequestMapping("insert")
//	public String insert(Type t,ModelMap m) {
//		service.insert(t);
//		return select(null, m);
//	}
//	public String update(Type t,ModelMap m) {
//		service.update(t);
//		return select(null, m);
//	}
//	public String delete(Type t,ModelMap m) {
//		service.delete(t.getId());
//		return select(null, m);
//	}
}
