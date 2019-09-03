package service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BookDao;
import dao.TypeDao;
import model.Book;
import model.Type;
import service.Book1_Service;
import service.Type_Service;
import until.ReturnInfo;
@Service
public class Book1_Service_Impl implements Book1_Service {

	@Autowired
	BookDao dao;

	public Book selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	public ReturnInfo select(String txt2,Integer page,Integer max) {
		// TODO Auto-generated method stub
		ReturnInfo re = new ReturnInfo();
		
		re.setList(dao.select(txt2,re.getLimit(page, max)));
		re.setCount(dao.selectcount(txt2));
		return re;
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

	public List<Type> selectType() {
		 return dao.selectType();
		
	}

	public int selectcount(String txt2) {
		
		return dao.selectcount(txt2);
	}

	

	
	

}
