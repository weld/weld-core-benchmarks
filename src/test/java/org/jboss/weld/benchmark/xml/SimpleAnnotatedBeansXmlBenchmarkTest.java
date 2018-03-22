package org.jboss.weld.benchmark.xml;

import static org.junit.Assert.assertEquals;

import org.jboss.weld.benchmark.core.xml.SimpleAnnotatedBeansXmlBenchmark;
import org.jboss.weld.bootstrap.spi.BeanDiscoveryMode;
import org.jboss.weld.bootstrap.spi.BeansXml;
import org.junit.Test;

public class SimpleAnnotatedBeansXmlBenchmarkTest {

    @Test
    public void testParsedBeansXml() {
        SimpleAnnotatedBeansXmlBenchmark benchmark = new SimpleAnnotatedBeansXmlBenchmark();
        benchmark.setup();
        BeansXml beansXml = benchmark.run();
        assertEquals(BeanDiscoveryMode.ANNOTATED, beansXml.getBeanDiscoveryMode());
        assertEquals("1.1", beansXml.getVersion());
        assertEquals(0, beansXml.getEnabledInterceptors().size());

    }

}
