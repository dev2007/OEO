package com.awu.services.interfaces;

import com.awu.models.User;

public interface IUserService {
	/**
	 * ����û�
	 * @param model
	 * @param message
	 * @return
	 */
	boolean addUser(User model,StringBuilder message);
	
	/**
	 * �����û�
	 * @param model
	 * @param message
	 * @return
	 */
	boolean updateUser(User model,StringBuilder message);
	
	/**
	 * �޸��û�����
	 * @param model
	 * @param message
	 * @return
	 */
	boolean modifyPWD(User model,StringBuilder message);
}
