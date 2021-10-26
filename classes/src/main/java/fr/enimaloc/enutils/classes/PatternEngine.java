package fr.enimaloc.enutils.classes;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternEngine {

    /*
        String message = "Hello [USERNAME], how are you?" (this is part of a config)
        Map<String, String> tokens = Map.of("[USERNAME]", player.getName());
        player.sendMessage(replaceTokens(message, tokens));
     */
    public static final Pattern                           DEFAULT_PATTERN       = Pattern.compile("\\[(.+?)\\]");
    public static final BiConsumer<String, StringBuilder> DEFAULT_UNKNOWN_TOKEN =
            (token, builder) -> {throw new IllegalArgumentException(String.format("Unknown group `%s`", token));};

    /**
     * Default token pattern is: [Token]
     *
     * @param text   the text in which you want to replace the tokens
     * @param tokens A map where the key is the token you want replaced and the value is what to replace it with
     * @return a modified string where all the specified tokens in the string have been replaced
     */
    public static String replaceTokens(String text, Map<String, String> tokens) {
        return replaceTokens(DEFAULT_PATTERN, DEFAULT_UNKNOWN_TOKEN, text, tokens);
    }

    public static String replaceTokens(Pattern tokenMatcher, String text, Map<String, String> tokens) {
        return replaceTokens(tokenMatcher, DEFAULT_UNKNOWN_TOKEN, text, tokens);
    }

    public static String replaceTokens(
            BiConsumer<String, StringBuilder> unknownToken,
            String text,
            Map<String, String> tokens
    ) {
        return replaceTokens(DEFAULT_PATTERN, unknownToken, text, tokens);
    }

    public static String replaceTokens(
            Pattern tokenMatcher,
            BiConsumer<String, StringBuilder> unknownToken,
            String text,
            Map<String, String> tokens
    ) {
        Matcher       matcher = tokenMatcher.matcher(text);
        StringBuilder builder = new StringBuilder();
        int           i       = 0;
        while (matcher.find()) {
            String replacement = tokens.get(matcher.group(1));
            builder.append(text, i, matcher.start());
            if (replacement == null) {
                unknownToken.accept(matcher.group(0), builder);
            } else {
                builder.append(replacement);
            }
            i = matcher.end();
        }
        builder.append(text.substring(i));
        return builder.toString();
    }
}
