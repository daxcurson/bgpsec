package ar.strellis.com.bgpsec.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * BGP Update message
 * @author Agustin Villafane
 *
 */
public class BgpUpdate extends BgpMessage
{
	/**
	 * Withdrawn routes - routes to remove from routing table.
	 */
	private List<Route> withdrawn_routes;
	private Map<String,BgpPathAttribute> path_attributes;
	private List<Route> reachability_information;
	public BgpUpdate()
	{
		super();
		setWithdrawn_routes(new LinkedList<Route>());
		setPath_attributes(new HashMap<String,BgpPathAttribute>());
		setReachability_information(new LinkedList<Route>());
	}
	public List<Route> getWithdrawn_routes() {
		return withdrawn_routes;
	}
	public void setWithdrawn_routes(List<Route> withdrawn_routes) {
		this.withdrawn_routes = withdrawn_routes;
	}
	public Map<String,BgpPathAttribute> getPath_attributes() {
		return path_attributes;
	}
	public void setPath_attributes(Map<String,BgpPathAttribute> path_attributes) {
		this.path_attributes = path_attributes;
	}
	public List<Route> getReachability_information() {
		return reachability_information;
	}
	public void setReachability_information(List<Route> reachability_information) {
		this.reachability_information = reachability_information;
	}
}
