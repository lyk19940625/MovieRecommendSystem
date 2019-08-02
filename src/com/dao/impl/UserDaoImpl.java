package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;

import com.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.User
 * @author MyEclipse Persistence Tools
 */
@Service("userDao")
@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);
	// property constants
	public static final String UNAME = "uname";
	public static final String PASSWORD = "password";
	public static final String SEX = "sex";
	public static final String SCORE1 = "score1";
	public static final String SCORE2 = "score2";
	public static final String SCORE3 = "score3";
	public static final String SCORE4 = "score4";
	public static final String SCORE5 = "score5";
	public static final String SCORE6 = "score6";
	public static final String SCORE7 = "score7";
	public static final String RECOMMEND = "recommend";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#save(com.entity.User)
	 */
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public boolean importUser(List<User> users) {
		// TODO Auto-generated method stub
		try {
			for (User user : users) {
				this.getHibernateTemplate().save(user);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean login(int id, String password) {
	User u = (User) getHibernateTemplate().get("com.entity.User", id);

		if(u.getPassword().equals(password)){
    		
		return true;
	  }
		else 
			return false;
	}
	@Override
	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#delete(com.entity.User)
	 */
	@Override
	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#findById(java.lang.Integer)
	 */
	@Override
	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"com.entity.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#findByUname(java.lang.Object)
	 */
	@Override
	public List findByUname(Object uname) {
		return findByProperty(UNAME, uname);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#findByPassword(java.lang.Object)
	 */
	@Override
	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByScore1(Object score1) {
		return findByProperty(SCORE1, score1);
	}

	public List findByScore2(Object score2) {
		return findByProperty(SCORE2, score2);
	}

	public List findByScore3(Object score3) {
		return findByProperty(SCORE3, score3);
	}

	public List findByScore4(Object score4) {
		return findByProperty(SCORE4, score4);
	}

	public List findByScore5(Object score5) {
		return findByProperty(SCORE5, score5);
	}

	public List findByScore6(Object score6) {
		return findByProperty(SCORE6, score6);
	}

	public List findByScore7(Object score7) {
		return findByProperty(SCORE7, score7);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#findByRecommend(java.lang.Object)
	 */
	@Override
	public List findByRecommend(Object recommend) {
		return findByProperty(RECOMMEND, recommend);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.UserDao#merge(com.entity.User)
	 */
	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserDao getFromApplicationContext(ApplicationContext ctx) {
		return (UserDao) ctx.getBean("UserDAO");
	}
}