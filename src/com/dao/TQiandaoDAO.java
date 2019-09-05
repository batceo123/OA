package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TQiandao;

/**
 * Data access object (DAO) for domain model class TQiandao.
 * 
 * @see com.model.TQiandao
 * @author MyEclipse Persistence Tools
 */

public class TQiandaoDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TQiandaoDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TQiandao transientInstance)
	{
		log.debug("saving TQiandao instance");
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

	public void delete(TQiandao persistentInstance)
	{
		log.debug("deleting TQiandao instance");
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

	public TQiandao findById(java.lang.Integer id)
	{
		log.debug("getting TQiandao instance with id: " + id);
		try
		{
			TQiandao instance = (TQiandao) getHibernateTemplate().get(
					"com.model.TQiandao", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TQiandao instance)
	{
		log.debug("finding TQiandao instance by example");
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
		log.debug("finding TQiandao instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TQiandao as model where model."
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
		log.debug("finding all TQiandao instances");
		try
		{
			String queryString = "from TQiandao";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQiandao merge(TQiandao detachedInstance)
	{
		log.debug("merging TQiandao instance");
		try
		{
			TQiandao result = (TQiandao) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQiandao instance)
	{
		log.debug("attaching dirty TQiandao instance");
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

	public void attachClean(TQiandao instance)
	{
		log.debug("attaching clean TQiandao instance");
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

	public static TQiandaoDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TQiandaoDAO) ctx.getBean("TQiandaoDAO");
	}
}