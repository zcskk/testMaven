package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TypeDao;
import model.Type;
import service.Type1_Service;
import service.Type_Service;
import until.ReturnInfo;
@Service
public class Type1_Service_Impl implements Type1_Service {

	@Autowired
	TypeDao dao;
	

	public void insert(Type t) {
		// TODO Auto-generated method stub
		dao.insert(t);
	}

	public void update(Type t) {
		// TODO Auto-generated method stub
		dao.update(t);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	public Type selectById(int id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	public int selectcount(String txt2) {
		// TODO Auto-generated method stub
		return dao.selectcount(txt2);
	}

	public ReturnInfo select(String txt2, Integer page, Integer max) {
        ReturnInfo re = new ReturnInfo();
		
		re.setList(dao.select(txt2,re.getLimit(page, max)));
		re.setCount(dao.selectcount(txt2));
		return re;
	}

}
