package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TQiantui;

/**
 * A data access object (DAO) providing persistence and search support for
 * TQiantui entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TQiantui
 * @author MyEclipse Persistence Tools
 */

public class TQiantuiDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TQiantuiDAO.class);
	// property constants
	public static final String YUANGONG_ID = "yuangongId";
	public static final String RIQI = "riqi";
	public static final String SHIJIAN = "shijian";
	public static final String SHUXING = "shuxing";

	protected void initDao() {
		// do nothing
	}

	public void save(TQiantui transientInstance) {
		log.debug("saving TQiantui instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQiantui persistentInstance) {
		log.debug("deleting TQiantui instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQiantui findById(java.lang.Integer id) {
		log.debug("getting TQiantui instance with id: " + id);
		try {
			TQiantui instance = (TQiantui) getHibernateTemplate().get(
					"com.model.TQiantui", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TQiantui instance) {
		log.debug("finding TQiantui instance by example");
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
		log.debug("finding TQiantui instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TQiantui as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYuangongId(Object yuangongId) {
		return findByProperty(YUANGONG_ID, yuangongId);
	}

	public List findByRiqi(Object riqi) {
		return findByProperty(RIQI, riqi);
	}

	public List findByShijian(Object shijian) {
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByShuxing(Object shuxing) {
		return findByProperty(SHUXING, shuxing);
	}

	public List findAll() {
		log.debug("finding all TQiantui instances");
		try {
			String queryString = "from TQiantui";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQiantui merge(TQiantui detachedInstance) {
		log.debug("merging TQiantui instance");
		try {
			TQiantui result = (TQiantui) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQiantui instance) {
		log.debug("attaching dirty TQiantui instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQiantui instance) {
		log.debug("attaching clean TQiantui instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQiantuiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TQiantuiDAO) ctx.getBean("TQiantuiDAO");
	}
}