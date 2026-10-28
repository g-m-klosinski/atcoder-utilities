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
}
