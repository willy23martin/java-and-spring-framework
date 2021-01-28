package openweb.wmc.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("CONTACTMODEL")
@Order(1)
public class ContactModel {

	private List<Contact> contacts;
	
	public ContactModel() {
		this.contacts = new ArrayList<Contact>();	
		this.contacts.add(new Contact("1", "Name 1", "name1@subdomain.domain", "0398765656"));
		this.contacts.add(new Contact("2", "Name 2", "name2@subdomain.domain", "0298765656"));
		this.contacts.add(new Contact("3", "Name 3", "name3@subdomain.domain", "0198765656"));
	}

	public synchronized List<Contact> loadContacts(){
		return this.contacts;
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
