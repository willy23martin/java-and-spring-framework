package openweb.wmc.java.eight.stream.api;

import lombok.*;

@Data // POJO: Constructor, Getters/Setters, equals, hashCode and toString
public class OutboundResult implements Comparable<OutboundResult>{
	
	private String contact;
	private String wrapUpCode;
	
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getWrapUpCode() {
		return wrapUpCode;
	}
	public void setWrapUpCode(String wrapUpCode) {
		this.wrapUpCode = wrapUpCode;
	}
	@Override
	public int compareTo(OutboundResult o) {
		return wrapUpCode.compareTo(o.wrapUpCode); 
	}
	
	public String toString() {
		return "OutbountResult: " + contact + " - " + wrapUpCode;
	}
	
}
