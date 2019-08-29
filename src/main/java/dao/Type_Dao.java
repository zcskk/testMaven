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
public interface Type_Dao {

	@Select("select type.*,book.name bookname from type inner join book on type.bookid=book.id ${txt}")
	public List<Type> select(@Param("txt") String txt);
	@Insert("insert into type(name,status,bookid) values(#{name},#{status},#{bookid}) ")
	public void insert(Type t);
	@Update("update type set name=#{name},status=#{status},bookid=#{bookid} where id=#{id} ")
	public void update(Type t);
	@Delete("delete from type where id=#{id}")
	public void delete(int id);
}
