package openweb.wmc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import openweb.wmc.model.Contact;
import openweb.wmc.model.ContactModel;

/**
 * @RestController = @Controller + @ResponseBody: 
 * Returns the body in JSON format by using a HttpMessagesConverter
 * @author ingmartic
 * @reference: https://openwebinars.net/academia/aprende/api-rest-spring-boot/7235/
 */
@RestController 
public class ContactController {
	
	@Autowired
	private ContactModel model;
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public List<Contact> getContacts(){
		return this.model.loadContacts();
	}
	
	@GetMapping(value="/contact")
	public Contact getContact(@RequestParam(value="id", defaultValue="1") String id) {
		return this.model.getContacts().stream().filter(c->c.getId().equals(id)).findAny().get();
	}
	
}
