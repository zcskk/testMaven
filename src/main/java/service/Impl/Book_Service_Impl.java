package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Book_Dao;
import model.Book;
import service.Book_service;
@Service
public class Book_Service_Impl implements Book_service{
	@Autowired
	Book_Dao dao;

	public List<Book> select(String txt) {
		// TODO Auto-generated method stub
		return dao.select(txt);
	}

	public Book selectbyid(int id) {
		// TODO Auto-generated method stub
		return dao.selectbyid(id);
	}

	public void insert(Book b) {
		// TODO Auto-generated method stub
		dao.insert(b);
	}

	public void update(Book b) {
		// TODO Auto-generated method stub
		dao.update(b);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

}
