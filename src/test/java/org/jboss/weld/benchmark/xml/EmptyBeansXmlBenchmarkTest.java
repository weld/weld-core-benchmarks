package org.jboss.weld.benchmark.xml;

import static org.junit.Assert.assertEquals;

import org.jboss.weld.benchmark.core.xml.EmptyBeansXmlBenchmark;
import org.jboss.weld.bootstrap.spi.BeansXml;
import org.junit.Test;

public class EmptyBeansXmlBenchmarkTest {

    @Test
    public void testParsedBeansXml() {
        EmptyBeansXmlBenchmark benchmark = new EmptyBeansXmlBenchmark();
        benchmark.setup();
        assertEquals(BeansXml.EMPTY_BEANS_XML, benchmark.run());
    }

}
