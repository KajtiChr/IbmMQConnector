package pl.chrzanowski.springcamel.healthCheck;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.json.MetricsModule;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @Autowired
    private final MetricRegistry metricRegistry;
    private final ObjectMapper objectMapper;

    public MetricsController(MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
        this.objectMapper = new ObjectMapper().registerModule(new MetricsModule(TimeUnit.MINUTES, TimeUnit.MINUTES, true));
    }

    @GetMapping
    public String getMetrics() throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(this.metricRegistry);
    }

}
