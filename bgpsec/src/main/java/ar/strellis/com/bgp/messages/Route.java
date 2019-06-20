package ar.strellis.com.bgp.messages;

import java.util.List;

public class Route 
{
	private Op op;
	private int vrf_id;
	private Prefix prefix;
	private RouteType type;
	private RouteSubType sub_type;
	private int distance;
	private int metric;
	private int tag;
	private List<String> color;
	private List<NextHop> nexthops;
	private byte[] aux;
}