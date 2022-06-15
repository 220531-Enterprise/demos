package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.models.SuperPrison;
import com.revature.models.SuperVillain;
import com.revature.util.HibernateUtil;

public class SuperVillainDao {

	// CREATE
	public int insert(SuperVillain sv) {

		Session ses = HibernateUtil.getSession();

		Transaction tx = ses.beginTransaction();

		int pk = (int) ses.save(sv);

		tx.commit();

		return pk;
	}
	
	// READ: return all
	// 3 ways to query in HIbernate
	// 1st way is HQL: Hibernate Query Language: weird mix of Native SQL and OOP
	public List<SuperVillain> selectAll() {
		
		// grab the session
		Session ses = HibernateUtil.getSession();
		
		// create a query and save return value to svill list
		List<SuperVillain> villList = ses.createQuery("from SuperVillain", SuperVillain.class).list();
		
		// return the list
		return villList;
	}
	
	public SuperVillain selectByName(String name) {
		
		// grab the sesion
		Session ses = HibernateUtil.getSession();
		
		// create a query
		
		// NATIVE SQL
		// ses.createQuery("SELECT * FROM supervillains WHERE name = '" + name + "'", SuperVillain.class);
		
		// HQL - Hibernate Query Language
		SuperVillain vill = (SuperVillain) ses.createQuery("from SuperVillain where name = '" + name + "'", SuperVillain.class);
		
		
		// Criteria API - just another way of querying -- purely OOP
		//ses.createCriteria(SuperVillain.class).add(Restrictions.like("name", name));
		
		return vill;
	}

}
