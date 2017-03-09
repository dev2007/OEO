package com.awu.DAL;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class DataVisitor {
	private static Configuration configuration = new Configuration().configure();
	private static SessionFactory factory = configuration.buildSessionFactory();
	private Session session = null;
	private Logger logger =  LogManager.getLogger(this.getClass());

	public void openSession() {
		logger.debug("open session");
		session = factory.openSession();
	}

	public void beginTransaction() throws Exception {
		logger.debug("begin trans");
		if (session == null){
			logger.error("transaction begin error,session is null");
		}
		session.beginTransaction();
	}

	public void commitTransaction() throws Exception {
		logger.debug("commit trans");
		if (session == null){
			throw new Exception("transaction commit error,session is null");
		}
		session.getTransaction().commit();
	}

	public void rollbackTransaction() {
		logger.debug("rollback trans");
		session.getTransaction().rollback();
	}

	public void closeSession() {
		logger.debug("close session");
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
