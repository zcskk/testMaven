package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;

@Repository
public interface Book_Dao {
	@Select("select Book.*,type.name typename from Book inner join type on Book.typeid=type.id ${txt}")
	public List<Book> select(@Param("txt") String txt);
	@Select("select Book.*,type.name typename from Book inner join type on Book.typeid=type.id where Book.id=#{id}")
	public Book selectbyid(int id);
	
	@Insert("insert into Book(name,sex,typeid) values(#{name},#{sex},#{typeid}) ")
	public void insert(Book b);
	@Update("update Book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id} ")
	public void update(Book b);
	@Delete("delete from Book where id=#{id}")
	public void delete(int id);
	
}
