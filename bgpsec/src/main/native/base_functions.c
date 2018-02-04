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

int data_attr_cb(const struct nlattr *attr, void *data)
{
	const struct nlattr **tb = data;
	int type = mnl_attr_get_type(attr);

	/* skip unsupported attribute in user-space */
	if (mnl_attr_type_valid(attr, IFLA_MAX) < 0)
		return MNL_CB_OK;

	switch(type) {
	case IFLA_ADDRESS:
		if (mnl_attr_validate(attr, MNL_TYPE_BINARY) < 0) {
			perror("mnl_attr_validate");
			return MNL_CB_ERROR;
		}
		break;
	case IFLA_MTU:
		if (mnl_attr_validate(attr, MNL_TYPE_U32) < 0) {
			perror("mnl_attr_validate");
			return MNL_CB_ERROR;
		}
		break;
	case IFLA_IFNAME:
		if (mnl_attr_validate(attr, MNL_TYPE_STRING) < 0) {
			perror("mnl_attr_validate");
			return MNL_CB_ERROR;
		}
		break;
	}
	tb[type] = attr;
	return MNL_CB_OK;
}

int data_cb(const struct nlmsghdr *nlh, void *data)
{
	struct nlattr *tb[IFLA_MAX+1] = {};
	struct ifinfomsg *ifm = mnl_nlmsg_get_payload(nlh);

	printf("index=%d type=%d flags=%d family=%d ",
		ifm->ifi_index, ifm->ifi_type,
		ifm->ifi_flags, ifm->ifi_family);

	if (ifm->ifi_flags & IFF_RUNNING)
		printf("[RUNNING] ");
	else
		printf("[NOT RUNNING] ");

	mnl_attr_parse(nlh, sizeof(*ifm), data_attr_cb, tb);
	if (tb[IFLA_MTU]) {
		printf("mtu=%d ", mnl_attr_get_u32(tb[IFLA_MTU]));
	}
	if (tb[IFLA_IFNAME]) {
		printf("name=%s ", mnl_attr_get_str(tb[IFLA_IFNAME]));
	}
	if (tb[IFLA_ADDRESS]) {
		uint8_t *hwaddr = mnl_attr_get_payload(tb[IFLA_ADDRESS]);
		int i;

		printf("hwaddr=");
		int address_length=mnl_attr_get_payload_len(tb[IFLA_ADDRESS]);
		char hwaddr_string[30];
		char hwaddr_part[address_length][6];
		for (i=0; i<address_length; i++)
		{
			sprintf(hwaddr_part[i],"%.2x", hwaddr[i] & 0xff);
			printf("%.2x", hwaddr[i] & 0xff);
			if (i+1 != address_length)
			{
				hwaddr_part[3][2]=":";
				printf(":");
			}
		}
	}
	printf("\n");
	return MNL_CB_OK;
}
