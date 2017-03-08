package com.awu.services.interfaces;

import com.awu.models.User;

public interface IUserService {
	boolean addUser(User model);
	boolean updateUser(User model);
	boolean modifyPWD(User model);
}
