package com.awu.controllers;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awu.models.User;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping("/search")
public class SearchController {
	@RequestMapping("/index")
	public String search(){
		System.out.println("Search");
		getData();
		return "result";
	}
	
	private void getData(){
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = null;
		try{
			session = factory.openSession();
//			session.beginTransaction();
			ArrayList<User> result = (ArrayList<User>) session.createQuery("from User").list();
//			User user =  new User();
//			user.setName("123");
//			session.save(user);
//			session.getTransaction().commit();
			
			session.beginTransaction();
			session.createQuery("from User").uniqueResult();
			User user = session.get(User.class,"402895da5a6def38015a6def39d80000");
			System.out.println(user.getName());
			System.out.println(user.getEnabled());
			
			session.getTransaction().commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			session.getTransaction().rollback();
		}finally {
			if(session != null){
				if(session.isOpen())
					session.close();
			}
		}

	}
}
