package org.apache.shenyu.agent;

import org.apache.shenyu.jvmti.JVMTI;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.instrument.Instrumentation;

/**
 * @author HaiLang
 * @date 2022/8/22 21:17
 */
public class ShenyuClientAgent2 {
    public static void premain(String arg, Instrumentation inst) {
        System.out.println("shenyu client agent2 loaded");
        new Thread(() -> {
            ConfigurableApplicationContext context = JVMTI.getInstance(ConfigurableApplicationContext.class);
            while (null == context) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
                context = JVMTI.getInstance(ConfigurableApplicationContext.class);
            }
            while (!context.isActive()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("finally available context " + context);
            //todo 在这里实现组装逻辑
        }).start();
    }
}
