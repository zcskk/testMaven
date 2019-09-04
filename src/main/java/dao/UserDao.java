package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;
import model.User;
@Repository
public interface UserDao {
	
	@Select("select * from user where name=#{name} and pass=#{pass}")
	public User login(User u);

	@Select("select * from user  ${txt}")
	public List<User> select(@Param("txt") String txt);
	@Select("select * from user  where id=#{id}")
	public User selectbyid(int id);
	
	@Insert("insert into user(name,pass) values(#{name},#{pass}) ")
	public void insert(User b);
	@Update("update user set name=#{name},pass=#{pass} where id=#{id} ")
	public void update(User b);
	@Delete("delete from user where id=#{id}")
	public void delete(int id);
}
