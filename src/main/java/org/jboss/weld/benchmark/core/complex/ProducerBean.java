package org.jboss.weld.benchmark.core.complex;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import org.jboss.weld.benchmark.core.DummyQualifier;
import org.jboss.weld.benchmark.core.SimpleDependentBean;

@Dependent
public class ProducerBean {

    @Produces
    @DummyQualifier("test")
    public DependentBean produceDependentBean(SimpleDependentBean simpleDependentBean) {
        return new DependentBean(simpleDependentBean);
    }

    public void dispose(@Disposes @DummyQualifier("test") DependentBean dependentBean) {
    }
}
