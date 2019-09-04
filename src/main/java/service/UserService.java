package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Type;
import model.User;
public interface UserService {

	public User login(User u);

	public List<User> select(String txt) ;
	public User selectbyid(int id);
	public void insert(User t);
	public void update(User t);
	public void delete(int id);
}
