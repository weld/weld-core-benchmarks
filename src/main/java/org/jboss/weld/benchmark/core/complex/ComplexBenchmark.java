package org.jboss.weld.benchmark.core.complex;

import static org.jboss.weld.benchmark.core.Configuration.BATCH_SIZE_SLOW;
import static org.jboss.weld.benchmark.core.Configuration.ITERATIONS;

import org.jboss.weld.benchmark.core.BaseBenchmark;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

// Use smaller batch size for complex benchmark
@Warmup(batchSize = BATCH_SIZE_SLOW, iterations = ITERATIONS)
@Measurement(batchSize = BATCH_SIZE_SLOW, iterations = ITERATIONS)
public class ComplexBenchmark extends BaseBenchmark<RequestScopedBean>{

    @Override
    protected Class<RequestScopedBean> getBeanClass() {
        return RequestScopedBean.class;
    }
}
