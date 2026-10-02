package tradeoptima;

import org.junit.jupiter.api.Test;

final class DataReplayTest {
    @Test void csvAndDates() { IntegrationTest.csv(); }
    @Test void replayHasNoFutureLeakage() { IntegrationTest.replay(); }
}
