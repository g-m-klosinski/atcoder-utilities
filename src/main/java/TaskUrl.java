import java.util.Optional;
import java.util.regex.Pattern;

public class TaskUrl {
    /**
     * Insert three `String` arguments to form a task URL:
     * https://atcoder.jp/contests/$1$2/tasks/$1$2_$3
     * @param coordinates A triple name-number-letter, e.g.
     *                    ["arc", "5", "b"]
     * @return The URL of the task
     */
    public static String makeTaskUrl(String[] coordinates) {
        return "";
    }

    public static Optional<String> checkTaskValidity(String[] coordinates) {
        final var USAGE_INSTRUCTION = """
              Usage: atcoder-utilities <contest type abbreviation> <number> <task letter>
              
              For example: atcoder-utilities abc 150 g""";

        if (coordinates.length != 3)
            return Optional.of(USAGE_INSTRUCTION);

        var typePattern = Pattern.compile("a[brg]c", Pattern.CASE_INSENSITIVE);
        var typeMatcher = typePattern.matcher(coordinates[0]);

        if (!typeMatcher.matches()) {
            return Optional.of("""
              Invalid argument for "contest type abbreviation".
              Must be one of: "abc", "arc", "agc" (case-insensitive).
              
              """ + USAGE_INSTRUCTION);
        }

        var numberPattern = Pattern.compile("[1-9]\\d*");
        var numberMatcher = numberPattern.matcher(coordinates[1]);

        if (!numberMatcher.matches()) {
            return Optional.of("""
              Invalid argument for "number". Must be an integer.
              
              """ + USAGE_INSTRUCTION);
        }

        var letterPattern = Pattern.compile("[a-zA-Z]");
        var letterMatcher = letterPattern.matcher(coordinates[2]);

        if (!letterMatcher.matches()) {
            return Optional.of("""
              Invalid argument for "task letter". Must be a single letter.
              
              """ + USAGE_INSTRUCTION);
        }

        return Optional.empty();
    }
}
