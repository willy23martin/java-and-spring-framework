package openweb.wmc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.server.ResponseStatusException;

import openweb.wmc.model.Contact;
import openweb.wmc.model.ContactModel;
// import openweb.wmc.model.dto.ContactMarketingServiceDTOConverter;
import openweb.wmc.model.exceptions.ContactException;


/**
 * @RestController = @Controller + @ResponseBody: Returns the body in JSON
 *                 format by using a HttpMessagesConverter
 * @author ingmartic
 * @reference: https://openwebinars.net/academia/aprende/api-rest-spring-boot/7235/
 */
//Cross-Origin Resource Sharing in a Controller:
@CrossOrigin(origins = {"http://localhost:4200"},
methods = {RequestMethod.GET, RequestMethod.POST})
@RestController
public class ContactController {

	@Autowired
	private ContactModel model;
	
	// @Autowired
	// private ContactMarketingServiceDTOConverter contactMarketingServiceDTOConverter;

	// Cross-Origin Resource Sharing in a method:
	@CrossOrigin(origins = {"http://localhost:4200"}) 
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ResponseEntity<?> getContacts() {
		List<Contact> contacts = this.model.loadContacts();
		if(contacts.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(contacts); 
		}
	}

	@GetMapping(value = "/contact")
	public Contact getContactParam(@RequestParam(value = "id", defaultValue = "1") String id) {
		/*Contact contact = this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseGet(new Supplier<Contact>() {
					@Override
					public Contact get() {
						return new Contact(id, "no exist", "no exist", "does not exist");
					}
				});
		if(contact.getName().equals("no exist")) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(contact);
				//return ResponseEntity.ok(contactMarketingServiceDTOConverter.convertToDTO(contact));	
		}*/
		return this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseThrow(() -> new ContactException("GLOB - Contact was not found with Id: " + id));
	}

	@GetMapping(value = "/contacts/{id}")
	public ResponseEntity<?> getContact(@PathVariable(value = "id") String id) throws ResponseStatusException{
		/*Contact contact = this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseGet(new Supplier<Contact>() {
					@Override
					public Contact get() {
						return new Contact(id, "no exist", "no exist", "does not exist");
					}
				});
		if(contact.getName().equals("no exist")) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(contact);
		}*/
		try {
			Contact contact = this.model.getContacts().stream().filter(c -> c.getId().equals(id)).findAny()
				.orElseThrow(() -> new ContactException("Throwable v5 -> Contact Not Found: " + id));
			return ResponseEntity.ok(contact);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
		
	}

	@PostMapping(value = "/contacts")
	public ResponseEntity<?> postContact(@RequestBody Contact contact) {
		Contact createdContact = this.model.createContact(contact);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);		
	}

	@PutMapping(value = "/contacts/{id}")
	public ResponseEntity<?> updateContact(@RequestBody Contact contact, @PathVariable(value = "id") String id) {
		Contact updatedContact = this.model.updateContact(contact, id);
		if(updatedContact.getName().equals("no exist")) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(updatedContact);
		}
	}
	
	@DeleteMapping(value="/contacts/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable String id) {
		Contact deletedContact = this.model.deleteContact(id);
		if(deletedContact.getName().equals("no exist")) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.noContent().build();	
		}
		
	}
	
	// Tight Coupled ExceptionHandler solution -> Handler that manage all ContactException displayed by this API Contoller.
	/**
	@ExceptionHandler(ContactException.class)
	public ResponseEntity<ApiError> handlerContactNotFound(ContactException contactException){
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.NOT_FOUND); 
		apiError.setDate(LocalDateTime.now()); 
		apiError.setMessage(contactException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}*/

}
