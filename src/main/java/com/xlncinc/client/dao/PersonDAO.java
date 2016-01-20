/**
 * 
 */
package com.xlncinc.client.dao;

import com.xlncinc.client.model.Address;
import com.xlncinc.client.model.Person;

/**
 * @author PAmbure
 *
 */
public interface PersonDAO {
	void savePerson(Person person);
	void saveAddress(Address address);
	Person findPersonById(Long id);
	void updatePerson(Person newPerson);
	void deletePerson(Person person);
}
