package edu.ecjtu.Dao.Impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDaoBean {
	@Autowired
	private SessionFactory sessionFactory;

	public  Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
