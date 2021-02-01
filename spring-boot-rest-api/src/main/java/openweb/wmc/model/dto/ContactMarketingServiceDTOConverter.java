package openweb.wmc.model.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import openweb.wmc.model.entities.Contact;

@Component
public class ContactMarketingServiceDTOConverter {

	private final ModelMapper modelMapper;
	
	@Autowired
	public ContactMarketingServiceDTOConverter(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public ContactServicesDTO convertToDTO(Contact contact) {
		return modelMapper.map(contact, ContactServicesDTO.class);
	}
	 
}
