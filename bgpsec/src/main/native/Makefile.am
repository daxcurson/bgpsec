AM_CFLAGS=@JNI_CPPFLAGS@ -g -Wall -O2 -fPIC -I$(JAVA_HOME)/include $(MNL_CFLAGS)
lib_LTLIBRARIES=librouting_configurer.la
librouting_configurer_la_SOURCES=base_functions.c routing_configurer.c
librouting_configurer_la_LDFLAGS=-shared $(MNL_LIBS)
