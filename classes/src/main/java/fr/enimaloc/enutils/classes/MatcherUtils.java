package fr.enimaloc.enutils.classes;

import java.util.Optional;
import java.util.regex.Matcher;

import static fr.enimaloc.enutils.classes.ObjectUtils.getOr;

public class MatcherUtils {

    /**
     * Safely get a group
     *
     * @param matcher Matcher where getting group
     * @param groupName Group name to get
     * @return an {@link Optional Optional<}{@link String}{@link Optional >}, if empty
     */
    public static Optional<String> getGroup(Matcher matcher, String groupName) {
        return Optional.ofNullable(getOr(() -> matcher.group(groupName), null));
    }
}
