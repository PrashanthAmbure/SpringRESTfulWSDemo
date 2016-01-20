/**
 * 
 */
package com.xlncinc.core.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

/**
 * @author PAmbure
 *
 */
public class XlncDAO extends HibernateTemplate{
	
	public XlncDAO(){
		super();
	}
	
	public XlncDAO(SessionFactory sessionFactory){
		super(sessionFactory);
	}
}
