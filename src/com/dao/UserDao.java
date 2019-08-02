package com.dao;

import java.util.List;

import com.entity.User;

public interface UserDao {

	public abstract void save(User transientInstance);

	public abstract void delete(User persistentInstance);

	public abstract User findById(java.lang.Integer id);

	public abstract List findByUname(Object uname);

	public abstract List findByPassword(Object password);

	public abstract List findByRecommend(Object recommend);

	public abstract List findAll();
	
	public abstract List findByScore1(Object score1);
	public abstract List findByScore2(Object score2);
	public abstract List findByScore3(Object score3);
	public abstract List findByScore4(Object score4);
	public abstract List findByScore5(Object score5);
	public abstract List findByScore6(Object score6);
	public abstract List findByScore7(Object score7);

	boolean login(int id, String password);
	
	boolean importUser(List<User> users);
	
	public abstract User merge(User detachedInstance);

}