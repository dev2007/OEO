package com.awu.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.awu.DAL.DataVisitor;
import com.awu.models.User;
import com.awu.services.interfaces.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	private DataVisitor dataVisitor;
	
	private Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public boolean addUser(User model,StringBuilder message) {
		dataVisitor.openSession();
		try{
			dataVisitor.beginTransaction();
			ArrayList<User> users =  dataVisitor.select(String.format("from User where name = %s",model.getName()));
			if(users.size() > 0){
				message.append("用户名已存在");
				return false;
			}
			
			dataVisitor.save(model);
			dataVisitor.commitTransaction();
			return true;
		}catch (Exception e) {
			logger.error(e.getMessage());
			dataVisitor.rollbackTransaction();
			return false;
		}finally {
			dataVisitor.closeSession();
		}
	}

	@Override
	public boolean updateUser(User model,StringBuilder message) {
		dataVisitor.openSession();
		try{
			dataVisitor.beginTransaction();
			dataVisitor.update(model);
			dataVisitor.commitTransaction();
			return true;
		}catch (Exception e) {
			dataVisitor.rollbackTransaction();
			return false;
		}finally {
			dataVisitor.closeSession();
		}
	}

	@Override
	public boolean modifyPWD(User model,StringBuilder message) {
		dataVisitor.openSession();
		try{
			dataVisitor.beginTransaction();
			dataVisitor.update(model);
			dataVisitor.commitTransaction();
			return true;
		}catch (Exception e) {
			dataVisitor.rollbackTransaction();
			return false;
		}finally {
			dataVisitor.closeSession();
		}
	}

}
