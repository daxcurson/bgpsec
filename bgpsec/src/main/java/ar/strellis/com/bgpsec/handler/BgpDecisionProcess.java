package ar.strellis.com.bgpsec.handler;

import ar.strellis.com.bgpsec.model.BgpRoutingInformationBase;
import ar.strellis.com.bgpsec.model.BgpUpdate;
import ar.strellis.com.bgpsec.model.MyConfiguration;

/**
 * Implements the BGP decision process, when an UPDATE message is received.
 * @author Agustín Villafañe
 *
 */
public class BgpDecisionProcess 
{
	private MyConfiguration configuration;
	private BgpRoutingInformationBase base;

	public BgpDecisionProcess(MyConfiguration c)
	{
		this.configuration=c;
		this.base=new BgpRoutingInformationBase();
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
		phase1_calculate_degree_of_preference(message);
		phase2_select_route(message);
	}
	private void phase1_calculate_degree_of_preference(BgpUpdate message) 
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
	}
	private void phase2_select_route(BgpUpdate message) 
	{
	}
}
