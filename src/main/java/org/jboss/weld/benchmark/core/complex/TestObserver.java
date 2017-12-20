package org.jboss.weld.benchmark.core.complex;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

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
