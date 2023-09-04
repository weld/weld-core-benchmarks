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
package org.jboss.weld.benchmark.core.construction;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import org.jboss.weld.benchmark.core.BaseBenchmark;
import org.jboss.weld.benchmark.core.BeanUnderTest;
import org.jboss.weld.benchmark.core.construction.SimpleConstructionBenchmark.Injecting;

/**
 * Simple benchmarks that uses {@link Instance} to perform instantiation and destruction of an elementary managed bean.
 *
 * @author Jozef Hartinger
 *
 */
public class SimpleConstructionBenchmark extends BaseBenchmark<Injecting> {

    @Override
    protected Class<Injecting> getBeanClass() {
        return Injecting.class;
    }

    @Dependent
    public static class Injecting implements BeanUnderTest {

        @Inject
        private Instance<Injected> instance;

        @Override
        public boolean getResult() {
            Injected object = instance.get();
            instance.destroy(object);
            return true;
        }
    }

    @Dependent
    public static class Injected {
    }

}
