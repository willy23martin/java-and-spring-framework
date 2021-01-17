/**
 * 
 */
package openweb.wmc.java.eight.stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import com.sun.el.stream.Optional;

public class OutboundCampaignResults {

	private List<String> wrapUpCodes;
	private Hashtable<String, String> outboundCampaignResults;
	
	/**
	 * 
	 */
	public OutboundCampaignResults() {
		this.initialize();
	}
	
	private void initialize() {
		wrapUpCodes = Arrays.asList("Busy", "Answer Machine", "No Line");
		outboundCampaignResults = new Hashtable<String, String>();
		outboundCampaignResults.put("contactA", "Busy");
		outboundCampaignResults.put("contactB", "Busy");
		outboundCampaignResults.put("contactC", "No Line");
		outboundCampaignResults.put("contactD", "Answer Machine");
		outboundCampaignResults.put("contactE", "No Line");
		outboundCampaignResults.put("contactF", "Busy");
		outboundCampaignResults.put("contactG", "Busy");
		outboundCampaignResults.put("contactH", "Answer Machine");
		outboundCampaignResults.put("contactI", "Answer Machine");
		outboundCampaignResults.put("contactJ", "SIT");
	}

	public List<OutboundResult> results(){
		List<OutboundResult> results = new ArrayList<OutboundResult>(); 
		Iterator<String> iter = this.outboundCampaignResults.keySet().iterator();
	    while(iter.hasNext()) {
	    	String key = iter.next();
	    	String wrapUpCode = outboundCampaignResults.get(key);
			OutboundResult outboundResult = new OutboundResult();
			outboundResult.setContact(key);
			outboundResult.setWrapUpCode(wrapUpCode); 
			results.add(outboundResult);
		}
	    return results;	    
	}

	public List<String> getWrapUpCodes() {
		return wrapUpCodes;
	}

	public void setWrapUpCodes(List<String> wrapUpCodes) {
		this.wrapUpCodes = wrapUpCodes;
	}

	public Hashtable<String, String> getOutboundCampaignResults() {
		return outboundCampaignResults;
	}

	public void setOutboundCampaignResults(Hashtable<String, String> outboundCampaignResults) {
		this.outboundCampaignResults = outboundCampaignResults;
	}

	
	
}
