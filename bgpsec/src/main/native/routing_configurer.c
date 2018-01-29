#include <config.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <strings.h>
#include <net/if.h>

#include <libmnl/libmnl.h>
#include <linux/if_link.h>
#include <linux/rtnetlink.h>
#include <jni.h>

#include "include/routing_configurer.h"

JNIEXPORT void JNICALL Java_ar_strellis_com_bgpsec_routingconfig_RoutingConfigurerNml_add_1network_1via_1nml(JNIEnv *env, jobject object, jstring iface_java, jstring network_java, jstring cidr_java, jstring gateway_java)
{
	// Get parameters
	const char *iface = (*env)->GetStringUTFChars(env, iface_java, 0);
	const char *network = (*env)->GetStringUTFChars(env, network_java, 0);
	const char *cidr = (*env)->GetStringUTFChars(env, cidr_java, 0);
	const char *gateway = (*env)->GetStringUTFChars(env, gateway_java, 0);
	printf("add route %s, %s, %s, %s\n", iface, network, cidr, gateway);

	// Define structures to talk to Netlink using libmnl
	struct mnl_socket *nl;
	char buf[MNL_SOCKET_BUFFER_SIZE];
	struct nlmsghdr *nlh;
	struct rtmsg *rtm;
	uint32_t prefix, seq, portid;
	union {
		in_addr_t ip;
		struct in6_addr ip6;
	} dst;
	union {
		in_addr_t ip;
		struct in6_addr ip6;
	} gw;
	int iff, ret, family = AF_INET;
	// The interface to apply the route
	iff = if_nametoindex(iface);
	// Destination network
	inet_pton(AF_INET, network,&dst);
	// CIDR prefix
	sscanf(cidr,"%u",&prefix);
	// Gateway
	inet_pton(family,gateway,&gw);
	nlh = mnl_nlmsg_put_header(buf);
	nlh->nlmsg_type = RTM_NEWROUTE;
	nlh->nlmsg_flags = NLM_F_REQUEST | NLM_F_CREATE | NLM_F_ACK;
	nlh->nlmsg_seq = seq = time(NULL);
	rtm = mnl_nlmsg_put_extra_header(nlh, sizeof(struct rtmsg));
	rtm->rtm_family = family;
	rtm->rtm_dst_len = prefix;
	rtm->rtm_src_len = 0;
	rtm->rtm_tos = 0;
	rtm->rtm_protocol=RTPROT_STATIC;
	rtm->rtm_table=RT_TABLE_MAIN;
	rtm->rtm_type=RTN_UNICAST;
	rtm->rtm_scope=RT_SCOPE_UNIVERSE;
	rtm->rtm_flags=0;
	if(family == AF_INET)
		mnl_attr_put_u32(nlh,RTA_DST,dst.ip);
	else
		mnl_attr_put(nlh,RTA_DST,sizeof(struct in6_addr),&dst);
	mnl_attr_put_u32(nlh,RTA_OIF,iff);
	if(family == AF_INET)
		mnl_attr_put_u32(nlh,RTA_GATEWAY,gw.ip);
	else
	{
		mnl_attr_put(nlh,RTA_GATEWAY,sizeof(struct in6_addr),&gw.ip6);
	}
	nl = mnl_socket_open(NETLINK_ROUTE);
	if(nl==NULL)
	{
		// failure
		exit(EXIT_FAILURE);
	}
	if(mnl_socket_bind(nl,0,MNL_SOCKET_AUTOPID) < 0)
	{
		// failure
		exit(EXIT_FAILURE);
	}
	portid=mnl_socket_get_portid(nl);
	if(mnl_socket_sendto(nl,nlh,nlh->nlmsg_len)<0)
	{
		exit(EXIT_FAILURE);
	}
	ret=mnl_socket_recvfrom(nl,buf,sizeof(buf));
	if(ret<0)
	{
		exit(EXIT_FAILURE);
	}
	ret=mnl_cb_run(buf,ret,seq,portid,NULL,NULL);
	if(ret<0)
	{
		exit(EXIT_FAILURE);
	}
	mnl_socket_close(nl);
	// Release memory
	(*env)->ReleaseStringUTFChars(env, iface_java, iface);
	(*env)->ReleaseStringUTFChars(env, network_java, network);
	(*env)->ReleaseStringUTFChars(env, cidr_java, cidr);
	(*env)->ReleaseStringUTFChars(env, gateway_java, gateway);
	return;
}
