AC_INIT([libroute_configurer], [0.1.0], [agusvillafane@yahoo.com.ar])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
AC_CONFIG_MACRO_DIR([m4])
AM_PROG_AR
AC_PROG_CC
AC_CONFIG_HEADERS([config.h])
LT_INIT([dlopen shared])
AC_CONFIG_FILES([
 Makefile
])
OS_NAME=""
os_arch=`uname`
if test "$os_arch" = "Linux"; then
	OS_NAME="linux"
fi
dnl Check for JNI headers
JNI_CPPFLAGS=""
if test $JAVA_HOME != ""
then
  for dir in `find $JAVA_HOME/include -follow -type d`
  do
    JNI_CPPFLAGS="$JNI_CPPFLAGS -I$dir"
  done
fi
cppflags_bak=$CPPFLAGS
CPPFLAGS="$CPPFLAGS $JNI_CPPFLAGS"
AC_CHECK_HEADERS([jni.h], [], AC_MSG_ERROR([Native java headers not found. Is \$JAVA_HOME set correctly?]))
CPPFLAGS=$cppflags_bak
AC_SUBST([JNI_CPPFLAGS])
AC_CHECK_HEADERS([arpa/inet.h netinet/in.h stdlib.h strings.h unistd.h net/if.h libmnl/libmnl.h $OS_NAME/if_link.h $OS_NAME/rtnetlink.h])
PKG_CHECK_MODULES(MNL,libmnl)
AC_OUTPUT
