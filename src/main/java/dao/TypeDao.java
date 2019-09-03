package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import model.Type;

@Repository
public interface TypeDao {

	@Select("select count(1) from type where name like '%${txt2}%'")
	public int selectcount(@Param("txt2")String txt2);
	@Select("select type.*, book.name bookname from type inner join book on type.bookid=book.id where type.name like '%${txt}%'  ${limit}")
	public List<Type> select(@Param("txt") String txt,@Param("limit")String limit ); 
	@Select("select type.*, book.name bookname from type inner join book on type.bookid=book.id where type.id=#{id}")
	public Type selectById(int id);

	@Insert("insert into type(name,status,bookid) values(#{name},#{status},#{bookid})")
	public void insert(Type t);
	@Update("update type set name=#{name},status=#{status},bookid=#{bookid} where id=#{id}")
	public void update(Type t);
	@Delete("delete from type where id=#{id}")
	public void delete(int id);
}
