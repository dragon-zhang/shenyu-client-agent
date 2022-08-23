package org.apache.shenyu.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author HaiLang
 * @date 2022/8/22 21:17
 */
public class ShenyuClientAgent2 {
    public static void premain(String arg, Instrumentation inst) {
        System.out.println("shenyu client agent2 loaded");
    }
}
