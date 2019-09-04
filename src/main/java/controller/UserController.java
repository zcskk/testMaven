package controller;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Type;
import model.User;
import service.Book1_Service;
import service.Type_Service;
import service.UserService;
@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	UserService service;
	
	
	@RequestMapping("login")
	public String login(User u,String code,ModelMap m,HttpSession s){
//		String num=s.getAttribute("number").toString();
//		if(!num.equalsIgnoreCase(code)) {
//			return "redirect:/login.html";
//		}
		try {
			SecurityUtils.getSubject().login(new UsernamePasswordToken(u.getName(), u.getPass()));
		} catch (org.apache.shiro.authc.AccountException e) {
			// TODO: handle exception
			return "redirect:/login.html";
		}
		return "redirect:/index.jsp";
//		User user=service.login(u);
//		if(user!=null) {
//			s.setAttribute("user", user);
//			s.setMaxInactiveInterval(20);
//			return "index1";
//		}else {
//			return "redirect:/login.html";
//		}
	}

	@RequestMapping("outlogin")
	public String login(HttpSession s,HttpServletRequest rep){
		
		SecurityUtils.getSubject().logout();
		return "redirect:login.html";
	}
	
	
	@RequestMapping("index")
	public String select(String txt,ModelMap m) {
		if(txt!=null) txt="where type.name like '%"+txt+"%'";
		else txt="";
		m.put("list", service.select(txt));
		return "index";
	}

	
	@RequestMapping("add")
	public String add(ModelMap m) {
		return "editor";
	}
	@RequestMapping("upd")
	public String upd(int id,ModelMap m) {
		m.put("info",service.selectbyid(id));
		return add(m);
	}
	@RequestMapping("insert")
	public String insert(User t,ModelMap m) {
		
		service.insert(t);
		return select(null, m);
	}
	@RequestMapping("update")
	public String update(User t,ModelMap m) {
		service.update(t);
		return select(null, m);
	}
	@RequestMapping("delete")
	public String delete(User t,ModelMap m) {
		service.delete(t.getId());
		return select(null, m);
	}
}

