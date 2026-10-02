package tradeoptima;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class OptimizerTest {
    @Test void randomizedReferenceChecks() { assertTrue(SelfTest.runModule("optimizer")); }
    @Test void boundariesAndFewestTrades() { IntegrationTest.optimizerEdges(); }
}
