package service;

import java.util.List;

import org.springframework.stereotype.Service;

import model.Book;
import model.Type;
@Service
public interface Book_service {

	public List<Book> select(String txt) ;
	public Book selectbyid(int id);
	public void insert(Book b);
	public void update(Book b);
	public void delete(int id);
}
