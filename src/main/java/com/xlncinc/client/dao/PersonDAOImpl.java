/**
 * 
 */
package com.xlncinc.client.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xlncinc.client.model.Address;
import com.xlncinc.client.model.Person;
import com.xlncinc.core.services.PersistentDependentServiceImpl;

/**
 * @author PAmbure
 *
 */
@Repository
public class PersonDAOImpl extends PersistentDependentServiceImpl implements PersonDAO {
	
	@Autowired
	public PersonDAOImpl(SessionFactory pmf){
		super(pmf);
	}
	
	@Override
	public void savePerson(Person person) {
		getDao().save(person);
	}
	
	@Override
	public void saveAddress(Address address) {
		getDao().save(address);
	}

	@Override
	public Person findPersonById(Long id) {
		return (Person)getDao().get(Person.class, id);
	}

	@Override
	public void updatePerson(Person person) {
		getDao().saveOrUpdate(person);
	}

	@Override
	public void deletePerson(Person person) {
		getDao().delete(person);
	}
}
