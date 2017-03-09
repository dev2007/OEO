package com.awu.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.awu.models.User;
import com.awu.services.interfaces.IUserService;
import com.awu.viewmodels.AddUserVM;
import com.awu.viewmodels.JsonFailureMsg;
import com.awu.viewmodels.JsonMsg;
import com.awu.viewmodels.JsonSuccessMsg;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg addUser(AddUserVM model) {
		User user = new User();
		user.setName(model.getName());
		user.setPassword(model.getPassword());
		StringBuilder stringBuilder = new StringBuilder();
		if (userService.addUser(user, stringBuilder)) {
			return new JsonSuccessMsg("添加用户成功");
		} else {
			if (stringBuilder.length() == 0)
				return new JsonFailureMsg("添加用户失败");
			return new JsonFailureMsg(stringBuilder.toString());
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser() {
		throw new NotImplementedException();
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPWD() {
		throw new NotImplementedException();
	}
}
