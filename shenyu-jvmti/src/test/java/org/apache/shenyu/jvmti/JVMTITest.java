package org.apache.shenyu.jvmti;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author HaiLang
 * @date 2022/8/20 18:51
 */
public class JVMTITest {
    
    private static class TestClass {
    }
    
    @Test
    public void testGetInstances() {
        TestClass[] instances = JVMTI.getInstances(TestClass.class);
        Assert.assertNotNull(instances);
        Assert.assertEquals(0, instances.length);
        new TestClass();
        instances = JVMTI.getInstances(TestClass.class);
        Assert.assertNotNull(instances);
        Assert.assertEquals(1, instances.length);
    }
}
