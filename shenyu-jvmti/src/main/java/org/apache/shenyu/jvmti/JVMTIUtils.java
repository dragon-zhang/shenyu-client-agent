package org.apache.shenyu.jvmti;

/**
 * @author HaiLang
 * @date 2022-08-21
 */
public class JVMTIUtils {
    private static String libName = null;
    
    static {
        if (OSUtils.isMac()) {
            libName = "libJniLibrary.dylib";
        }
        if (OSUtils.isLinux()) {
            libName = "libJniLibrary.so";
        }
        if (OSUtils.isWindows()) {
            libName = "libJniLibrary.dll";
        }
    }
    
    public static String detectLibName() {
        return libName;
    }
}
