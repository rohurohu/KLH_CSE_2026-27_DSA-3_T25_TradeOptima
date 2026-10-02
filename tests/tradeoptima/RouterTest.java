package tradeoptima;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class RouterTest {
    @Test void randomizedReferenceChecks() { assertTrue(SelfTest.runModule("router")); }
    @Test void restrictionsAndResidualRerouting() { IntegrationTest.routingEdges(); }
}
