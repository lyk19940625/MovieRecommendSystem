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

import com.dao.Step2Dao;
import com.entity.Step2;

/**
 * A data access object (DAO) providing persistence and search support for Step2
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Step2
 * @author MyEclipse Persistence Tools
 */
@Service("step2Dao")
@Transactional
public class Step2DaoImpl extends HibernateDaoSupport implements Step2Dao {
	private static final Log log = LogFactory.getLog(Step2DaoImpl.class);
	// property constants
	public static final String STEP2_VALUE = "step2Value";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step2Dao#save(com.entity.Step2)
	 */
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void save(Step2 transientInstance) {
		log.debug("saving Step2 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step2Dao#delete(com.entity.Step2)
	 */
	@Override
	public void delete(Step2 persistentInstance) {
		log.debug("deleting Step2 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step2Dao#findById(java.lang.String)
	 */
	@Override
	public Step2 findById(java.lang.String id) {
		log.debug("getting Step2 instance with id: " + id);
		try {
			Step2 instance = (Step2) getHibernateTemplate().get(
					"com.entity.Step2", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Step2 instance) {
		log.debug("finding Step2 instance by example");
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
		log.debug("finding Step2 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Step2 as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStep2Value(Object step2Value) {
		return findByProperty(STEP2_VALUE, step2Value);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step2Dao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Step2 instances");
		try {
			String queryString = "from Step2";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step2Dao#merge(com.entity.Step2)
	 */
	@Override
	public Step2 merge(Step2 detachedInstance) {
		log.debug("merging Step2 instance");
		try {
			Step2 result = (Step2) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Step2 instance) {
		log.debug("attaching dirty Step2 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Step2 instance) {
		log.debug("attaching clean Step2 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Step2Dao getFromApplicationContext(ApplicationContext ctx) {
		return (Step2Dao) ctx.getBean("Step2DAO");
	}
}