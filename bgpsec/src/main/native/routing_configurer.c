#include <config.h>
#include <stdio.h>
#include <jni.h>

#include "include/routing_configurer.h"

JNIEXPORT void JNICALL Java_MyJNIClass_printf(JNIEnv * env, jobject objc, jstring javaString)
{
	// Obtenemos la cadena de caracteres
	const char *nativeString = (*env)->GetStringUTFChars(env, javaString, 0);
	printf("%s", nativeString);
	// Liberamos la memoria
	(*env)->ReleaseStringUTFChars(env, javaString, nativeString);
}
