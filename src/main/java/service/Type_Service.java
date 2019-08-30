package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Type;

@Service
public interface Type_Service {

	public List<Type> select(String txt) ;
	public Type selectbyid(int id);
	public void insert(Type t);
	public void update(Type t);
	public void delete(int id);
}
