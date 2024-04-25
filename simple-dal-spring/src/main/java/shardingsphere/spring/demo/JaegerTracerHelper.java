package shardingsphere.spring.demo;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.metrics.Metrics;
import io.jaegertracing.internal.metrics.NoopMetricsFactory;
import io.jaegertracing.internal.reporters.LoggingReporter;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.jaegertracing.spi.Reporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaegerTracerHelper {

    private static final Logger logger = LoggerFactory.getLogger(JaegerTracerHelper.class);

    public static JaegerTracer initTracer(String service) {
        final Reporter reporter = new LoggingReporter(logger);
        final Metrics metrics = new Metrics(new NoopMetricsFactory());
        JaegerTracer.Builder builder = new JaegerTracer.Builder(service)
                .withReporter(reporter)
                .withMetrics(metrics)
                .withExpandExceptionLogs()
                .withSampler(new ConstSampler(true));
        return builder.build();
    }
}
