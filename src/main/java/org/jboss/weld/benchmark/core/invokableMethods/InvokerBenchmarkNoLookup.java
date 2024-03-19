package org.jboss.weld.benchmark.core.invokableMethods;

/**
 * Simplest invoker - no lookups.
 * Repeated invocations are given the same bean instance and the same array of arguments.
 */
public class InvokerBenchmarkNoLookup extends InvokerBenchmarkBase {

    @Override
    protected String performInvoke() throws Exception {
        return invoker.invoke(bean, dummyMethodArgs);
    }
}
