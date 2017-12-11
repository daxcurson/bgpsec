#include <config.h>
#include <stdio.h>
#include <jni.h>

#include "include/routing_configurer.h"

JNIEXPORT void JNICALL Java_ar_strellis_com_bgpsec_routingconfig_RoutingConfigurer_add_1network_1via_1nml(JNIEnv * env, jobject objc, jstring javaString)
{
	// Obtenemos la cadena de caracteres
	const char *nativeString = (*env)->GetStringUTFChars(env, javaString, 0);
	printf("%s", nativeString);
	// Liberamos la memoria
	(*env)->ReleaseStringUTFChars(env, javaString, nativeString);
}
