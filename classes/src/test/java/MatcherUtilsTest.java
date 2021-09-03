import fr.enimaloc.enutils.classes.MatcherUtils;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class MatcherUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "group", "Group", "pattern", "regex", "match"
    })
    void getGroup(String input) {
        Matcher matcher = Pattern.compile("(?<input>.*)").matcher(input);
        assumeTrue(matcher.find());
        Optional<String> opt = MatcherUtils.getGroup(matcher, "input");
        assertTrue(opt.isPresent());
        assertEquals(input, opt.get());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "group", "Group", "pattern", "regex", "match"
    })
    void getEmptyGroup(String input) {
        Matcher matcher = Pattern.compile("(?<digit>\\d)?.*").matcher(input);
        assumeTrue(matcher.find());
        Optional<String> opt = MatcherUtils.getGroup(matcher, "digit");
        assertTrue(opt.isEmpty());
    }
}
