package org.jboss.weld.benchmark.core.complex;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import org.jboss.weld.benchmark.core.BeanUnderTest;
import org.jboss.weld.benchmark.core.DummyEvent;

@RequestScoped
public class RequestScopedBean implements BeanUnderTest {

    @Inject
    Event<DummyEvent> event;

    @Override
    public boolean getResult() {
        event.fire(new DummyEvent(false));
        return true;
    }
}
