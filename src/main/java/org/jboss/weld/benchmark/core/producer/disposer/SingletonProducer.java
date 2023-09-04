/*
 * JBoss, Home of Professional Open Source
 * Copyright 2015, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
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
package org.jboss.weld.benchmark.core.producer.disposer;

import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import org.jboss.weld.benchmark.core.DummyQualifier;
import org.jboss.weld.benchmark.core.DummyStereotype;

/**
 * @author Kirill Gaevskii
 */
@DummyStereotype // @Singleton is not a bean defining annotation
@Singleton
public class SingletonProducer {

    @Produces
    @DummyQualifier("SingletonProducer")
    public SimpleBean getBean() {
        return new SimpleBean();
    }

    public void disposer(@DummyQualifier("SingletonProducer") @Disposes SimpleBean bean) {
        if (!bean.doSomeStuffForDestruction()) {
            throw new IllegalStateException();
        }
    }

}
