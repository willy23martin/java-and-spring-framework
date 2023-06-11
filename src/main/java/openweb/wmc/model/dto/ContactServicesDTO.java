package openweb.wmc.model.dto;

public class ContactServicesDTO {

	private String contactId;
	
	private String contactName;
	
	private String contactMarketingPreferredServiceId;
	private String contactMarketingPreferredServiceName;
	
	public ContactServicesDTO() {
		
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMarketingPreferredServiceId() {
		return contactMarketingPreferredServiceId;
	}

	public void setContactMarketingPreferredServiceId(String contactMarketingPreferredServiceId) {
		this.contactMarketingPreferredServiceId = contactMarketingPreferredServiceId;
	}

	public String getContactMarketingPreferredServiceName() {
		return contactMarketingPreferredServiceName;
	}

	public void setContactMarketingPreferredServiceName(String contactMarketingPreferredServiceName) {
		this.contactMarketingPreferredServiceName = contactMarketingPreferredServiceName;
	}

	
	
}
