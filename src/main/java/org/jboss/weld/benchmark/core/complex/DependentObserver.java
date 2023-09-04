package org.jboss.weld.benchmark.core.complex;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Observes;

import org.jboss.weld.benchmark.core.DummyEvent;

@Dependent
public class DependentObserver {

    public void observesDependent(@Observes DummyEvent event, DependentBean dependentBean) {
        dependentBean.ping();
    }

}
