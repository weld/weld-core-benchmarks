package org.jboss.weld.benchmark.core.invokableMethods;

/**
 * Simple and direct bean invocation - servers as a measure of how fast direct invocations are compared to invokers.
 */
public class InvokerBenchmarkSimpleBeanInvocation extends InvokerBenchmarkBase {
    @Override
    protected String performInvoke() {
        return bean.ping(dummyStringArg, Boolean.TRUE);
    }
}
