package ar.strellis.com.bgp.messages;

public enum Op {
	ZEBRA_INTERFACE_ADD	(0),
	ZEBRA_INTERFACE_DELETE	(1),
	ZEBRA_INTERFACE_ADDRESS_ADD	(2),
	ZEBRA_INTERFACE_ADDRESS_DELETE	(3),
	ZEBRA_INTERFACE_UP	(4),
	ZEBRA_INTERFACE_DOWN	(5),
	ZEBRA_INTERFACE_SET_MASTER	(6),
	ZEBRA_ROUTE_ADD	(7),
	ZEBRA_ROUTE_DELETE	(8),
	ZEBRA_ROUTE_NOTIFY_OWNER	(9),
	ZEBRA_REDISTRIBUTE_ADD	(10),
	ZEBRA_REDISTRIBUTE_DELETE	(11),
	ZEBRA_REDISTRIBUTE_DEFAULT_ADD	(12),
	ZEBRA_REDISTRIBUTE_DEFAULT_DELETE	(13),
	ZEBRA_ROUTER_ID_ADD	(14),
	ZEBRA_ROUTER_ID_DELETE	(15),
	ZEBRA_ROUTER_ID_UPDATE	(16),
	ZEBRA_HELLO	(17),
	ZEBRA_CAPABILITIES	(18),
	ZEBRA_NEXTHOP_REGISTER	(19),
	ZEBRA_NEXTHOP_UNREGISTER	(20),
	ZEBRA_NEXTHOP_UPDATE	(21),
	ZEBRA_INTERFACE_NBR_ADDRESS_ADD	(22),
	ZEBRA_INTERFACE_NBR_ADDRESS_DELETE	(23),
	ZEBRA_INTERFACE_BFD_DEST_UPDATE	(24),
	ZEBRA_IMPORT_ROUTE_REGISTER	(25),
	ZEBRA_IMPORT_ROUTE_UNREGISTER	(26),
	ZEBRA_IMPORT_CHECK_UPDATE	(27),
	ZEBRA_BFD_DEST_REGISTER	(28),
	ZEBRA_BFD_DEST_DEREGISTER	(29),
	ZEBRA_BFD_DEST_UPDATE	(30),
	ZEBRA_BFD_DEST_REPLAY	(31),
	ZEBRA_REDISTRIBUTE_ROUTE_ADD	(32),
	ZEBRA_REDISTRIBUTE_ROUTE_DEL	(33),
	ZEBRA_VRF_UNREGISTER	(34),
	ZEBRA_VRF_ADD	(35),
	ZEBRA_VRF_DELETE	(36),
	ZEBRA_VRF_LABEL	(37),
	ZEBRA_INTERFACE_VRF_UPDATE			(38),
	ZEBRA_BFD_CLIENT_REGISTER			(39),
	ZEBRA_BFD_CLIENT_DEREGISTER			(40),
	ZEBRA_INTERFACE_ENABLE_RADV			(41),
	ZEBRA_INTERFACE_DISABLE_RADV		(42),
	ZEBRA_IPV3_NEXTHOP_LOOKUP_MRIB		(43),
	ZEBRA_INTERFACE_LINK_PARAMS			(44),
	ZEBRA_MPLS_LABELS_ADD				(45),
	ZEBRA_MPLS_LABELS_DELETE			(46),
	ZEBRA_IPMR_ROUTE_STATS				(47),
	ZEBRA_LABEL_MANAGER_CONNECT			(48),
	ZEBRA_LABEL_MANAGER_CONNECT_ASYNC	(49),
	ZEBRA_GET_LABEL_CHUNK				(50),
	ZEBRA_RELEASE_LABEL_CHUNK			(51),
	ZEBRA_FEC_REGISTER					(52),
	ZEBRA_FEC_UNREGISTER				(53),
	ZEBRA_FEC_UPDATE					(54),
	ZEBRA_ADVERTISE_DEFAULT_GW			(55),
	ZEBRA_ADVERTISE_SUBNET				(56),
	ZEBRA_ADVERTISE_ALL_VNI				(57),
	ZEBRA_LOCAL_ES_ADD					(58),
	ZEBRA_LOCAL_ES_DEL					(59),
	ZEBRA_VNI_ADD						(60),
	ZEBRA_VNI_DEL						(61),
	ZEBRA_L3VNI_ADD						(62),
	ZEBRA_L3VNI_DEL						(63),
	ZEBRA_REMOTE_VTEP_ADD				(64),
	ZEBRA_REMOTE_VTEP_DEL				(65),
	ZEBRA_MACIP_ADD						(66),
	ZEBRA_MACIP_DEL						(67),
	ZEBRA_IP_PREFIX_ROUTE_ADD			(68),
	ZEBRA_IP_PREFIX_ROUTE_DEL			(69),
	ZEBRA_REMOTE_MACIP_ADD				(70),
	ZEBRA_REMOTE_MACIP_DEL				(71),
	ZEBRA_PW_ADD						(72),
	ZEBRA_PW_DELETE						(73),
	ZEBRA_PW_SET						(74),
	ZEBRA_PW_UNSET						(75),
	ZEBRA_PW_STATUS_UPDATE				(76),
	ZEBRA_RULE_ADD						(77),
	ZEBRA_RULE_DELETE					(78),
	ZEBRA_RULE_NOTIFY_OWNER				(79),
	ZEBRA_TABLE_MANAGER_CONNECT			(80),
	ZEBRA_GET_TABLE_CHUNK				(81),
	ZEBRA_RELEASE_TABLE_CHUNK			(82),
	ZEBRA_IPSET_CREATE					(83),
	ZEBRA_IPSET_DESTROY					(84),
	ZEBRA_IPSET_ENTRY_ADD				(85),
	ZEBRA_IPSET_ENTRY_DELETE			(86),
	ZEBRA_IPSET_NOTIFY_OWNER			(87),
	ZEBRA_IPSET_ENTRY_NOTIFY_OWNER		(88),
	ZEBRA_IPTABLE_ADD					(89),
	ZEBRA_IPTABLE_DELETE				(90),
	ZEBRA_IPTABLE_NOTIFY_OWNER			(91),
	ZEBRA_VXLAN_FLOOD_CONTROL			(92);
	
	private final int code;
	
	private Op(int code)
	{
		this.code=code;
	}
	public int getCode()
	{
		return this.code;
	}
}