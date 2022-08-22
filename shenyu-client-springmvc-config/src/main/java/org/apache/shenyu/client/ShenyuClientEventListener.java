package org.apache.shenyu.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
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
        final ApplicationContext context = event.getApplicationContext();
        ApplicationContextHelper.setContext(context);
    }
}
