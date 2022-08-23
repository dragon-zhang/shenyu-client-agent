package org.apache.shenyu.client;

import org.apache.shenyu.register.client.http.utils.OkHttpTools;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * ShenyuClientEventListener可以用agent静态增强AbstractApplicationContext，从而注册
 *
 * @author HaiLang
 * @date 2022/8/22 21:06
 */
public class ShenyuClientEventListener implements ApplicationListener<ContextRefreshedEvent> {
    
    private final AtomicBoolean registered = new AtomicBoolean(false);
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (!registered.compareAndSet(false, true)) {
            return;
        }
        try {
            final String response = OkHttpTools.getInstance().post("http://localhost:8081/register", getPid());
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getPid() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        return name.split("@")[0];
    }
}
