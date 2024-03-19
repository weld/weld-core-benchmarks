package org.jboss.weld.benchmark.core.invokableMethods;

import java.util.Collection;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AnnotatedMethod;
import jakarta.enterprise.inject.spi.Extension;
import jakarta.enterprise.inject.spi.ProcessManagedBean;
import jakarta.enterprise.invoke.Invoker;

public class PortableExtension implements Extension {

    private Invoker<InvokableBean, ?> invoker;
    private Invoker<InvokableBean, ?> lookupAllInvoker;

    public void observe(@Observes ProcessManagedBean<InvokableBean> pmb) {
        Collection<AnnotatedMethod<? super InvokableBean>> invokableMethods = pmb.getAnnotatedBeanClass().getMethods();
        if (invokableMethods.size() != 1) {
            throw new IllegalStateException("InvokableBean should have only one method annotated @Invokable");
        }
        invoker = pmb.createInvoker(invokableMethods.iterator().next()).build();
        lookupAllInvoker = pmb.createInvoker(invokableMethods.iterator().next()).withInstanceLookup().withArgumentLookup(0)
                .withArgumentLookup(1).build();
    }

    public Invoker<InvokableBean, ?> getInvoker() {
        return invoker;
    }

    public Invoker<InvokableBean, ?> getLookupAllInvokerInvoker() {
        return lookupAllInvoker;
    }
}
