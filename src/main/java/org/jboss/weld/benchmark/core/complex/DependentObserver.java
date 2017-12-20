package org.jboss.weld.benchmark.core.complex;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

import org.jboss.weld.benchmark.core.DummyEvent;

@Dependent
public class DependentObserver {

    public void observesDependent(@Observes DummyEvent event, DependentBean dependentBean) {
        dependentBean.ping();
    }

}
