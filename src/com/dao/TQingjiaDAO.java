package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TQingjia;

/**
 * Data access object (DAO) for domain model class TQingjia.
 * 
 * @see com.model.TQingjia
 * @author MyEclipse Persistence Tools
 */

public class TQingjiaDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TQingjiaDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TQingjia transientInstance)
	{
		log.debug("saving TQingjia instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQingjia persistentInstance)
	{
		log.debug("deleting TQingjia instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQingjia findById(java.lang.Integer id)
	{
		log.debug("getting TQingjia instance with id: " + id);
		try
		{
			TQingjia instance = (TQingjia) getHibernateTemplate().get(
					"com.model.TQingjia", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TQingjia instance)
	{
		log.debug("finding TQingjia instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TQingjia instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TQingjia as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TQingjia instances");
		try
		{
			String queryString = "from TQingjia";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQingjia merge(TQingjia detachedInstance)
	{
		log.debug("merging TQingjia instance");
		try
		{
			TQingjia result = (TQingjia) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQingjia instance)
	{
		log.debug("attaching dirty TQingjia instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQingjia instance)
	{
		log.debug("attaching clean TQingjia instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQingjiaDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TQingjiaDAO) ctx.getBean("TQingjiaDAO");
	}
}