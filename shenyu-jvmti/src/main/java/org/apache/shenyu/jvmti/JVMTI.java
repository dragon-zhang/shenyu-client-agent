package org.apache.shenyu.jvmti;

import org.scijava.nativelib.NativeLoader;

import java.io.IOException;

/**
 * @author HaiLang
 * @date 2022/8/20 18:31
 */
public class JVMTI {
    
    private final static String LIB_NAME = "JniLibrary";
    
    static {
        try {
            NativeLoader.loadLibrary(LIB_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static <T> T[] getInstances(Class<T> klass) {
        return getInstances0(klass, -1);
    }
    
    public static <T> T[] getInstances(Class<T> klass, int limit) {
        if (limit <= 0) {
            throw new IllegalArgumentException("limit cannot be less than or equal to 0");
        }
        return getInstances0(klass, limit);
    }
    
    /**
     * Get all current surviving instances of a class in the jvm
     */
    private static synchronized native <T> T[] getInstances0(Class<T> klass, int limit);
}
