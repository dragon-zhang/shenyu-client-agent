package org.apache.shenyu.jvmti;

import org.scijava.nativelib.JniExtractor;
import org.scijava.nativelib.NativeLoader;

import java.io.File;

/**
 * @author HaiLang
 * @date 2022/8/20 18:31
 */
public class JVMTI {
    
    private final static String LIB_NAME = "JniLibrary";
    
    static {
        try {
            final JniExtractor extractor = NativeLoader.getJniExtractor();
            final String path = extractor.extractJni("", LIB_NAME).getAbsolutePath();
            System.load(path);
        } catch (Throwable ignored) {
            try {
                File path = new File(JVMTI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
                String libPath = new File(path, JVMTIUtils.detectLibName()).getAbsolutePath();
                System.load(libPath);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
    
    public static <T> T getInstance(Class<T> klass) {
        final T[] instances = getInstances0(klass, 1);
        if (null == instances || instances.length == 0) {
            return null;
        }
        if (instances.length > 1) {
            throw new RuntimeException("expect find only one instance, but actually find many instances !");
        }
        return instances[0];
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
