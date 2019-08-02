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

import com.dao.MovieDao;
import com.entity.Movie;
import com.entity.User;

/**
 * A data access object (DAO) providing persistence and search support for Movie
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.entity.Movie
 * @author MyEclipse Persistence Tools
 */
@Service("movieDao")
@Transactional
public class MovieDaoImpl extends HibernateDaoSupport implements MovieDao {
	private static final Log log = LogFactory.getLog(MovieDaoImpl.class);
	// property constants
	public static final String MNAME = "mname";

	protected void initDao() {
		// do nothing
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#save(com.entity.Movie)
	 */
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public boolean importMovie(List<Movie> movies) {
		// TODO Auto-generated method stub
		try {
			for (Movie movie : movies) {
				this.getHibernateTemplate().save(movie);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public void save(Movie transientInstance) {
		log.debug("saving Movie instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#delete(com.entity.Movie)
	 */
	@Override
	public void delete(Movie persistentInstance) {
		log.debug("deleting Movie instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#findById(java.lang.Integer)
	 */
	@Override
	public Movie findById(java.lang.Integer id) {
		log.debug("getting Movie instance with id: " + id);
		try {
			Movie instance = (Movie) getHibernateTemplate().get(
					"com.entity.Movie", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Movie instance) {
		log.debug("finding Movie instance by example");
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
		log.debug("finding Movie instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Movie as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#findByMname(java.lang.Object)
	 */
	@Override
	public List findByMname(Object mname) {
		return findByProperty(MNAME, mname);
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#findAll()
	 */
	@Override
	public List findAll() {
		log.debug("finding all Movie instances");
		try {
			String queryString = "from Movie";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.dao.impl.MovieDao#merge(com.entity.Movie)
	 */
	@Override
	public Movie merge(Movie detachedInstance) {
		log.debug("merging Movie instance");
		try {
			Movie result = (Movie) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Movie instance) {
		log.debug("attaching dirty Movie instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Movie instance) {
		log.debug("attaching clean Movie instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MovieDao getFromApplicationContext(ApplicationContext ctx) {
		return (MovieDao) ctx.getBean("MovieDAO");
	}
}