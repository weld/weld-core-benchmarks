package org.jboss.weld.benchmark.core.invokableMethods;

import jakarta.enterprise.context.Dependent;

import org.openjdk.jmh.infra.Blackhole;

@Dependent
public class InvokableBean {

    public String ping(String s, Boolean b) {
        // simulate some actual form of work being done in the bean
        // the number is abstract but simulates the same amount of work for every invocation
        Blackhole.consumeCPU(200);
        return InvokableBean.class.getSimpleName();
    }
}
