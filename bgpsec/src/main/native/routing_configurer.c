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

#include "includes/routing_configurer.h"

JNIEXPORT void JNICALL Java_MyJNIClass_printf(JNIEnv * env, jobject objc, jstring javaString)
{
	// Obtenemos la cadena de caracteres
	const char *nativeString = (*env)->GetStringUTFChars(env, javaString, 0);
	printf("%s", nativeString);
	// Liberamos la memoria
	(*env)->ReleaseStringUTFChars(env, javaString, nativeString);
}
