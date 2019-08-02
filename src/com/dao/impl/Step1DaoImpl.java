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

import com.dao.Step1Dao;
import com.entity.Step1;

/**
 * A data access object (DAO) providing persistence and search support for Step1
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Step1
 * @author MyEclipse Persistence Tools
 */
@Service("step1Dao")
@Transactional
public class Step1DaoImpl extends HibernateDaoSupport implements Step1Dao {
	private static final Log log = LogFactory.getLog(Step1DaoImpl.class);
	// property constants
	public static final String STEP1_VALUE = "step1Value";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step1Dao#save(com.entity.Step1)
	 */
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void save(Step1 transientInstance) {
		log.debug("saving Step1 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step1Dao#delete(com.entity.Step1)
	 */
	@Override
	public void delete(Step1 persistentInstance) {
		log.debug("deleting Step1 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step1Dao#findById(java.lang.String)
	 */
	@Override
	public Step1 findById(java.lang.String id) {
		log.debug("getting Step1 instance with id: " + id);
		try {
			Step1 instance = (Step1) getHibernateTemplate().get(
					"com.entity.Step1", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Step1 instance) {
		log.debug("finding Step1 instance by example");
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
		log.debug("finding Step1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Step1 as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStep1Value(Object step1Value) {
		return findByProperty(STEP1_VALUE, step1Value);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step1Dao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Step1 instances");
		try {
			String queryString = "from Step1";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step1Dao#merge(com.entity.Step1)
	 */
	@Override
	public Step1 merge(Step1 detachedInstance) {
		log.debug("merging Step1 instance");
		try {
			Step1 result = (Step1) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Step1 instance) {
		log.debug("attaching dirty Step1 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Step1 instance) {
		log.debug("attaching clean Step1 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Step1Dao getFromApplicationContext(ApplicationContext ctx) {
		return (Step1Dao) ctx.getBean("Step1DAO");
	}
}