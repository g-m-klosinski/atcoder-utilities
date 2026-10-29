import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void checkTaskValidityAlertsOnZeroArguments() {
        var coordinates = new String[] {};

        Optional<String> errorMessage = App.checkTaskValidity(coordinates);

        assertTrue(errorMessage.isPresent());
        assertTrue(errorMessage.get().startsWith("Usage:"));
    }

    @Test
    public void checkTaskValidityAlertsOnInvalidContestNames() {
        var coordinates = new String[] {"", "1", "a"};

        String[] names = {
                "",
                " ",
                "x",
                "xx",
                "xxx",
                "xxxx",
                "x x",
                "a",
                "ab",
                "ac",
                "abx",
                "axc",
                "axxc"
        };

        for (String name: names) {
            coordinates[0] = name;

            Optional<String> errorMessage =
                    App.checkTaskValidity(coordinates);

            assertTrue(errorMessage.isPresent());
            assertTrue(errorMessage.get().startsWith("""
                Invalid argument for "contest type abbreviation"\
                """
            ));
        }
    }

    @Test
    public void checkTaskValidityAlertsOnInvalidNumber() {
        String[] coordinates = {"abc", "", "a"};

        String[] numbers = {
                "-1",
                "0",
                "01",
                ""
        };

        for (String number: numbers) {
            coordinates[1] = number;

            Optional<String> errorMessage =
                    App.checkTaskValidity(coordinates);

            assertTrue(errorMessage.isPresent());
            assertTrue(errorMessage.get().startsWith(
                    "Invalid argument for \"number\""
            ));
        }
    }

    @Test
    public void checkTaskValidityAlertsOnInvalidLetter() {
        String[] coordinates = {"abc", "1", ""};

        String[] nonLetters = {
                "",
                "0",
                "10",
                "aa",
                "a1",
                "1a"
        };

        for (String nonLetter: nonLetters) {
            coordinates[2] = nonLetter;

            Optional<String> errorMessage =
                    App.checkTaskValidity(coordinates);

            assertTrue(errorMessage.isPresent());
            assertTrue(errorMessage.get().startsWith("""
                    Invalid argument for "task letter"\
                    """)
            );
        }
    }

    @Test
    public void checkTaskValidityAcceptsNames() {
        String[] coordinates = {"", "1", "a"};

        String[] names = {
                "abc",
                "arc",
                "agc"
        };

        for (String name: names) {
            coordinates[0] = name;

            Optional<String> errorMessage =
                    App.checkTaskValidity(coordinates);

            assertTrue(errorMessage.isEmpty());
        }
    }
}
