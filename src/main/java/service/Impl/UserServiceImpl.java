package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	public List<User> select(String txt) {
		
		return dao.select(txt);
	}

	public User selectbyid(int id) {
		// TODO Auto-generated method stub
		return dao.selectbyid(id);
	}

	public void insert(User t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	public void update(User t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public User login(User u) {
		// TODO Auto-generated method stub
		return dao.login(u);
	}

}
