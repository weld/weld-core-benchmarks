package org.jboss.weld.benchmark.core.invokableMethods;

import jakarta.enterprise.inject.Instance;
import jakarta.enterprise.inject.spi.CDI;

public class InvokableMethodManualLookupBeanInvocation extends InvokableMethodBenchmarkBase {
    @Override
    protected String performInvoke() {
        // WIP - naive assumption is that this should be just about the same performance as InvokableMethodBenchmarkLookup
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
