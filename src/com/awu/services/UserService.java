package com.awu.services;

import com.awu.DAL.DataVisitor;
import com.awu.models.User;
import com.awu.services.interfaces.IUserService;

public class UserService implements IUserService {
	private DataVisitor dataVisitor;
	
	public UserService(DataVisitor dataVisitor) {
		this.dataVisitor= dataVisitor;
	}

	@Override
	public boolean addUser(User model) {
		dataVisitor.openSession();
		try{
			//TODO:数据校验
			dataVisitor.save(model);
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
	public boolean updateUser(User model) {
		dataVisitor.openSession();
		try{
			//TODO:数据校验
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
	public boolean modifyPWD(User model) {
		dataVisitor.openSession();
		try{
			//TODO:数据校验
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
