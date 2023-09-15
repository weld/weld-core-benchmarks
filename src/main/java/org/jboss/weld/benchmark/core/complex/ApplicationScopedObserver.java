package org.jboss.weld.benchmark.core.complex;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import org.jboss.weld.benchmark.core.DummyEvent;
import org.jboss.weld.benchmark.core.DummyQualifier;

@ApplicationScoped
public class ApplicationScopedObserver {

    public void observesDependentScopedProduced(@Observes DummyEvent event,
            @DummyQualifier("test") DependentBean dependentBean) {
        dependentBean.ping();
    }
}
