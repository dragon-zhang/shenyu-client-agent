package org.apache.shenyu.client;

import org.springframework.context.ApplicationContext;

/**
 * @author HaiLang
 * @date 2022/8/22 21:15
 */
public class ApplicationContextHelper {
    
    private static ApplicationContext context;
    
    public static ApplicationContext getContext() {
        return context;
    }
    
    public static void setContext(ApplicationContext context) {
        ApplicationContextHelper.context = context;
    }
}
