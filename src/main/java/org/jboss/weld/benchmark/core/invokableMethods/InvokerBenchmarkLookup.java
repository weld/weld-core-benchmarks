package org.jboss.weld.benchmark.core.invokableMethods;

/**
 * Invoker with lookup on all its parts - the bean instance as well as method arguments
 */
public class InvokerBenchmarkLookup extends InvokerBenchmarkBase {

    @Override
    protected String performInvoke() throws Exception {
        return lookupAllInvoker.invoke(bean, dummyMethodArgs);
    }
}
