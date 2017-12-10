CC=gcc
CFLAGS=-Wall -O3

INCLUDES=-I/usr/include -I/usr/include/linux
LFLAGS=-shared -fPIC

all: routing_configurer

routing_configurer.so: routing_configurer.c
	$(CC) $(CFLAGS)  $(INCLUDES) `pkg-config --cflags --libs libnl-3.0` $(LFLAGS) \
	 -o librouting_configurer.so -Wl,-whole-archive libnetlink.a -Wl,-no-whole-archive routing_configurer.c

routing_configurer: routing_configurer.so