package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TGongzi;

/**
 * Data access object (DAO) for domain model class TGongzi.
 * 
 * @see com.model.TGongzi
 * @author MyEclipse Persistence Tools
 */

public class TGongziDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TGongziDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TGongzi transientInstance)
	{
		log.debug("saving TGongzi instance");
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

	public void delete(TGongzi persistentInstance)
	{
		log.debug("deleting TGongzi instance");
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

	public TGongzi findById(java.lang.Integer id)
	{
		log.debug("getting TGongzi instance with id: " + id);
		try
		{
			TGongzi instance = (TGongzi) getHibernateTemplate().get(
					"com.model.TGongzi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TGongzi instance)
	{
		log.debug("finding TGongzi instance by example");
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
		log.debug("finding TGongzi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TGongzi as model where model."
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
		log.debug("finding all TGongzi instances");
		try
		{
			String queryString = "from TGongzi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TGongzi merge(TGongzi detachedInstance)
	{
		log.debug("merging TGongzi instance");
		try
		{
			TGongzi result = (TGongzi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TGongzi instance)
	{
		log.debug("attaching dirty TGongzi instance");
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

	public void attachClean(TGongzi instance)
	{
		log.debug("attaching clean TGongzi instance");
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

	public static TGongziDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TGongziDAO) ctx.getBean("TGongziDAO");
	}
}