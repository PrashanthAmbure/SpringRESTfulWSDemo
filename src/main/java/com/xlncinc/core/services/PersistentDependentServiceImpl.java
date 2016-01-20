/**
 * 
 */
package com.xlncinc.core.services;

import org.hibernate.SessionFactory;

import com.xlncinc.core.dao.XlncDAO;

/**
 * @author PAmbure
 *
 */
public class PersistentDependentServiceImpl implements PersistentDependentService {

	private SessionFactory pmf;
	
	public PersistentDependentServiceImpl(){
		
	}
    
    public PersistentDependentServiceImpl(SessionFactory pmf){
        this.pmf = pmf;
    }
    
    public final SessionFactory getPersistenceManagerFactory(){
        return pmf;
    }
    
    protected final XlncDAO getDao(){
        return new XlncDAO(getPersistenceManagerFactory());
    }

}
