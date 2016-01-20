/**
 * 
 */
package com.xlncinc.client.controllers;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xlncinc.client.model.Address;
import com.xlncinc.client.model.Person;
import com.xlncinc.client.services.PersonService;

/**
 * @author PAmbure
 *
 */
@RestController
@RequestMapping(value="/persons")
public class PersonController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	public PersonService personService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public void addPerson(@RequestBody Person person){
		
		Address address1 = new Address();
		address1.setCountry("US");
		address1.setState("NY");
		address1.setCity("NYC");
		address1.setPostalCode(new Long(10001));
		
		Address address2 = new Address();
		address2.setCountry("US");
		address2.setState("California");
		address2.setCity("San Francisco");
		address2.setPostalCode(new Long(94102));
		
		person.getAddress().add(address1);
		person.getAddress().add(address2);
		address1.setPerson(person);
		address2.setPerson(person);
		
		personService.savePerson(person);
		personService.saveAddress(address1);
		personService.saveAddress(address2);
	}
	
	@RequestMapping(value="/load/{id}")
	public void findPerson(@PathVariable(value="id") Long id) throws Exception{
		try{
			Person person =  personService.findPersonById(id);
			Collection<Address> addressList = person.getAddress();
			for(Address address:addressList){
				System.out.println("Address: "+address.getId());
				System.out.println(address.getCountry()+"-"+address.getState()+"-"+address.getCity()+"-"+address.getPostalCode());
				System.out.println("----------");
			}
//			return person;
		}catch(Exception ex){
			LOG.debug("Exception occurred while loading the person: {}"+ex.getLocalizedMessage());
			throw ex;
		}
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public String updatePerson(@PathVariable(value="id") Long id, @RequestBody Person person) throws Exception{
		personService.updatePerson(id, person);
		return "Person ID: "+id+" udpated successfully !";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String deletePerson(@PathVariable(value="id") Long id) throws Exception{
		personService.deletePerson(id);
		return "Person ID: "+id+" deleted successfully.";
	}
}
