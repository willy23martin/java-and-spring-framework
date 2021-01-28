package openweb.wmc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

	public List<Contact> loadContacts() {
		return this.contacts;
	}

	public synchronized Contact createContact(Contact newContact) {
		if (!this.contacts.stream().filter(c -> c.getId().equals(newContact.getId())).findAny().isPresent()) {
			this.contacts.add(newContact);
		}
		return this.contacts.stream().filter(c -> c.getId().equals(newContact.getId())).findAny().get();
	}

	public synchronized Contact updateContact(Contact contact, String id) {
		if (this.contacts.stream().filter(c -> c.getId().equals(id)).findAny().isPresent()) {
			this.contacts.removeIf(c -> c.getId().equals(id));
			this.contacts.add(contact);
		}
		return this.contacts.stream().filter(c -> c.getId().equals(id)).findAny().orElseGet(new Supplier<Contact>() {
			@Override
			public Contact get() {
				return new Contact(id, "no exist", "no exist", "does not exist");
			}
		});
	}

	public synchronized Contact deleteContact(String id) {
		Contact deletedContact = null;
		if (this.contacts.stream().filter(c -> c.getId().equals(id)).findAny().isPresent()) {
			deletedContact = this.contacts.stream().filter(c -> c.getId().equals(id)).findAny().get();
			this.contacts.removeIf(c -> c.getId().equals(id));
		}
		return deletedContact == null ? new Contact(id, "no exist", "no exist", "does not exist") : deletedContact;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
