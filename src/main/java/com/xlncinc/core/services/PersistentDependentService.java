/**
 * 
 */
package com.xlncinc.core.services;

import org.hibernate.SessionFactory;

/**
 * @author PAmbure
 *
 */
public interface PersistentDependentService {
	
	SessionFactory getPersistenceManagerFactory();
}
