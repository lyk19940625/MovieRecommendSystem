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

import com.dao.Step4Dao;
import com.entity.Step4;

/**
 * A data access object (DAO) providing persistence and search support for Step4
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Step4
 * @author MyEclipse Persistence Tools
 */
@Service("step4Dao")
@Transactional
public class Step4DaoImpl extends HibernateDaoSupport implements Step4Dao {
	private static final Log log = LogFactory.getLog(Step4DaoImpl.class);
	// property constants
	public static final String STEP3_VALUE = "step3Value";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step4Dao#save(com.entity.Step4)
	 */
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	@Override
	public void save(Step4 transientInstance) {
		log.debug("saving Step4 instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step4Dao#delete(com.entity.Step4)
	 */
	@Override
	public void delete(Step4 persistentInstance) {
		log.debug("deleting Step4 instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step4Dao#findById(java.lang.String)
	 */
	@Override
	public Step4 findById(java.lang.String id) {
		log.debug("getting Step4 instance with id: " + id);
		try {
			Step4 instance = (Step4) getHibernateTemplate().get(
					"com.entity.Step4", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Step4 instance) {
		log.debug("finding Step4 instance by example");
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
		log.debug("finding Step4 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Step4 as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStep3Value(Object step3Value) {
		return findByProperty(STEP3_VALUE, step3Value);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step4Dao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Step4 instances");
		try {
			String queryString = "from Step4";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.Step4Dao#merge(com.entity.Step4)
	 */
	@Override
	public Step4 merge(Step4 detachedInstance) {
		log.debug("merging Step4 instance");
		try {
			Step4 result = (Step4) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Step4 instance) {
		log.debug("attaching dirty Step4 instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Step4 instance) {
		log.debug("attaching clean Step4 instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static Step4Dao getFromApplicationContext(ApplicationContext ctx) {
		return (Step4Dao) ctx.getBean("Step4DAO");
	}
}