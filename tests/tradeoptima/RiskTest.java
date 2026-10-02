package tradeoptima;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class RiskTest {
    @Test void logReturnDriftAndInvalidInputs() { IntegrationTest.riskEdges(); }
    @Test void randomizedReferenceChecks() { assertTrue(SelfTest.runModule("risk")); }

}
