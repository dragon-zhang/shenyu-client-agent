package org.apache.shenyu.agent;

import org.apache.shenyu.client.ApplicationContextHelper;
import org.apache.shenyu.jvmti.JVMTI;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.instrument.Instrumentation;

/**
 * @author HaiLang
 * @date 2022/8/20 19:10
 */
public class ShenyuClientAgent {
    public static void premain(String arg, Instrumentation inst) {
        System.out.println("shenyu client agent loaded");
        //这里新启动一个线程是为了不阻塞主线程，可以考虑动态attach
        new Thread(() -> {
            ConfigurableApplicationContext context = (ConfigurableApplicationContext) ApplicationContextHelper.getContext();
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
