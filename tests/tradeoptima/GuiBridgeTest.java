package tradeoptima;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class GuiBridgeTest {
    @Test void bridgeReportsTheActualOptimizerLedger() {
        String json = GuiBridge.history("Date,Close\n2024-01-01,10\n2024-01-02,12\n2024-01-03,11\n2024-01-04,14", "Close", 1, 50, 0);
        assertTrue(json.contains("\"profit\":350"));
        assertTrue(json.contains("\"buyDate\":\"2024-01-01\""));
        assertTrue(json.contains("\"sellDate\":\"2024-01-04\""));
        assertTrue(json.contains("\"legal\":true"));
        assertFalse(json.contains("\"risk\":null"));
    }
    @Test void shortHistoryDoesNotInventRisk() {
        String json = GuiBridge.history("Date,Close\n2024-01-01,10", "Close", 1, 50, 1);
        assertTrue(json.contains("\"trades\":[]"));
        assertTrue(json.contains("\"risk\":null"));
    }
    @Test void invalidSettingsFailBeforeRunning() {
        assertThrows(IllegalArgumentException.class, () -> GuiBridge.history("Date,Close\n2024-01-01,10", "Close", -1, 50, 1));
    }
    @Test void textIsEscapedForStructuredOutput() {
        StringBuilder b = new StringBuilder();
        GuiBridge.quote(b, "A\"B\\C\n");
        assertEquals("\"A\\\"B\\\\C\\u000a\"", b.toString());
    }
}
