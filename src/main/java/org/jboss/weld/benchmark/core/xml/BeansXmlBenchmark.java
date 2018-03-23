/*
 * JBoss, Home of Professional Open Source
 * Copyright 2018, Red Hat, Inc., and individual contributors
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
package org.jboss.weld.benchmark.core.xml;

import static org.jboss.weld.benchmark.core.Configuration.FORKS;
import static org.openjdk.jmh.annotations.Mode.SingleShotTime;
import static org.openjdk.jmh.annotations.Threads.MAX;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.jboss.weld.bootstrap.WeldBootstrap;
import org.jboss.weld.bootstrap.spi.BeansXml;
import org.jboss.weld.config.SystemPropertiesConfiguration;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;

/**
 * @author Martin Kouba
 */
@Fork(FORKS)
@Threads(MAX)
@BenchmarkMode(SingleShotTime)
@Warmup(iterations = 10)
@Measurement(iterations = 10)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public abstract class BeansXmlBenchmark {

    private WeldBootstrap bootstrap;

    private URL beansXml;

    @Benchmark
    public BeansXml run() {
        return bootstrap.parse(beansXml);
    }

    protected abstract String getBeansXmlName();

    @Setup
    public void setup() {
        bootstrap = new WeldBootstrap();
        beansXml = BeansXmlBenchmark.class.getResource(getBeansXmlName());
        if (SystemPropertiesConfiguration.INSTANCE.isXmlValidationDisabled()) {
            System.out.println("INFO: XML validation disabled!");
        }
    }

}
