package com.awu.actions;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.awu.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	public String execute(){
		System.out.println("Search");
		getData();
		return SUCCESS;
	}
	
	private void getData(){
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = null;
		try{
			session = factory.openSession();
			session.beginTransaction();
//			ArrayList<User> result = (ArrayList<User>) session.createQuery("from User").list();
			session.createQuery("from User").uniqueResult();
			System.out.println(session.get(User.class,"402895da5a6def38015a6def39d80000").getUsername());
			
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
