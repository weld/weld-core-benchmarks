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
import org.jboss.weld.benchmark.core.SimpleDependentBean;
import org.jboss.weld.benchmark.core.SimpleDependentBean2;
import org.jboss.weld.benchmark.core.construction.SimpleBeanWithInjectedInitializerMethodBenchmark.InjectingBeanWithInitializer;

/**
 * @author Kirill Gaevskii
 */
public class SimpleBeanWithInjectedInitializerMethodBenchmark extends BaseBenchmark<InjectingBeanWithInitializer> {

    @Override
    protected Class<InjectingBeanWithInitializer> getBeanClass() {
        return InjectingBeanWithInitializer.class;
    }

    @Dependent
    public static class InjectingBeanWithInitializer implements BeanUnderTest {

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

        SimpleDependentBean first;
        SimpleDependentBean2 second;

        @Inject
        public void initializer(SimpleDependentBean first, SimpleDependentBean2 second) {
            this.first = first;
            this.second = second;
        }
    }
}
