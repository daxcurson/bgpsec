package ar.strellis.com.bgpsec.model;

import java.util.List;

/**
 * The routing information base, or RIB, of the server. 
 * @author Agustín Villafañe
 *
 */
public class BgpRoutingInformationBase 
{
	private List<Route> local_routes;
	private List<Route> remote_routes;
	public List<Route> getLocal_routes() {
		return local_routes;
	}
	public void setLocal_routes(List<Route> local_routes) {
		this.local_routes = local_routes;
	}
	public List<Route> getRemote_routes() {
		return remote_routes;
	}
	public void setRemote_routes(List<Route> remote_routes) {
		this.remote_routes = remote_routes;
	}
}
