package tradeoptima;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

final class SearchTest {
    @Test void randomizedReferenceChecks() { assertTrue(SelfTest.runModule("strings")); }
    @Test void wholeWordsAndFuzzy() {
        SearchEngine search = new SearchEngine(new String[] {"AAPL"}, new String[] {"Apple"});
        assertEquals(2, search.mentions("Apple AAPL pineapple AAPL2")[0]);
        assertEquals(1, search.fuzzy("appl", 1).length);
    }
}
