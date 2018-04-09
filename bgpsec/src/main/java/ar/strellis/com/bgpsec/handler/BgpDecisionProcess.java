package ar.strellis.com.bgpsec.handler;

import ar.strellis.com.bgpsec.model.BgpPathAttributeTypeCode;
import ar.strellis.com.bgpsec.model.BgpOriginType;
import ar.strellis.com.bgpsec.model.BgpPathAttributeLocalPref;
import ar.strellis.com.bgpsec.model.BgpPathAttributeOrigin;
import ar.strellis.com.bgpsec.model.BgpRoutingInformationBase;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.model.MyConfiguration;

/**
 * Implements the BGP decision process, when an UPDATE message is received.
 *
 */
public class BgpDecisionProcess 
{
	private MyConfiguration configuration;
	private BgpRoutingInformationBase base;

	public BgpDecisionProcess(MyConfiguration c)
	{
		this.configuration=c;
		this.setBase(new BgpRoutingInformationBase());
	}
	public MyConfiguration getConfiguration() 
	{
		return configuration;
	}

	public void setConfiguration(MyConfiguration configuration) 
	{
		this.configuration = configuration;
	}
	/**
	 * The entry point to the decision process. Calls the phases specified in RFC 4271
	 * @param message
	 */
	public void processUpdate(BgpUpdate message) 
	{
		// Phase 1: Calculation of degree of preference.
		long preference=phase1_calculate_degree_of_preference(message);
		phase2_select_route(message,preference);
	}
	private long phase1_calculate_degree_of_preference(BgpUpdate message) 
	{
		/*
		 * For each newly received or replacement feasible route, the local BGP speaker
		 * determnies a degree of preference as follows:
		 * 
		 * If the route is learned from an internal peer, either the value of the LOCAL_PREF
		 * attribute is taken as the degree of preference, or the local system computes the
		 * degree of preference of the route based on preconfigured policy information.
		 * 
		 * If the route is learned from an external peer, then the local BGP speaker
		 * computes the degree of preference based on preconfigured policy information. If the return
		 * value indicates the route is ineligible, the route MAY NOT serve as an input to the next
		 * phase of the route selection; otherwise, the return value MUST be used as the LOCAL_PREF
		 * value in any IBGP readvertisement.
		 * 
		 * The exact nature of this policy information, and the computation involved, is a local matter. 
		 * 
		 * This is taken straight from the RFC 4271, but WHAT DOES IT REALLY MEAN????
		 */
		// First of all, I'll recover the value of the LOCAL_PREF attribute.
		long local_preference=0;
		BgpPathAttributeLocalPref p=(BgpPathAttributeLocalPref) message.getPath_attributes().get(BgpPathAttributeTypeCode.LOCAL_PREF.toString());
		BgpPathAttributeOrigin o=(BgpPathAttributeOrigin) message.getPath_attributes().get(BgpPathAttributeTypeCode.ORIGIN.toString());
		// If the route is learned from an internal peer, choose the value of the LOCAL_PREF property, if available.
		if(o!=null && o.getOrigin()==BgpOriginType.IGP)
		{
			if(p!=null && p.getValue()!=0)
				local_preference=p.getValue();
		}
		if(o!=null && o.getOrigin()==BgpOriginType.EGP)
		{
			// Choose the policy value. None at the moment.
		}
		return local_preference;
	}
	private void phase2_select_route(BgpUpdate message, long calculated_preference) 
	{
		// Now, process the route.
		// This ends in entering a value in the routing information database.
		
	}
	public BgpRoutingInformationBase getBase() {
		return base;
	}
	public void setBase(BgpRoutingInformationBase base) {
		this.base = base;
	}
}
