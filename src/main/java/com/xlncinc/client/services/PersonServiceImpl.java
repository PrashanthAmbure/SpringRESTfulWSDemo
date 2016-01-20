/**
 * 
 */
package com.xlncinc.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xlncinc.client.dao.PersonDAO;
import com.xlncinc.client.model.Address;
import com.xlncinc.client.model.Person;

/**
 * @author PAmbure
 *
 */
@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	
	@Override
	@Transactional
	public void savePerson(Person person) {
		personDAO.savePerson(person);
	}
	
	@Override
	@Transactional
	public void saveAddress(Address address) {
		personDAO.saveAddress(address);
	}

	@Override
	public Person findPersonById(Long id) throws Exception{
		Person person = personDAO.findPersonById(id);
		if(person == null){
			throw new Exception("No record found.");
		}
		return person;
	}

	@Override
	@Transactional
	public void updatePerson(Long id, Person newPerson) throws Exception{
		Person person = findPersonById(id);
		person.setPersonName(newPerson.getPersonName());
		person.setAge(newPerson.getAge());
		personDAO.updatePerson(person);
	}

	@Override
	@Transactional
	public void deletePerson(Long id) throws Exception{
		personDAO.deletePerson(findPersonById(id));
	}
}
