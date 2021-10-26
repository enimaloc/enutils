import fr.enimaloc.enutils.classes.PatternEngine;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatternEngineTest {

    @Test
    void replaceTokens() {
        String ret = assertDoesNotThrow(
                () -> PatternEngine.replaceTokens("TOKEN value is [TOKEN]", Map.of("TOKEN", "a valid token"))
        );
        assertEquals("TOKEN value is a valid token", ret);
    }

    @Test
    void unknownTokens() {
        IllegalArgumentException iae =
                assertThrows(IllegalArgumentException.class,
                             () -> PatternEngine.replaceTokens("TOKEN value is [TOKEN]", new HashMap<>()));
        assertEquals("Unknown group `[TOKEN]`", iae.getLocalizedMessage());
    }
}