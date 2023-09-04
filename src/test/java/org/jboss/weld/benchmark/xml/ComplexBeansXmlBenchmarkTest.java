package org.jboss.weld.benchmark.xml;

import static org.junit.Assert.assertEquals;

import org.jboss.weld.benchmark.core.xml.ComplexBeansXmlBenchmark;
import org.jboss.weld.bootstrap.spi.BeanDiscoveryMode;
import org.jboss.weld.bootstrap.spi.BeansXml;
import org.junit.Test;

public class ComplexBeansXmlBenchmarkTest {

    @Test
    public void testParsedBeansXml() {
        ComplexBeansXmlBenchmark benchmark = new ComplexBeansXmlBenchmark();
        benchmark.setup();
        BeansXml beansXml = benchmark.run();
        assertEquals(BeanDiscoveryMode.ALL, beansXml.getBeanDiscoveryMode());
        assertEquals("4.0", beansXml.getVersion());
        assertEquals(1, beansXml.getEnabledInterceptors().size());
        assertEquals(1, beansXml.getEnabledDecorators().size());
        assertEquals(1, beansXml.getEnabledAlternativeClasses().size());
        assertEquals(1, beansXml.getEnabledAlternativeStereotypes().size());
    }

}
