package service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Type;
import until.ReturnInfo;

public interface Type1_Service {
	public int selectcount(String txt2);
	public Type selectById(int id);



	public ReturnInfo select(String txt2,Integer page,Integer max); 
	public void insert(Type t);
	public void update(Type t);
	public void delete(int id);
}
