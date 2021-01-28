package openweb.wmc.controllers;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import openweb.wmc.model.Contact;
import openweb.wmc.model.ContactModel;

/**
 * @RestController = @Controller + @ResponseBody: Returns the body in JSON
 *                 format by using a HttpMessagesConverter
 * @author ingmartic
 * @reference: https://openwebinars.net/academia/aprende/api-rest-spring-boot/7235/
 */
@RestController
public class ContactController {

	@Autowired
	private ContactModel model;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getContacts() {
		return this.model.loadContacts();
	}

	@GetMapping(value = "/contact")
	public Contact getContactParam(@RequestParam(value = "id", defaultValue = "1") String id) {
		return this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseGet(new Supplier<Contact>() {
					@Override
					public Contact get() {
						return new Contact(id, "no exist", "no exist", "does not exist");
					}
				});
	}

	@GetMapping(value = "/contacts/{id}")
	public Contact getContact(@PathVariable(value = "id") String id) {
		return this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseGet(new Supplier<Contact>() {
					@Override
					public Contact get() {
						return new Contact(id, "no exist", "no exist", "does not exist");
					}
				});
	}

	@PostMapping(value = "/contacts")
	public Contact postContact(@RequestBody Contact contact) {
		return this.model.createContact(contact);
	}

	@PutMapping(value = "/contacts/{id}")
	public Contact updateContact(@RequestBody Contact contact, @PathVariable(value = "id") String id) {
		return this.model.updateContact(contact, id);
	}
	
	@DeleteMapping(value="/contacts/{id}")
	public Contact deleteContact(@PathVariable String id) {
		return this.model.deleteContact(id);
	}

}
