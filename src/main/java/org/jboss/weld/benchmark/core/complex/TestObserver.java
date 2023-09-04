package org.jboss.weld.benchmark.core.complex;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Observes;

import org.jboss.weld.benchmark.core.DummyEvent;

@Dependent
public class TestObserver {

    public static class StaticObserver {
        public static void observesApplicationScoped(@Observes DummyEvent event, ApplicationScopedBean applicationScopedBean) {
            // calls DummyInterceptor
            applicationScopedBean.ping();
        }
    }

}
