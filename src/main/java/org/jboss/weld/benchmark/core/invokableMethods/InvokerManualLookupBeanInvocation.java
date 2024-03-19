package org.jboss.weld.benchmark.core.invokableMethods;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.CDI;

/**
 * Very similar to {@link InvokerBenchmarkLookup} test.
 * Invoker is used to invoke bean method but all lookups are made manually.
 * This simplifies the invocation logic of the invoker itself, therefore it is expected that this test will have better
 * performance than {@link InvokerBenchmarkLookup} but it shouldn't be dramatic.
 */
public class InvokerManualLookupBeanInvocation extends InvokerBenchmarkBase {
    @Override
    protected String performInvoke() throws Exception {
        Instance<Object> lookup = CDI.current().getBeanContainer().createInstance();
        InvokableBean bean = null;
        String string = null;
        Boolean bool = null;
        try {
            bean = lookup.select(InvokableBean.class).get();
            string = lookup.select(String.class).get();
            bool = lookup.select(Boolean.class).get();
            return invoker.invoke(bean, new Object[] { string, bool });
        } finally {
            lookup.destroy(bean);
            lookup.destroy(string);
            lookup.destroy(bool);
        }
    }
}
