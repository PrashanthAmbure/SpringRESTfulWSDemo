/**
 * 
 */
package com.xlncinc.client.services;

import com.xlncinc.client.model.Address;
import com.xlncinc.client.model.Person;

/**
 * @author PAmbure
 *
 */
public interface PersonService {
	void savePerson(Person person);
	void saveAddress(Address address);
	Person findPersonById(Long id) throws Exception;
	void updatePerson(Long id, Person person) throws Exception;
	void deletePerson(Long id) throws Exception;
}
