package tradeoptima;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Tag("performance")
final class PerformanceTest {
    @Test void slideTargetUnderTwoSeconds() { assertTrue(Benchmark.run() < 2000, "Slide target exceeded on this machine"); }
}
