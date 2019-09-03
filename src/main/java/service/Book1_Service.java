package service;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Book;
import model.Type;
import until.ReturnInfo;


public interface Book1_Service {
	public int selectcount(String txt2);
	public Book selectById(int id);


	public List<Type> selectType();
	public ReturnInfo select(String txt2,Integer page,Integer max); 
	public void insert(Book b);
	public void update(Book b);
	public void delete(int id);
}
