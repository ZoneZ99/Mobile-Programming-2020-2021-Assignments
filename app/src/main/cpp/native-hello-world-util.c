#include <string.h>
#include <jni.h>

JNIEXPORT jstring JNICALL
Java_id_ac_ui_cs_mobileprogramming_assignments_MainActivity_nativeHelloWorld(
    JNIEnv* env,
    jobject thiz,
    jstring input
) {
    const char *nativeInput = (*env)->GetStringUTFChars(env, input, 0);
    (*env)->ReleaseStringUTFChars(env, input, nativeInput);

    char output[256];
    strcpy(output, "Hello, ");
    strcat(output, nativeInput);
    strcat(output, "!");

    return (*env)->NewStringUTF(env, output);
}