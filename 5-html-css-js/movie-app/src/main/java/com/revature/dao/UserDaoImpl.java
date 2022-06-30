package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Movie;
import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public int insert(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		int pk = (int) ses.save(u);
		tx.commit();
		return pk;	}

	@Override
	public User selectById(int id) {
		Session ses = HibernateUtil.getSession();
		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public List<User> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<User> users = ses.createQuery("from User", User.class).list();
		return users;
	}

}
