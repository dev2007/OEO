package com.awu.services.interfaces;

import com.awu.models.User;

public interface IUserService {
	/**
	 * 添加用户
	 * @param model
	 * @param message
	 * @return
	 */
	boolean addUser(User model,StringBuilder message);
	
	/**
	 * 更新用户
	 * @param model
	 * @param message
	 * @return
	 */
	boolean updateUser(User model,StringBuilder message);
	
	/**
	 * 修改用户密码
	 * @param model
	 * @param message
	 * @return
	 */
	boolean modifyPWD(User model,StringBuilder message);
}
