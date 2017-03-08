package com.awu.DAL;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataVisitor {
	private static Configuration configuration = new Configuration().configure();
	private static SessionFactory factory = configuration.buildSessionFactory();
	private Session session = null;

	public void openSession() {
		session = factory.openSession();
	}

	public void beginTransaction() throws Exception {
		if (session == null)
			throw new Exception("transaction begin error,session is null");
		session.beginTransaction();
	}

	public void commitTransaction() throws Exception {
		if (session == null)
			throw new Exception("transaction commit error,session is null");
		session.getTransaction().commit();
	}

	public void rollbackTransaction() {
		session.getTransaction().rollback();
	}

	public void closeSession() {
		if (session != null) {
			if (session.isOpen())
				session.close();
		}
	}

	public <T> void save(T model) {
		session.save(model);
	}

	public <T> void update(T model) {
		session.update(model);
	}

	public <T> void delete(T model) {
		session.delete(model);
	}

	public <T> ArrayList<T> select(String selectHQL) {
		return (ArrayList<T>) session.createQuery(selectHQL).list();
	}
	
	public <T> T selectUnique(String selectHQL){
		return (T)session.createQuery(selectHQL).uniqueResult();
	}

}
