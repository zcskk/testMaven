package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import model.Type;

@Repository
public interface Type1_Dao {

	public List<Type> select(String txt) ;
	public void insert(Type t) ;
	public void update(Type t) ;
	public void delete(int id) ;
}
