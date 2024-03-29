/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.benchmark.core.event;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Event;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import org.jboss.weld.benchmark.core.BaseBenchmark;
import org.jboss.weld.benchmark.core.DummyEvent;
import org.jboss.weld.benchmark.core.DummyQualifier;
import org.jboss.weld.benchmark.core.event.SimpleStaticObserverBenchmark.Dispatcher;

/**
 * @author Kirill Gaevskii
 */
public class SimpleStaticObserverBenchmark extends BaseBenchmark<Dispatcher> {

    private static final String MARKER = "simpleStatic";

    @Override
    protected Class<Dispatcher> getBeanClass() {
        return Dispatcher.class;
    }

    @Dependent
    public static class Dispatcher extends AbstractDispatcher {

        @Inject
        public Dispatcher(@DummyQualifier(MARKER) Event<DummyEvent> event) {
            super(event);
        }
    }

    @Dependent
    public static class Receiver {

        public static void dummyEventListener(@Observes @DummyQualifier(MARKER) DummyEvent dummyEvent) {
            if (!dummyEvent.value()) {
                throw new IllegalStateException();
            }
        }
    }
}
