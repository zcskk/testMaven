package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Book;
import model.Type;

@Repository
public interface BookDao {

	
	@Select("select count(1) from Book where name like '%${txt2}%'")
	public int selectcount(@Param("txt2")String txt2);
	
	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid  where book.name like '%${txt2}%' ${limit} ")
	public List<Book> select(@Param("txt2")String txt2,@Param("limit")String limit); 
	@Select("select book.*,type.name typename from book inner join type on type.id=book.typeid where book.id=#{id}")
	public Book selectById(int id);
	
	@Insert("insert into book(name,sex,typeid) values(#{name},#{sex},#{typeid})")
	public void insert(Book b);
	@Update("update book set name=#{name},sex=#{sex},typeid=#{typeid} where id=#{id}")
	public void update(Book t);
	@Delete("delete from book where id=#{id}")
	public void delete(int id);
	@Select("select * from type ")
	public List<Type> selectType();
}
